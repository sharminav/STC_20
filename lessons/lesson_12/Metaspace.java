package lesson_12;

/**
 * https://plumbr.io/outofmemoryerror/metaspace
 * https://www.javamadesoeasy.com/2017/02/outofmemoryerror-metaspace-solved.html
 * Генерирует ошибку Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
 */

public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("ru.innopolis.stc20." + i).toClass();
            System.out.println(c.getName());
        }
    }
}