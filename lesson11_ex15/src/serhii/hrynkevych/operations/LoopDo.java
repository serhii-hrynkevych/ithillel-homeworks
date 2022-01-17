package serhii.hrynkevych.operations;

public class LoopDo {

    public static void main(String[] arg) {
        loopDoOne();
        System.out.println("---");
        loopDoTwo();
    }

    public static void loopDoOne() {
        int count = 10;

        int i = 0;
        do {
            System.out.print("*");
            i++;
        } while(i < count);
        System.out.println();
    }

    public static void loopDoTwo() {
        int count = 10;

        int i = 0;
        do {
            System.out.print("*");
        } while (++i < count);   // Вот здесь наш оператор ++
        System.out.println();

    }
}
