package lesson_09;


import java.util.List;


/**
 * Дан интерфейс
 *  public interface Worker {
 *      void doWork();
 * }
 *
 * Необходимо написать программу, выполняющую следующее:
 * 1. Программа с консоли построчно считывает код метода doWork. Код не должен требовать импорта дополнительных классов.
 * 2. После ввода пустой строки считывание прекращается и считанные строки добавляются в тело метода public void doWork() в файле SomeClass.java.
 * 3. Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * 4. Полученный файл подгружается в программу с помощью кастомного загрузчика
 * 5. Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 */
public class Test {

    private final static String fileName =  "E:\\YandexDisk\\АБЦТ_моя\\Обучение\\Java_2019\\STC_20\\lessons\\lesson_09\\SomeClass.java";
    //private final static String fileName =  "C:\\temp\\WorkerClass.java";

    public static void main(String[] args) throws Exception {
        System.out.println("start program");

        // чтение исходного кода файла
        String fileStrings = Service.readFromFile();

        // чтение новых строк кода с консоли
        List<String> newRows = Service.getCode();

        // добавление новых строк кода в файл
        String newFile = Service.replaceInFile(newRows, fileStrings);

        // сохранение файла
        Service.saveTextToFile(fileName, newFile.getBytes());

        // компиляция файла
        Compile.compileFile(fileName);

        // загрузка файла и выполнение
        useCustomClassLoader();

        System.out.println("end program");

        //while (true) {
            //LockSupport.parkNanos(5_000_0000_00L);
            //useCustomClassLoader();
        //}
    }

    /**
     * Вызов загрузчика файла
     * @throws Exception
     */
    private static void useCustomClassLoader() throws Exception {
        System.out.println("start loader");
        ClassLoader cl = new MyClassLoader();
        Class<?> workClass = cl.loadClass("lesson_09.SomeClass");
        workClass.getMethod("doWork").invoke(workClass.newInstance());
        //Worker worker = (Worker) workClass.newInstance();
        //worker.doWork();
        System.out.println("end loader");
    }



}
