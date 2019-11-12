package lesson_05;

import java.util.*;
import lesson_02.task3;

public class Test {

    static List<Animal> animalList = new ArrayList<Animal>();
    static UUID dublicateUUID = UUID.randomUUID();
    static HashMap<UUID, Animal> animalHashMap = new HashMap<UUID, Animal>();

    public static void main(String[] args) throws Exception {

        UUID animalUUID = null;
        UUID uuidChange = null;
        String nameFind = null;

        // Начальное заполнение списка
        for (Integer i = 0; i < 10; i++) {
            Animal tempAnimal = new Animal();
            // Случайное заполнение
            animalUUID = UUID.randomUUID();
            tempAnimal = generateAnimal();

            // Для тестирования ошибки при добавлении повторяющегося животного
            //tempAnimal.id = dublicateUUID;
            //tempAnimal.name = "animal";
            //tempAnimal.weight = 100.00;

            addAnimal(animalUUID, tempAnimal);

            // Сохранение идентификатора и имени для изменения и поиска животного
            if (i == 1) {
                uuidChange = animalUUID;
                nameFind = tempAnimal.name;
            }
        }

        // Печать начального списка
        System.out.println("Начальный список: ");
        print();

        // Изменение животного
        changeAnimal(uuidChange);

        // Поиск животного
        findAnimal(nameFind);

        // Печать сортированного списка
        sort();


    }

    /**
     * Добавление животного в список с проверкой возможности добавления
     * @param animal добавляемое в список животное
     * @exception исключительная ситуация при добалении повторяющегося животного
     */
    private static void addAnimal(UUID animalUUID, Animal animal) throws Exception {
        if (!animalHashMap.containsKey(animalUUID)) {
            animalHashMap.put(animalUUID, animal);
        }
        else {
            throw new Exception("Добавление повторяющегося животного");
        }
    }

    /**
     * Печать коллекции животных
     */
    private static void print() {
        for (Map.Entry<UUID, Animal> entry : animalHashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue().toString());
        }
    }

    /**
     * Обновление данных о животном по ID
     * @param aninalUUID идентификатор для изменения животного
     */
    private static void changeAnimal(UUID animalUUID) {
        System.out.println("\nИзменение животного");
        // поиск животного по id
        System.out.println("ID для изменения животного - " + animalUUID.toString());
        Animal changeAnimal = animalHashMap.get(animalUUID);

        // генерация новых значений
        System.out.println("Начальное животное - " + changeAnimal.toString());
        changeAnimal = generateAnimal();
        System.out.println("Измененное животное - " + changeAnimal.toString());

        // изменение животного в коллекции
        animalHashMap.put(animalUUID, changeAnimal);
    }

    /**
     * Поиск животного по имени
     * @param nameFind имя для поиска животного
     */
    private static void findAnimal(String nameFind) {
        System.out.println("\nПоиск животного");
        System.out.println("Имя для поиска животного - " + nameFind.toString());
        for (Map.Entry<UUID, Animal> entry : animalHashMap.entrySet()) {
            if (entry.getValue().getName().equals(nameFind)) {
                System.out.println("Найденное животное - "  + entry.toString());
            }
        }
    }

    /**
     * Сортрировка и печать коллекци животных
     */
    private static void sort(){
        System.out.println("\nСортировка списка");
        Collection<Animal> animalCollection = animalHashMap.values();
        ArrayList<Animal> animalArrayList = new ArrayList<>(animalCollection);
        animalArrayList.sort(new ComparatorAnimals());
        for (Animal entry: animalArrayList) {
            System.out.println(entry.toString());
        }
    }

    /**
     * Генерация нового животного
     * @return новое животное
     */
    private static Animal generateAnimal(){
        Animal result = new Animal();
        result.name = "animal" + (int)(Math.random() * 10);
        result.weight = (int)(Math.random() * 10);
        result.owner = task3.getPerson();
        return result;
    }
}
