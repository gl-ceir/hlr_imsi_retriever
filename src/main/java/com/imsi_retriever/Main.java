package com.imsi_retriever;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Main {
    static String addFilePath = "/home/kunal/Desktop/add.txt";
    static String delFilePath = "/home/kunal/Desktop/del.txt";
    static String outputFilePath = "/home/kunal/Desktop/hlr_deactivation.txt";

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Establish database connection
        /*        Connection conn = getConnection();*/
/*        if (conn == null) {
            logger.severe("Failed to establish database connection.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;*/

/*        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Retrieve IMSI");
            System.out.println("2. Retrieve Old IMSI");
            System.out.println("3. Create Deactivation File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    retrieveIMSI(conn, scanner);
                    break;
*//*                case 2:
                    retrieveOldIMSI(conn, scanner);
                    break;*//*
                case 3:
                    createHLRDeactivationFile(addFilePath, delFilePath, outputFilePath);
                    break;

                case 4:
                    exit = true;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }*/
/*        try {
            conn.close();
            scanner.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error closing database connection or scanner", e);
        }
    }*/

/*    private static Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/mvc";
        String dbUser = "root";
        String dbPassword = "root";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error connecting to database", e);
        }
        return conn;
    }*/

/*    private  void retrieveIMSI(Connection conn, Scanner scanner) {
        System.out.print("Enter MSISDN: ");
        String msisdn = scanner.nextLine();

        String imsi = IMSI_RETRIEVER.getImsi(msisdn, conn);
        if (!imsi.isEmpty()) {
            System.out.println("IMSI for MSISDN " + msisdn + " is: " + imsi);
        } else {
            System.out.println("No IMSI found for MSISDN " + msisdn);
        }
    }*/

/*    private static void retrieveOldIMSI(Connection conn, Scanner scanner) {
        System.out.print("Enter MSISDN: ");
        String msisdn = scanner.nextLine();
        System.out.println("Entr NEW_IMSI");

        String newImsi = scanner.nextLine();
        String oldImsi = IMSI_RETRIEVER.getOldImsi(msisdn, newImsi, conn);
        if (oldImsi != null && !oldImsi.isEmpty()) {
            System.out.println("Old IMSI for MSISDN " + msisdn + " is: " + oldImsi);
        } else {
            System.out.println("No old IMSI found for MSISDN " + msisdn);
        }
    }*/


/*
    private static void createHLRDeactivationFile(String addFilePath, String delFilePath, String outputFilePath) {
        Map<String, Record> addMap = readAddFile(addFilePath);
        Map<String, Record> delMap = readDelFile(delFilePath);

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            String deactivationDate = LocalDate.now().toString(); // Get the current date for deactivation

            for (Map.Entry<String, Record> entry : delMap.entrySet()) {
                String msisdn = entry.getKey();
                Record record = entry.getValue();
                Record addRecord = addMap.get(msisdn);

                if (addRecord != null) {
                    // SIM change entry
                    String oldImsi = record.getImsi();
                    String newImsi = addRecord.getImsi();
                    String simChangeDate = LocalDate.now().toString(); // Get the current date for sim change
                    writer.println(oldImsi + "," + newImsi + "," + msisdn + "," + simChangeDate);
                } else {
                    // HLR deactivation entry
                    String imsi = record.getImsi();
                    writer.println(imsi + "," + msisdn + "," + deactivationDate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Record> readAddFile(String addFilePath) {
        Map<String, Record> addMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(addFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    System.err.println("Invalid line in add file: " + line);
                    continue;
                }
                String msisdn = parts[0].trim();
                String imsi = parts[1].trim();
                String date = parts.length > 2 ? parts[2].trim() : ""; // Handle optional date
                Record record = new Record(imsi, msisdn, date);
                addMap.put(msisdn, record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addMap;
    }

    private static Map<String, Record> readDelFile(String delFilePath) {
        Map<String, Record> delMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(delFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    System.err.println("Invalid line in del file: " + line);
                    continue;
                }
                String msisdn = parts[0].trim();
                String imsi = parts[1].trim();
                String date = parts.length > 2 ? parts[2].trim() : ""; // Handle optional date
                Record record = new Record(imsi, msisdn, date);
                delMap.put(msisdn, record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return delMap;
    }
}



*/


    }}
