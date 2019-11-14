package lesson_06;

import java.util.Comparator;

public class ComparatorWord implements Comparator<String> {

    public int compare(String o1, String o2) {
        if (o1.compareTo(o2) < 0) {
            return -1;
        }
        return 1;
    }
}
