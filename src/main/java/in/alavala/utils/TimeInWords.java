package in.alavala.utils;

import java.util.HashMap;
import java.util.Map;

public class TimeInWords {

    static Map<Integer, String> numberLabels = NumberUtils.labels;


    static String minutesPast(int i) {
        return numberLabels.get(i) + " minutes past";
    }

    static String minutesTo(int i) {
        return numberLabels.get(60 - i) + " minutes to";
    }

    static Map<Integer, String> timLabels = new HashMap<Integer, String>() {{
        put(0, "o' clock");
        put(1, "one minute past");
        for (int i = 2; i < 15; i++) {
            put(i, minutesPast(i));
        }
        put(15, "quarter past");
        for (int i = 16; i < 30; i++) {
            put(i, minutesPast(i));
        }
        put(30, "half past");
        for (int i = 31; i < 45; i++) {
            put(i, minutesTo(i));
        }
        put(45, "quarter to");
        for (int i = 46; i < 60; i++) {
            put(i, minutesTo(i));
        }
    }};

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if (m == 0) {
            return numberLabels.get(h) + " " + timLabels.get(m);
        } else if (m <= 30) {
            return timLabels.get(m) + " " + numberLabels.get(h);
        } else if (h == 12) {
            return timLabels.get(m) + " " + numberLabels.get(1);
        } else {
            return timLabels.get(m) + " " + numberLabels.get(h + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(timeInWords(5, 27));
    }
}
