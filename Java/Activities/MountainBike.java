package activities;

public class MountainBike extends Bicycle {
    int seatHeight;

    MountainBike(int gears, int currentSpeed) {
        super(gears,currentSpeed);
        seatHeight = 0;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        System.out.println("Seat Height is: " + seatHeight);
        return ("No of gears are " + gears + "\nSpeed of bicycle is " + currentSpeed);
    }

    public static void main(String[] args) {
        MountainBike bike = new MountainBike(2, 50);
        bike.setHeight(10);
        System.out.println(bike.bicycleDesc());
        bike.speedUp(20);
        bike.applyBrake(5);
        bike.setHeight(15);
        System.out.println(bike.bicycleDesc());
    }
}
