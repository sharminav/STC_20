package lesson_09;

/**
 * Р В РЎв„ўР В Р’В»Р В Р’В°Р РЋР С“Р РЋР С“ Р В РўвЂ�Р В Р’В»Р РЋР РЏ Р В РўвЂ�Р В РЎвЂўР В Р’В±Р В Р’В°Р В Р вЂ Р В Р’В»Р В Р’ВµР В Р вЂ¦Р В РЎвЂ�Р РЋР РЏ Р В РЎвЂќР В РЎвЂўР В РўвЂ�Р В Р’В° Р В РЎвЂ� Р РЋР вЂљР В Р’В°Р В Р вЂ¦Р РЋРІР‚С™Р В Р’В°Р В РІвЂћвЂ“Р В РЎпїЅ Р В РЎвЂќР В РЎвЂўР В РЎпїЅР В РЎвЂ”Р В РЎвЂ�Р В Р’В»Р РЋР РЏР РЋРІР‚В Р В РЎвЂ�Р В РЎвЂ�
 */
public class WorkerClass implements Worker {

    static {
        System.out.println("init class");
    }

    @Override
    public void doWork() {
        System.out.println("run method");
        //TODO: new lines
		System.out.println(70 + 150 * 2);

		System.out.println(100 + 150);

    }


}
