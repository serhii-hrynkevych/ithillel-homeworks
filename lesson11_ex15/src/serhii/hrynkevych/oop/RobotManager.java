package serhii.hrynkevych.oop;

public class RobotManager {

    public static void main(String[] args) {

        Robot robot = new Robot();

        robot.forward(20);
        robot.printCoordinates();

        robot.course = 90;
        robot.forward(20);
        robot.printCoordinates();

        robot.course = 45;
        robot.forward(20);
        robot.printCoordinates();
    }

//        Robot r1 = new Robot();
//        Robot r2;
//        r2 = new Robot();
//
//        r1.x = 99;
//        r2.x = 123;
//        System.out.println(r1.x);
//        System.out.println(r2.x);
//    }
}
