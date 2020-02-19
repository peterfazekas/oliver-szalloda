package hu.hotel.model.service;

public enum Price {

    SPRING(1, 9000),
    SUMMER(121, 10000),
    FALL(244, 8000),
    BREAKFAST(1, 1100),
    EXTRA_BED(3, 2000);

    private final int id;
    private final int price;

    Price(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
