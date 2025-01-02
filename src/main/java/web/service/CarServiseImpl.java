package web.service;

import web.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiseImpl implements CarService{
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("Model1", "Red", 1956));
        cars.add(new Car("Model2", "Green", 1962));
        cars.add(new Car("Model3", "Blue",1971));
        cars.add(new Car("Model4", "Black",1980));
        cars.add(new Car("Model5", "White", 1990));
    }

    @Override
    public List<Car> listCars() {
        cars.stream().forEach(System.out::println);
        return cars;
    }

    @Override
    public List<Car> getCarByQuantity(int quantity) {
        cars.stream().limit(quantity).forEach(System.out::println);
        return cars.subList(0, quantity);
    }
}
