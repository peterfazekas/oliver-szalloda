package hu.hotel;

import hu.hotel.controller.HotelService;
import hu.hotel.model.service.*;

import java.util.Scanner;

public class App {

    private final HotelService hotelService;
    private final FileWriter fileWriter;
    private final Console console;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        hotelService = new HotelService(dataApi.getBookings("pitypang.txt"));
        fileWriter = new FileWriter("bevetel.txt");
        console = new Console(new Scanner(System.in));
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
        System.out.println("5. feladat:");
        System.out.print("Kérem adja meg az érkezési nap sorszámát [1-364]: ");
        int arrival = console.readInt();
        System.out.print("Kérem adja meg az eltöltendő éjszakák számát [>0]: ");
        int stay = console.readInt();
        System.out.println("A rendelkezésre álló szabad szobák száma: " + hotelService.getFreeRoomsCountForDayInterval(arrival, stay));
    }
}
