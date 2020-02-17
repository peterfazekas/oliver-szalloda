package hu.hotel.model.service;

import hu.hotel.model.domain.Book;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<Book> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::createBook)
                .collect(Collectors.toList());
    }

    private Book createBook(String line) {
        String[] items = line.split(" ");
        int id = getValue(items[0]);
        int room = getValue(items[1]);
        int arrival = getValue(items[2]);
        int departure = getValue(items[3]);
        int numberOfGuest = getValue(items[4]);
        boolean breakfast = getValue(items[5]) == 1;
        String name = items[6];
        return new Book(id, room, arrival, departure, numberOfGuest, breakfast, name);
    }

    private int getValue(String text) {
        return Integer.parseInt(text);
    }
}
