package lesson_02;

/**
 * Класс Сортиировки вставкой
 */

public class SortInsert implements SortPerson {

    public static void order(Person[] persons) {

        long start = System.currentTimeMillis();
        for (int left = 0; left < persons.length; left++) {
            // Вытаскиваем значение элемента
            Person value = persons[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value.sex.toString().compareTo(persons[i].sex.toString()) < 0) {
                    persons[i + 1] = persons[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            persons[i + 1] = value;
        }

        String sex = persons[0].sex.toString();
        int startPos = 0;
        int endPos = 0;
        for (var i = 0; i < persons.length; i++) {
            if ((sex.compareTo(persons[i].sex.toString()) != 0)) {
                endPos = i;
                SortByAge(persons, startPos, endPos);
                startPos = endPos;
                sex = persons[i].sex.toString();
            }
        }
        SortByAge(persons, startPos, persons.length);

        Integer age = persons[0].age;
        startPos = 0;
        endPos = 0;
        for (var i = 0; i < persons.length; i++) {
            if (age != persons[i].age) {
                endPos = i;
                SortByName(persons, startPos, endPos);
                startPos = endPos;
                age = persons[i].age;
            }
        }
        SortByName(persons, startPos, persons.length);

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("Сортировка вставками - " + timeConsumedMillis);

    }

    private static void SortByAge (Person[] persons, int startPos, int endPos) {
        for (int left = startPos; left < endPos; left++) {
            Person value = persons[left];
            int i = left - 1;
            for (; i >= startPos; i--) {
                if (value.age < persons[i].age) {
                    persons[i + 1] = persons[i];
                } else {
                    break;
                }
            }
            persons[i + 1] = value;
        }
    }

    private static void SortByName (Person[] persons, int startPos, int endPos) {
        for (int left = startPos; left < endPos; left++) {
            // Вытаскиваем значение элемента
            Person value = persons[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= startPos; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value.name.compareTo(persons[i].name) < 0) {
                    persons[i + 1] = persons[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            persons[i + 1] = value;
        }
    }
}
