package com.hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoomDAO roomDAO = new RoomDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true) {
            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Checkout Room");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Room ID: ");
                    int roomId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Room Type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter Price per day: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Status (Available/Booked): ");
                    String status = sc.next();

                    roomDAO.addRoom(roomId, type, price, status);
                    break;

                case 2:
                    roomDAO.viewRooms();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Enter Room ID: ");
                    int bookRoomId = sc.nextInt();

                    System.out.print("Enter Check-in date (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(sc.next());

                    System.out.print("Enter Check-out date (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(sc.next());

                    bookingDAO.bookRoom(customerId, bookRoomId, checkIn, checkOut);
                    break;

                case 4:
                    System.out.print("Enter Room ID to checkout: ");
                    int checkoutRoomId = sc.nextInt();

                    bookingDAO.checkoutRoom(checkoutRoomId);
                    break;

                case 5:
                    System.out.println("Thank you for using Hotel Management System");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
