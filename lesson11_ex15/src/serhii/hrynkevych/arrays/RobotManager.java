package serhii.hrynkevych.arrays;

public class RobotManager {

    public static void main(String[] args) {
        Robot[] rbts = new Robot[10];

        for (int i = 0; i < rbts.length; i++) {
            rbts[i] = new Robot(i * 10, i * 10);
        }

        for (int i = 0; i < rbts.length; i++) {
            rbts[i].printCoordinates();
        }
    }
}
