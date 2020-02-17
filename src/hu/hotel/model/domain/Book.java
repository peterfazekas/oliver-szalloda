package hu.hotel.model.domain;

public class Book {

    private final int id;
    private final int room;
    private final int arrival;
    private final int departure;
    private final int numberOfGuest;
    private final boolean breakfast;
    private final String name;

    public Book(int id, int room, int arrival, int departure, int numberOfGuest, boolean breakfast, String name) {
        this.id = id;
        this.room = room;
        this.arrival = arrival;
        this.departure = departure;
        this.numberOfGuest = numberOfGuest;
        this.breakfast = breakfast;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getRoom() {
        return room;
    }

    public int getArrival() {
        return arrival;
    }

    public int getDeparture() {
        return departure;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public String getName() {
        return name;
    }
}
