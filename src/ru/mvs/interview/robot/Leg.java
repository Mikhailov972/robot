package ru.mvs.interview.robot;

import static java.util.Objects.requireNonNull;

public class Leg extends Thread {
    private final String name;
    private final Object instance;
    private static String currentLeg = "";

    public Leg(String name, Object instance) {
        this.name = requireNonNull(name);
        this.instance = instance;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (instance) {
                currentLeg = this.name;
                System.out.println(currentLeg);
                instance.notifyAll();
                try {
                    while (currentLeg.equals(this.name)) {
                        instance.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
