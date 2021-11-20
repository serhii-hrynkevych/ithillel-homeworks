package serhii.hrynkevych;

public class Main {

    public static void main(String[] args) {
        MyTranslator myTranslator = new MyTranslator();
        myTranslator.addWords("lazy", "ленивую");
        myTranslator.addWords("quick", "быстрая");
        myTranslator.addWords("dog", "собаку");
        myTranslator.addWords("fox", "лиса");
        myTranslator.addWords("brown", "коричневая");
        myTranslator.addWords("over", "через");
        myTranslator.addWords("jumps", "прыгает");
        String input = "quick brown fox jumps over lazy dog";
        myTranslator.translate(input);
        System.out.println("***");
        input = "quick brown fox jumps over lazy dog cat coconut";
        myTranslator.translate(input);
    }
}
