public class Customer {
    private String customerId;
    private String name;

    //Constructor
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    //Getters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }

    //Setters 
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + name + "]";
    }
}