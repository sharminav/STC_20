package lesson_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sharmin Aleksei
 * Класс для генерации случайного текста
 */

public class TextGenerator {

    private static String eng = "abcdefghijklmnopqrstuvwxyz";
    private static String last = ".!?";
    private static int arrayLen = 2;

    /**
     * Генерация текста, абзацы текста в ArrayList
     * @param size размер текста в байтах
     * @return абзацы текста в объекие ArrayList
     */
    public static byte[] generateText(int size, double probability, String[] words) {

        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.toString().getBytes().length < size) {
            String paragraph = generateParagraph((int)(Math.random() * 13 + 1), probability, words);
            stringBuilder.append(paragraph).append("\n\r");
            //System.out.println(byteSize + " " + stringBuilder.toString().getBytes().length + " - " + size);
        } ;

        return Arrays.copyOfRange(stringBuilder.toString().getBytes(), 0, size);
    }

    /**
     * Генерация абзаца
     * @param paragraphLenght количество предложений в абзаце
     * @return абзац
     */
    private static String generateParagraph(int paragraphLenght, double probability, String[] words) {
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < paragraphLenght; i++) {
            result.append(generateSentence((int)(Math.random() * 13 + 1), probability, words));
        }
        result.append("\n");
        return result.toString();
    }

    /**
     * Генерация предложений
     * @param sentenceLenght количество слов в предложении
     * @return предложение
     */
    private static String generateSentence(int sentenceLenght, double probability, String[] words) {
        StringBuilder result = new StringBuilder();

        // Добавление слов из массива с вероятностью
        int wordsArrayCount = (int)(sentenceLenght * probability);
        //System.out.println(sentenceLenght + " " + wordsArrayCount + " " + probability);

        for (int i = 0; i < sentenceLenght; i++) {

            if (i < wordsArrayCount) {
                result.append(words[(int)(Math.random() * arrayLen)]);
            }
            else {

                if (i == 0) {
                    result.append(generateWord((int) (Math.random() * 13) + 1, true));
                } else {
                    result.append(generateWord((int) (Math.random() * 13) + 1, false));
                }
            }
             // добавление пробела
             if (i < sentenceLenght - 1) {
                // добавление случайной запятой
                if ((int) (Math.random() * 2) == 0) {
                    result.append(",");
                }
                result.append(" ");
             }
        }
        // заключительный символ предложения
        result.append(last.charAt((int)(Math.random() * last.length())) + " ");
        return result.toString();
    }

    /**
     * Генерация слова
     * @param wordLenght для слова
     * @param firstWord признак того, является ли слово первым в предложении
     * @return слово, состоящее из случайных символов английского алфавита
     */
    private static String generateWord(int wordLenght, boolean firstWord) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordLenght; i++) {
            int symbolNumber = (int)(Math.random() * 25);
            result.append(eng.charAt(symbolNumber));
            if (firstWord && i == 0) {
                result.append(eng.toUpperCase().charAt(symbolNumber));
            }
        }
        //System.out.println(wordLenght + result);
        return result.toString();
    }

    /**
     * Создание массива слов
     * @return массив слов
     */
    public static String[] wordsGenerator() {
        String[] words = new String[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            words[i] = "Сова";//generateWord((int)(Math.random() * 13) + 1, false);
        }
        return words;
    }

}
