package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();

        cars.add(new Car("Model1", "Red", 1956));
        cars.add(new Car("Model2", "Green", 1962));
        cars.add(new Car("Model3", "Blue", 1971));
        cars.add(new Car("Model4", "Black", 1980));
        cars.add(new Car("Model5", "White", 1990));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count > 0 && count <= cars.size()) {
            return cars.subList(0, count);
        }
        return cars;
    }
}