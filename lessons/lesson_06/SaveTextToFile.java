package lesson_06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sharmin Aleksei
 * Класс для создания текстовых файлов
 */
public class SaveTextToFile {

    /**
     * Сохранение ArrayList в файл
     * @param filePath адрес и имя файла
     * @param text ArrayList для сохранения в файл
     */
    public static void saveTextToFileArrayList(String filePath, ArrayList<String> text, String separator) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            for (String str : text) {
                str = str + separator;
                byte[] buffer = str.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            System.out.println("Успешная запись в файл: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
