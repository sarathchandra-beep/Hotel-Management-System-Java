package com.hotel;

import java.time.LocalDate;

public class Booking {

    private int bookingId;
    private int customerId;
    private int roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalAmount;

    public Booking(int bookingId, int customerId, int roomId,
                   LocalDate checkIn, LocalDate checkOut, double totalAmount) {

        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
