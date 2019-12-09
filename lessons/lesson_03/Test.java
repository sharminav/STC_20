package lesson_03;

/**
 * @author Sharmin Aleksei
 * Класс для тестирования
 * Домашнее задание 2. Тестирование классов
 */
public class Test {

    public static void main(String[] args) {

        // ЗАДАНИЕ 1
        System.out.println("ЗАДАНИЕ №1");
        MathBox mathBox = new MathBox(new Number[]{0, 1, 2, 3, 4, 5});
        System.out.println("Начальная коллекци - " + mathBox.toString());
        System.out.println("Сумма всех элементов - " + mathBox.summator());
        mathBox.deleteObject(3);
        System.out.println("Коллекция после удаления элемента - " + mathBox.toString());
        mathBox.splitter(10);
        System.out.println("Коллекция после деления - " + mathBox.toString());

        // ЗАДАНИЕ 2
        System.out.println("ЗАДАНИЕ №2");
        // создание объекта
        ObjectBox objectBox = new ObjectBox();
        // заполнение объекта
        for (var i = 0; i < 11; i++) {
            objectBox.addObject(i);
        }
        // печать коллекции после заполнения
        objectBox.dumps("Начальная коллекция");
        // удаление элемента из коллекции
        objectBox.deleteObject((int) (Math.random()*10));
        // печать коллекции после удаления
        objectBox.dumps("Коллекция после удаленния эленмента");
    }
}
