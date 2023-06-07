import java.util.Objects;

public class Car {
    int speed;
    double price;
    String brand;

    public Car(int speed, double price, String brand) {
        this.speed = speed;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(hashCode() != o.hashCode()){
            return false;
        }
        Car car = (Car) o;
        return speed == car.speed && Double.compare(car.price, price) == 0 && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, price, brand);
    }
}
