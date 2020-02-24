package hu.hotel.controller;

import hu.hotel.model.domain.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HotelService {

    private List<Book> bookings;

    public HotelService(List<Book> bookings) {
        this.bookings = bookings;
    }

    /**
     * 2. feldaat
     */
    public String getLongestStayDetails() {
        Book longestStay = getLongestStay();
        return String.format("%s (%d) - %d", longestStay.getName(), longestStay.getArrival(), longestStay.getDuration());
    }

    private Book getLongestStay() {
        return bookings.stream()
                .max(Comparator.comparing(Book::getDuration))
                .get();
    }

    /**
     * 3. feladat
     */
    public List<String> getPrices() {
        return bookings.stream()
                .map(book -> book.getId() + ":" + book.getTotalPrice())
                .collect(Collectors.toList());
    }

    public int getTotalPrice() {
        return bookings.stream()
                .mapToInt(Book::getTotalPrice)
                .sum();
    }

    /**
     * 4. feladat
     */

    public String getTotalGuestNightsDetails() {
        return getTotalGuestNights().entrySet().stream()
                .map(i -> i.getKey() + ": " + i.getValue() + " vendégéj")
                .collect(Collectors.joining("\r\n"));
    }

    private Map<Integer, Integer> getTotalGuestNights() {
        Map<Integer, Integer> totalGuestNights = new TreeMap<>();
        for(var book : bookings) {
            Map<Integer, Integer> guestNightMap = book.getGuestNightMap();
            for (var guestNight : guestNightMap.entrySet()) {
                int base = totalGuestNights.containsKey(guestNight.getKey()) ? totalGuestNights.get(guestNight.getKey()) : 0;
                int value = base + guestNight.getValue();
                totalGuestNights.put(guestNight.getKey(), value);
            }
        }
        return totalGuestNights;
    }

    /**
     * 5. feladat.
     */

    public long getFreeRoomsCountForDayInterval(int arrival, int stay) {
        int departure = arrival + stay;
        return 27L - getOccupiedRoomCount(arrival, departure);
    }

    private long getOccupiedRoomCount(int arrival, int departure) {
        return bookings.stream()
                .filter(book -> book.getDeparture() >= arrival && book.getArrival() < departure)
                .map(Book::getRoom)
                .distinct()
                .count();
    }


}
