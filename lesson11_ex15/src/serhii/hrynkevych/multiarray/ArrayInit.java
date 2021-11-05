package serhii.hrynkevych.multiarray;

public class ArrayInit {

    public static void main(String[] args) {
        char[][] graph = {{'1', 'R', 'H', '&', '5', '@'}, {}, {'L', '0', 'I'}};
        for (char[] g1 : graph) {
            for (char g2 : g1) {
                System.out.print(g2);
            }
            System.out.println();
        }
    }
}
