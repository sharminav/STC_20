package lesson_06;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {

        String filePath1 = "C://temp//words_sort.txt";

        // тестирование задания №1
        // чтение файла, сортировка слов и запись в новый файл
        SaveTextToFile.saveTextToFileArrayList(filePath1, SortFile.getWords(), "\r\n");

        // тестирование задания №2.1
        // генерация случайного текста и сохранеие в файл
        String filePath2 = "C://temp//generateText.txt";
        SaveTextToFile.saveTextToFileArrayList(filePath2, new TextGenerator().generateText((int)(Math.random() * 13) + 1), "");


    }
}
