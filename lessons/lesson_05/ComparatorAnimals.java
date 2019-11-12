package lesson_05;

import lesson_02.Person;
import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorAnimals implements Comparator<Animal> {

    public int compare(Animal o1, Animal o2) {
        //System.out.println(o1.getName().toString() + o2.getName().toString() + o1.getName().compareTo(o2.getName()));
        if (o1.getName().compareTo(o2.getName()) < 0
                || o1.getName().compareTo(o2.getName()) <= 0 && o1.getWeight() < o2.getWeight()
                || o1.getName().compareTo(o2.getName()) == 0 && o1.getWeight() < o2.getWeight()) {
                return -1;
        }
        else {
            return 1;
        }



    }


}
