package lesson_02;

/**
 * Класс Сортировки
 */
public class SortBubble implements SortPerson {

    public static void order(Person[] persons) throws Exception {

        long start = System.currentTimeMillis();
        for (int j = 0; j < persons.length; j++) {
            for (int i = j + 1; i < persons.length; i++) {
                if (persons[i].sex.toString().compareTo(persons[j].sex.toString()) < 0) {
                    Person k = persons[j];
                    persons[j] = persons[i];
                    persons[i] = k;
                }
            }
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
        System.out.println("Пузырьковая сортировка - " + timeConsumedMillis);

    }

    private static void SortByAge (Person[] persons, int startPos, int endPos) {
        for (int j = startPos; j < endPos; j++) {
            for (int i = j + 1; i < endPos; i++) {
                //System.out.println(persons[i].age + " - " + persons[j].age);
                if (persons[i].age < persons[j].age) {
                    Person k = persons[j];
                    persons[j] = persons[i];
                    persons[i] = k;
                }
            }
        }
    }

    private static void SortByName (Person[] persons, int startPos, int endPos) throws Exception {
        for (int j = startPos; j < endPos; j++) {
            for (int i = j + 1; i < endPos; i++) {
                if (persons[i].name.compareTo(persons[j].name) < 0) {
                    Person k = persons[j];
                    persons[j] = persons[i];
                    persons[i] = k;
                }
            }
        }
    }
}
