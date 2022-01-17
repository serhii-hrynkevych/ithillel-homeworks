package serhii.hrynkevych.overrideoverload;

public class RobotTotal extends Robot{

    private double totalDistance = 0;

    public RobotTotal() {
        super(0, 0);
    }

    public RobotTotal(double x, double y) {
        super(x, y);
    }

    @Override
    public void forward(int distance) {
        super.forward(distance);
        totalDistance += distance;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
