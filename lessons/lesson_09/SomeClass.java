package lesson_09;

/**
 * Класс для добавления строк
 */
public class SomeClass implements Worker {

    static {
        System.out.println("init class");
    }

    @Override
    public void doWork() {
        System.out.println("run method");
        //TODO: new lines
		int i = 100;
		System.out.println(i + 1);


    }


}
