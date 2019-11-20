package lesson_06;

import java.io.FileInputStream;
import java.util.*;
import java.io.IOException;

/**
 * @author SharminAleksei
 * Класс считывает текстовый файл, разбивает его на слова, сортирует слова и сохранеят в новый файл
 */
public class SortFile {

    /**
     * Получение отсортированного списка уникальных слов
     * @return отсортированный список уникальных слов
     */
    public static NavigableSet<String> getWords() {
        String wordsString = readFromFile();
        wordsString = wordsString.replace("\r\n", " ");
        NavigableSet<String>  result = getSortArrayList(wordsString);
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
    private static NavigableSet<String> getSortArrayList(String wordsString) {

        //List<String> result = new ArrayList<>();
        String[] wordsArray = wordsString.split(" ");
        NavigableSet<String> treeSetWords = new TreeSet<>();


        // Используем HashMap для получения только УНИКАЛЬНЫХ слов
        //Map<String, String> wordsHashMap = new HashMap<>();
        for (int i = 0; i < wordsArray.length; i++) {
           // wordsHashMap.put(wordsArray[i].toUpperCase(), wordsArray[i].toUpperCase());
            treeSetWords.add(wordsArray[i].toUpperCase());
        }
        // Используем ArrayList для сортировки с использоваение интерфейса Comparator
        //for (Map.Entry<String, String> entry : wordsHashMap.entrySet()) {
        //    result.add(entry.getValue().toUpperCase());
        //}
        //result.sort(new ComparatorWord());

        return treeSetWords;
    }
}



