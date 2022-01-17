package serhii.hrynkevych.oop;

public class Robot {

    double x = 0;
    double y = 0;
    double course = 0;

    void printCoordinates() {
        System.out.println(x + "," + y);
    }

    void forward(int distance) {
        x = x + distance * Math.cos(course / 180 * Math.PI);
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }

//    int x = 0;
//    int y = 0;
//    int course = 0;
}
