package serhii.hrynkevych.operations;

public class LoopForWithIf {

    public static void main(String[] arg) {
        loopForWithIfOne();
        System.out.println("---");
        loopForWithIfTwo();
        System.out.println("---");
        loopForWithIfTestOne();
        System.out.println("---");
        loopForWithIfTestTwo();
        System.out.println("---");
    }

    public static void loopForWithIfOne() {
        int count = 10;

        for(int i=0; i < count; i++) {
            for(int k=0; k < count; k++) {
                if(k==0 || k==count-1 || i==0 || i==count-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void loopForWithIfTwo() {
        int count = 10;

        for (int i = 0; i < count; i++) {
            for (int k = 0; k < i + 1; k++) {
                if (k == 0 || k == i || i == count - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void loopForWithIfTestOne() {
        int count = 10;

        for(int i=0; i < count; i++) {
            for(int k=0; k < count; k++) {
                if(k==0 || k==count-1 || i==k || i==0 || i==count-1 || k==count-1-i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void loopForWithIfTestTwo() {
        int count = 10;

        for (int i = 0; i < count; i++) {
            for (int k = count - 1; k  >= 0; k--) {
                if (k == 0 || k == i || i == count - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
