package lesson_06;

import java.util.UUID;

/**
 * ЗАДАНИЕ №1. Написать программу, читающую текстовый файл. Программа должна составлять отсортированный по алфавиту список слов, найденных
 * в файле и сохранять его в файл-результат. Найденные слова не должны повторяться,
 * регистр не должен учитываться. Одно слово в разных падежах – это разные слова.
 *
 * ЗАДАНИЕ №2. Создать генератор текстовых файлов, работающий по следующим правилам:
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability), который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */

public class Test {

    public static void main(String[] args) {

        String filePath1 = "C://temp//words_sort.txt";

        // тестирование задания №1
        // чтение файла, сортировка слов и запись в новый файл
        SaveTextToFile.saveTextToFileArrayList(filePath1, SortFile.getWords(), "\r\n");

        // тестирование задания №2.1
        // генерация случайного текста и сохранеие в файл
        String filePath2 = "C://temp";
        String[] words = TextGenerator.wordsGenerator();
        getFiles(filePath2, 3, 2, words, 2);
    }

    private static void  getFiles(String path, int n, int size, String[] words, int probability) {
        for (int i = 0; i < n; i++) {
            SaveTextToFile.saveTextToFileArrayList(path + "//generateText_" + i + ".txt", new TextGenerator().generateText(size, (double)1/probability, words), "");
        }
    }
}
