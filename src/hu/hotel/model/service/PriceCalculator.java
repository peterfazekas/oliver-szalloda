package hu.hotel.model.service;

import hu.hotel.model.domain.Book;

public class PriceCalculator {

    public static int getTotalPrice(Book book) {
        int baseRoomPrice = getSeasonPrice(book.getArrival());
        int roomPrice = book.getDuration() * baseRoomPrice;
        int extraBedPrice = getExtraBedPrice(book);
        int breakfastPrice =  getBreakfastPrice(book);
        return roomPrice + extraBedPrice + breakfastPrice;
    }

    private static int getSeasonPrice(int arrival) {
        Price season;
        if (arrival >= Price.SPRING.getId() &&  arrival < Price.SUMMER.getId()) {
            season = Price.SPRING;
        } else if (arrival >= Price.SUMMER.getId() &&  arrival < Price.FALL.getId()) {
            season = Price.SUMMER;
        } else {
            season = Price.FALL;
        }
        return season.getPrice();
    }

    private static int getExtraBedPrice(Book book) {
        return book.getNumberOfGuest() >= Price.EXTRA_BED.getId() ? Price.EXTRA_BED.getPrice() * book.getDuration() : 0;
    }

    private static int getBreakfastPrice(Book book) {
        return book.isBreakfast() ? book.getNumberOfGuest() * Price.BREAKFAST.getPrice() * book.getDuration(): 0;
    }
}
