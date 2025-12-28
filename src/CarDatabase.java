import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CarDatabase {

    public static void insertCar(Car car) {

        String sql = "INSERT INTO cars " +
                "(brand, model, year, colour, daily_rate, availability, registration_number, registered_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColour());
            ps.setDouble(5, car.getPricePerDay());
            ps.setBoolean(6, car.isAvailable());
            ps.setString(7, car.getRegistrationNumber());
            ps.setDate(8, java.sql.Date.valueOf(LocalDate.now()));

            System.out.println("INSERTING => " +
            car.getBrand() + ", " + car.getModel() + ", " +
            car.getYear() + ", " + car.getColour() + ", " +
            car.getPricePerDay() + ", " + car.isAvailable() + ", " +
            car.getRegistrationNumber());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Database insert failed: " + e.getMessage());
        }
    }
}
