package serhii.hrynkevych.constructors;

public class RobotManager {

    public static void main(String[] args) {
        Robot robot = new Robot(20, 20);

        robot.forward(20);
        robot.printCoordinates();

        robot.setCourse(90);
        robot.forward(20);
        robot.printCoordinates();

        robot.setCourse(45);
        robot.forward(20);
        robot.printCoordinates();
    }
}
