package lesson_09;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Класс для компиляции java файла
 * Пример адреса: E:\YandexDisk\АБЦТ_моя\Обучение\Java_2019\STC_20\lessons\lesson_09\WorkerClass.java
 */
public class Compile {

    public static void compileFile (String fileName) {
        try {
            System.out.println("start compile class");
            File root = new File("/java");
            // Compile source file.
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, fileName);

            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            Class<?> cls = Class.forName("lesson_09.SomeClass", true, classLoader); // Should print "hello".
            Object instance = cls.newInstance(); // Should print "world".
            System.out.println("compile success");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

}
