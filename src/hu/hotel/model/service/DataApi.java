package hu.hotel.model.service;

import hu.hotel.model.domain.Book;

import java.util.List;

public class DataApi {

    private final FileReader fileReader;
    private final DataParser dataParser;

    public DataApi(FileReader fileReader, DataParser dataParser) {
        this.fileReader = fileReader;
        this.dataParser = dataParser;
    }

    public List<Book> getBookings(String input) {
        return dataParser.parse(fileReader.read(input));
    }
}
