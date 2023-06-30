package activities;

import java.util.Date;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Itadori");
        plane.onboard("Gojo");
        System.out.println("Take off time is: "+ plane.takeOff());
        System.out.println("Passengers are: "+plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Time landed is: "+ plane.getLastTimeLanded());
    }
}
