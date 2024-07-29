package com.imsi_retriever;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IMSI_RETRIEVER {

    private static final Logger logger = Logger.getLogger(IMSI_RETRIEVER.class.getName());

    //GetOldImsi function
    public String getOldImsi(String msisdn, String newImsi, Connection conn) {
        String oldImsi = null;
        String query = "SELECT imsi FROM active_msisdn_list WHERE msisdn = ?";
        logger.info("Executing query: " + query);

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, msisdn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String foundImsi = rs.getString("imsi");
                    if(!foundImsi.equals(newImsi)){
                    oldImsi = foundImsi;
}
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error querying active_msisdn table", e);
        }

        if (oldImsi == null) {
            // Update the query to fetch the latest entry
            query = "SELECT imsi FROM active_msisdn_list_his WHERE msisdn = ? ORDER BY id DESC LIMIT 1";
            logger.info("Executing query: " + query);

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, msisdn);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String foundImsi = rs.getString("imsi");

                        oldImsi = foundImsi;


                    }
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error querying active_msisdn_list table", e);
            }
        }

        logger.info("Returning old IMSI: " + (oldImsi != null ? oldImsi : "No old IMSI found or IMSI matches the new one."));
        return oldImsi;
    }

    //GetIMSI function
    public static String getImsi(String msisdn, Connection conn) {
        String imsi = "";

        String query = "SELECT imsi FROM active_msisdn_list WHERE msisdn = ?";
        logger.info("Executing query: " + query);

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, msisdn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    imsi = rs.getString("imsi");
                    return imsi;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error querying active_msisdn_list table", e);
        }
        if (imsi.isEmpty()) {

            query = "SELECT imsi FROM active_msisdn_list_his WHERE msisdn = ? ORDER BY id DESC LIMIT 1";
            logger.info("Executing query: " + query);

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, msisdn);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        imsi = rs.getString("imsi");
                        return imsi;
                    }
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error querying active_msisdn_list_his table", e);
            }
        }

        logger.info("Returning IMSI: " + (imsi.isEmpty() ? "No IMSI found" : imsi));
        return imsi;
    }
}
