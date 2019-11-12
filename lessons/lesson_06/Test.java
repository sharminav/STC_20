package lesson_06;

public class Test {

    public static void main(String[] args) {
        //System.out.println(new TextGenerator().generateWord((int)(Math.random() * 14), true));
        //System.out.println(new TextGenerator().generateSentence((int)(Math.random() * 14)));
        System.out.println(new TextGenerator().generateText((int)(Math.random() * 13) + 1));
    }
}
