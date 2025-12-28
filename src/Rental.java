
public class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }
        this.car = car;
        this.customer = customer;
        this.days = days;

        // Mark the car as rented
        car.rent();
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    // Calculate total cost
    public double getTotalCost() {
        return car.calculateRentalCost(days);
    }

    // End rental
    public void endRental() {
        car.returnCar();
    }

    @Override
    public String toString() {
        return "Rental [Customer=" + customer.getName() +
                ", Car=" + car.getBrand() + " " + car.getModel() +
                ", Days=" + days +
                ", TotalCost=" + getTotalCost() + "]";
    }
}