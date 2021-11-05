package serhii.hrynkevych.operations;

public class BreakContinue {

    public static void main(String[] arg) {
        breakFirst();
        System.out.println("---");
        continueFirst();
    }

    public static void breakFirst() {
        int number = 1;
        int sum = 0;
        int count = 0;
        int max = 300;

        for(;;) {
            sum += number;
            if(sum > 300) {
                break;
            } else {
                count++;
            }
            number += 10;
        }
        System.out.println("Count=" + count);
    }

    public static void continueFirst() {

        for(int i=0; i < 20; i++) {
            if(i%2 == 0) {
                continue;
            }
            System.out.println("Number=" + i);
        }
    }
}
