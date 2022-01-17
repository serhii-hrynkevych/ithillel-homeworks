package serhii.hrynkevych.relations;

public class Robot {

    private double x = 0;
    private double y = 0;
    protected double course = 0;

    private Operator operator;

    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public Operator getOperator() {
        return operator;
    }


    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void forward(int distance) {
        x = x + distance * Math.cos(course / 180 * Math.PI);
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public void printCoordinates() {
        System.out.println(x + "," + y);
    }
}
