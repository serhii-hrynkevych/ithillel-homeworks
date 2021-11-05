package serhii.hrynkevych.operations;

public class LoopWhile {

    public static void main(String[] arg) {
        loopWhileFirst();
        System.out.println("---");
        loopWhileTwo();
        System.out.println("---");
        loopWhileThree();
    }

    public static void loopWhileFirst() {
        int count = 10;

        int i=0;
        while(i < count) {
            System.out.print("#");
            i++;
        }
        System.out.println();
    }

    public static void loopWhileTwo() {
        int count = 10;

        int i = 0;
        while (i++ < count) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void loopWhileThree() {
        int count = 10;

        int i = 0;
        while (i < count) {
            int k = 0;
            while (k < count) {
                System.out.print("*");
                k++;
            }
            System.out.println();
            i++;
        }
    }
}
