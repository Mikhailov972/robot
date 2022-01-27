package ru.mvs.interview.robot;

public class Robot {
    private final Object instance = new Object();
    private final Leg leftLeg = new Leg("Left", instance);
    private final Leg rightLeg = new Leg("Right", instance);

    public void start() {
        leftLeg.start();
        rightLeg.start();
    }

    public static void main(final String[] args) {
        try {
            Robot robot = new Robot();
            robot.start();

            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
