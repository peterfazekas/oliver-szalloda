package hu.hotel.controller;

import hu.hotel.model.domain.Book;

import java.util.List;

public class HotelService {

    private List<Book> bookings;

    public HotelService(List<Book> bookings) {
        this.bookings = bookings;
    }

    public int getBooksCount() {
        return bookings.size();
    }
}
