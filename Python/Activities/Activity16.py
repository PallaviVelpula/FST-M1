class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print("{} - {} is moving".format(self.manufacturer, self.model))

    def stop(self):
        print("{} - {} has stopped".format(self.manufacturer, self.model))


car1 = Car("Tata", "Nexon", "2020", "Auto", "Black")
car2 = Car("Hyundai", "Tucson", "2018", "Auto", "Blue")
car3 = Car("Mahindra", "Scorpio", "2010", "Manual", "Grey")

car1.accelerate()
car2.stop()
car3.accelerate()