package lesson_09;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.ClassLoader;

/**
 * Загрузчик классов
 */
public class MyClassLoader extends ClassLoader {

    private final String filePath = "E:\\YandexDisk\\АБЦТ_моя\\Обучение\\Java_2019\\STC_20\\lessons\\lesson_09\\WorkerClass.class";
    //private final String filePath = "C:\\temp\\WorkerClass.class";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("lesson_09.WorkerClass".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("lesson_09.WorkerClass".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(filePath));
                System.out.println("findClass success");
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }

}


