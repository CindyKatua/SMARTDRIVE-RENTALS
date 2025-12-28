public class Car {
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private String registrationNumber;
    private String colour;
    private boolean isAvailable;

    // Updated constructor (matches MainWindowFrame)
    public Car(String brand, String model, int year, double pricePerDay,
            String registrationNumber, String colour, boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
