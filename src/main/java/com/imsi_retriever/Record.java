package com.imsi_retriever;

public class Record {
    private String imsi;
    private String msisdn;
    private String date;
    public Record(String imsi, String msisdn, String date) {
        this.imsi = imsi;
        this.msisdn = msisdn;
        this.date = date;
    }

    public String getImsi() {
        return imsi;
    }

    public String getMsisdn() {
        return msisdn;
    }
    public String getDate() {
        return date; // Getter for the date field
    }
}
