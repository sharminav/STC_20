package lesson_08;

import java.io.FileOutputStream;
import java.io.IOException;

class SaveObjectToFile {

    /**
     * Запись файла
     * @param fos FileOutputStream для записи
     * @param field строка для записи в файл
     * @throws IOException
     */
    public static void save(FileOutputStream fos, String field)  {
        try {
            byte[] buffer = (field).getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());}

    }

}
