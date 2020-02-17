package hu.hotel;

import hu.hotel.controller.HotelService;
import hu.hotel.model.service.DataApi;
import hu.hotel.model.service.DataParser;
import hu.hotel.model.service.FileReader;

public class App {

    private final HotelService hotelService;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        hotelService = new HotelService(dataApi.getBookings("pitypang.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: ");
        System.out.println(hotelService.getBooksCount());
    }
}
