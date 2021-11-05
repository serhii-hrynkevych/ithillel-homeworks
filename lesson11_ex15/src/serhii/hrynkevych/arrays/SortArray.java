package serhii.hrynkevych.arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] sample = {12, 56, 7, 34, 89, 43, 23, 9};

        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < sample.length - 1; i++) {
                if (sample[i] > sample[i + 1]) {
                    int tmp = sample[i];
                    sample[i] = sample[i + 1];
                    sample[i + 1] = tmp;
                    changed = true;
                }
            }
        }
        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int m : sample) {
            if (max < m) {
                max = m;
            }
            if (min > m) {
                min = m;
            }
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
