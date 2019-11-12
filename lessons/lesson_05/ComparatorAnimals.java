package lesson_05;

import java.util.Comparator;

public class ComparatorAnimals implements Comparator<Animal> {

    public int compare(Animal o1, Animal o2) {
        if (o1.getOwnerName().compareTo(o2.getOwnerName()) < 0
                || o1.getOwnerName().compareTo(o2.getOwnerName()) <= 0 && o1.getName().compareTo(o2.getName()) < 0
                || o1.getOwnerName().compareTo(o2.getOwnerName()) <= 0 && o1.getName().compareTo(o2.getName()) <= 0 && o1.getWeight() < o2.getWeight()) {
                return -1;
        }
        else {
            return 1;
        }



    }


}
