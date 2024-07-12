import java.util.Objects;

public class Car {

    private String name;

    private int mileage;

    private int yearOfManufacture;

    public Car(String name, int mileage, int yearOfManufacture) {
        this.name = name;
        this.mileage = mileage;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return mileage == car.mileage && yearOfManufacture == car.yearOfManufacture && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + mileage;
        result = 31 * result + yearOfManufacture;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }
}
