package serhii.hrynkevych.robotvisual;

import javax.swing.JFrame;

public class RobotManager
{
    public static void main(String[] args) {
        final int COUNT = 12;
        final int SIDE = 100;

        Robot robot = new Robot(200, 50);
        for (int i = 0; i < COUNT; i++) {
            robot.forward(SIDE);
            robot.setCourse(robot.getCourse() + 360 / COUNT);
        }

        RobotFrame rf = new RobotFrame(robot);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}
