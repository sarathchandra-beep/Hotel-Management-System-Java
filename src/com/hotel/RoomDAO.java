package com.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomDAO {

    // Add new room
    public void addRoom(int roomId, String roomType, double price, String status) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO room VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roomId);
            ps.setString(2, roomType);
            ps.setDouble(3, price);
            ps.setString(4, status);

            ps.executeUpdate();
            con.close();

            System.out.println("Room added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all rooms
    public void viewRooms() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM room";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("RoomID | Type | Price | Status");
            System.out.println("-------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("room_id") + " | " +
                                rs.getString("room_type") + " | " +
                                rs.getDouble("price") + " | " +
                                rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update room status
    public void updateRoomStatus(int roomId, String status) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE room SET status=? WHERE room_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, roomId);

            ps.executeUpdate();
            con.close();

            System.out.println("Room status updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
