package lesson_09;

/**
 * Класс для добавления строк
 */
public class WorkerClass implements Worker {

    static {
        System.out.println("init class");
    }

    @Override
    public void doWork() {
        System.out.println("run method");
        //TODO: new lines
		System.out.println(123456);;

    }


}
