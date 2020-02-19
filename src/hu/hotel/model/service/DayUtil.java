package hu.hotel.model.service;

public class DayUtil {

    private static final int[] MONTHS = {0, 1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 367};

    public static int getMonth(int day) {
        int month = 0;
        while (!(day >= MONTHS[month] && day < MONTHS[month + 1])) {
            month++;
        }
        return month;
    }
}
