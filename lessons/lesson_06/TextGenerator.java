package lesson_06;

public class TextGenerator {

    private static String eng = "abcdefghijklmnopqrstuvwxyz";
    private static String last = "(.|!|?)+\"";

    public static String generateText(int textLenght) {
        String result = "";
        for (var i = 0; i < textLenght; i++) {
            result = result + "!!!" + generateParagraph((int)(Math.random() * 13) + 1);
        }
        return result;
    }

    private static String generateParagraph(int paragraphLenght) {
        String result = "";
        for (var i = 0; i < paragraphLenght; i++) {
            result = result + generateSentence((int)(Math.random() * 13) + 1);
        }
        result = result + "\n";
        return result;
    }

    private static String generateSentence(int sentenceLenght) {
        String result = "";
        for (int i = 0; i < sentenceLenght; i++) {
            if (i == 0) {
                result = result + generateWord((int)(Math.random() * 13) + 1, true);
            }
            else {
                result = result + generateWord((int)(Math.random() * 13) + 1, false);
            }
            // добавление пробела
            if (i < sentenceLenght - 1) {
                // добавление случайной запятой
                if ((int)(Math.random() * 2) == 0) {
                    result = result + ",";
                }
                result = result + " ";
            }

        }
        // заключительный символ предложения
        result = result + last.charAt((int)(Math.random() * 8)) + " ";
        return result;
    }

    private static String generateWord(int wordLenght, boolean firstWord) {
        String result = "";
        for (int i = 0; i < wordLenght; i++) {
            int symbolNumber = (int)(Math.random() * 25);
            result = result + eng.charAt(symbolNumber);
            if (firstWord && i == 0) {
                result = result.toUpperCase();
            }
        }
        //System.out.println(wordLenght + result);
        return result;
    }

}
