package serhii.hrynkevych.arrays;

public class ForEachExample {

    public static void main(String[] args) {
        int[] sample = new int[5];

        System.out.println("До foreach");
        for (int t : sample) {
            System.out.println(t);
        }

        for (int i = 0; i < sample.length; i++) {
            sample[i] = 99;
        }

        System.out.println("После foreach");
        for (int t : sample) {
            System.out.println(t);
        }
    }
}
