package hu.hotel;

import hu.hotel.controller.HotelService;
import hu.hotel.model.service.DataApi;
import hu.hotel.model.service.DataParser;
import hu.hotel.model.service.FileReader;
import hu.hotel.model.service.FileWriter;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class App {

    private final HotelService hotelService;
    private final FileWriter fileWriter;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        hotelService = new HotelService(dataApi.getBookings("pitypang.txt"));
        fileWriter = new FileWriter("bevetel.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: ");
        System.out.println(hotelService.getLongestStayDetails());
        fileWriter.write(hotelService.getPrices());
        System.out.println("3. feladat: ");
        System.out.println("A szálloda éves bevétele: " + hotelService.getTotalPrice());
        System.out.println("4. feladat: ");
        System.out.println(hotelService.getTotalGuestNightsDetails());
    }
}
