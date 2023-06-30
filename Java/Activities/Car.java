package activities;

public class Car {
    String colour;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car() {
        tyres = 4;
        doors = 4;
    }

    public void displayCharacteristics() {
        System.out.println("Colour of the car - " + colour);
        System.out.println("Transmission mode - " + transmission);
        System.out.println("Make of the car - " + make);
        System.out.println("Number of tyres - " + tyres);
        System.out.println("Number of doors - " + doors);
    }

    public void accelarate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}
