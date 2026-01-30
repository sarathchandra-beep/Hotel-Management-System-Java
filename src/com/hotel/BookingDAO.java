package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookingDAO {

    // Book a room
    public void bookRoom(int customerId, int roomId, LocalDate checkIn, LocalDate checkOut) {

        try {
            Connection con = DBConnection.getConnection();

            // get room price
            String priceQuery = "SELECT price FROM room WHERE room_id=? AND status='Available'";
            PreparedStatement ps1 = con.prepareStatement(priceQuery);
            ps1.setInt(1, roomId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Room not available");
                return;
            }

            double pricePerDay = rs.getDouble("price");
            long days = ChronoUnit.DAYS.between(checkIn, checkOut);
            double totalAmount = days * pricePerDay;

            // insert booking
            String bookingSql = "INSERT INTO booking (customer_id, room_id, check_in, check_out, total_amount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps2 = con.prepareStatement(bookingSql);

            ps2.setInt(1, customerId);
            ps2.setInt(2, roomId);
            ps2.setDate(3, java.sql.Date.valueOf(checkIn));
            ps2.setDate(4, java.sql.Date.valueOf(checkOut));
            ps2.setDouble(5, totalAmount);

            ps2.executeUpdate();

            // update room status
            String updateRoom = "UPDATE room SET status='Booked' WHERE room_id=?";
            PreparedStatement ps3 = con.prepareStatement(updateRoom);
            ps3.setInt(1, roomId);
            ps3.executeUpdate();

            con.close();

            System.out.println("Room booked successfully");
            System.out.println("Total amount: " + totalAmount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Checkout room
    public void checkoutRoom(int roomId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE room SET status='Available' WHERE room_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roomId);

            ps.executeUpdate();
            con.close();

            System.out.println("Checkout completed. Room is now available.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
