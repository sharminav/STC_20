package lesson_06;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SharminAleksei
 * Класс считывает текстовый файл, разбивает его на слова, сортирует слова и сохранеят в новый файл
 */
public class SortFile {

    /**
     * Получение отсортированного списка уникальных слов
     * @return отсортированный список уникальных слов
     */
    public static ArrayList<String> getWords() {
        ArrayList<String> result = new ArrayList<String>();
        String wordsString = readFromFile();
        wordsString = wordsString.replace("\r\n", " ");
        result = getSortArrayList(wordsString);
        return result;
    }

    /**
     * Чтение данных из файла
     * @return содержимое файла в виде строки (без символов перевода строки)
     */
    private static String readFromFile() {
        String result = "";
        try (FileInputStream fin = new FileInputStream("C://temp//words.txt")) {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            result = new String(buffer, "Windows-1251");
            // записываем из буфера в файл
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * Получение списка уникальных слов и их сортировка
     * @param wordsString слова из файла
     * @return отсортирванный список уникальных слов
     */
    private static ArrayList<String> getSortArrayList(String wordsString) {
        ArrayList<String> result = new ArrayList<String>();
        String[] wordsArray = wordsString.split(" ");

        // Используем HashMap для получения только УНИКАЛЬНЫХ слов
        HashMap<String, String> wordsHashMap = new HashMap<String, String>();
        for (int i = 0; i < wordsArray.length; i++) {
            wordsHashMap.put(wordsArray[i].toUpperCase(), wordsArray[i].toUpperCase());
        }

        // Используем ArrayList для сортировки с использоваение интерфейса Comparator
        for (Map.Entry<String, String> entry : wordsHashMap.entrySet()) {
            result.add(entry.getValue().toUpperCase());
        }
        result.sort(new ComparatorWord());

        return result;
    }
}



