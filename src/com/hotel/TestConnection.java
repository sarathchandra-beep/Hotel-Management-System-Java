package com.hotel;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Hotel DB Connected Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
