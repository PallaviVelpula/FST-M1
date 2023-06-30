package activities;

public class Bicycle implements BicycleParts, BicycleOperations {
    int gears;
    int currentSpeed;

    Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int decrement) {
        this.currentSpeed = currentSpeed - decrement;
    }

    public void speedUp(int increment) {
        this.currentSpeed = currentSpeed + increment;
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "Speed of bicycle is " + currentSpeed);
    }
}
