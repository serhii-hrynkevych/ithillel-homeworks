package serhii.hrynkevych.multiarray;

public class MultiArray3 {

    public static void main(String[] args) {
        int SIZE = 5;
        char[][] graph = new char[SIZE][];

        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i] == null);
        }

        for (int i = 0; i < graph.length; i++) {
            int size = (int)(Math.round(Math.random()*50) + 25);
            graph[i] = new char[size];
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i].length);
        }
    }
}
