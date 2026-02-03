package com.ems.main;

import com.ems.util.DBConnection;

public class TestConnection {
    public static void main(String[] args) {

        if (DBConnection.getConnection() != null) {
            System.out.println("Database Connected Successfully");
        } else {
            System.out.println("Database Connection Failed");
        }
    }
}
