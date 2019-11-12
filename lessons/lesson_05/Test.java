package lesson_05;

import java.util.*;
import lesson_02.task3;

public class Test {

    static ArrayList<Animal> animalList = new ArrayList<Animal>();
    static UUID dublicateUUID = UUID.randomUUID();


    public static void main(String[] args) throws Exception {

        UUID uuidChange = null;
        String nameFind = null;

        // Начальное заполнение списка
        for (Integer i = 0; i < 20; i++) {
            Animal tempAnimal = new Animal();
            // Случайное заполнение
            tempAnimal.id = UUID.randomUUID();
            tempAnimal.name = "animal" + (int)(Math.random() * 10);
            tempAnimal.weight = (int)(Math.random() * 10);
            // Для тестирования ошибки при добавлении повторяющегося животного
            /*tempAnimal.id = dublicateUUID;
            tempAnimal.name = "animal";
            tempAnimal.weight = 100.00;*/
            tempAnimal.owner = task3.getPerson();
            addAnimal(tempAnimal);

            // Сохранение идентификатора и имени для изменения и поиска животного
            if (i == 1) {
                uuidChange = tempAnimal.id;
                nameFind = tempAnimal.name;
            }
        }

        // Печать начального списка
        System.out.println("Начальный список: ");
        print();
        animalList.sort(new ComparatorAnimals());

        // Печать отсортированного списка
        System.out.println("");
        System.out.println("Отсортированный список");
        print();

        // Изменение животного
        System.out.println("");
        changeAnimal(uuidChange);

        // Поиск животного
        System.out.println("");
        findAnimal(nameFind);
    }

    /**
     * Добавление животного в список с проверкой возможности добавления
     */
    private static void addAnimal(Animal animal) throws Exception {
        animal.canAddToCollection(animalList);
        animalList.add(animal);
    }

    private static void print() {
        for (Animal animal: animalList) {
            System.out.println(animal.toString());
        }
    }

    private static void changeAnimal(UUID aninalUUID) {
        for (Animal animal: animalList) {
            if (animal.id == aninalUUID) {
                System.out.println("Начальное животное - " + animal.toString());
                animal.name = "animal" + (int)(Math.random() * 10);
                animal.weight = (int)(Math.random() * 10);
                animal.owner = task3.getPerson();
                System.out.println("Измененное животное - " + animal.toString());
                break;
            }
        }
    }

    private static void findAnimal(String nameFind) {
        for (Animal animal: animalList) {
            if (animal.getName().equals(nameFind)) {
                System.out.println("Найденное животное - " + animal.toString());
                break;
            }
        }
    }

}
