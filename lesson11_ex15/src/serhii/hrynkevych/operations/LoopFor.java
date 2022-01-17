package serhii.hrynkevych.operations;

public class LoopFor {

    public static void main(String[] arg) {
        loopForOne();
        System.out.println("---");
        loopForTwo();
        System.out.println("---");
        loopForThree();
        System.out.println("---");
        loopForFour();
        System.out.println("---");
        loopForFive();
    }

    public static void loopForOne() {
        for(int i = 0; i < 10; i++)
            System.out.println("**********");
    }

    public static void loopForTwo() {
        int count = 10;

        for(int i=0; i < count; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void loopForThree() {
        int count = 10;

        for(int i=0; i < count; i++) {
            System.out.print("*");
            System.out.println();
        }
    }

    public static void loopForFour() {
        int count = 10;

        for(int i=0; i < count; i++) {
            for(int k=0; k < count; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void loopForFive() {
        int count = 10;

        for(int i=0; i < count; i++) {
            for(int k=0; k < i+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
