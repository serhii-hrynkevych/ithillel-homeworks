package serhii.hrynkevych.multiarray;

public class Home {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int first = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = first;
                first++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.format("%3d", arr[i][j]);
            }
            System.out.println();
        }

    }
}
