package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(HttpServletRequest request, Model model) {
        int count = parseCount(request);
        List<Car> cars = carService.getCars(count);

        model.addAttribute("cars", cars);
        return "cars";
    }

    private int parseCount(HttpServletRequest request) {
        String param = request.getParameter("count");
        if (param != null && !param.isEmpty()) {
            try {
                return Integer.parseInt(param);
            } catch (NumberFormatException e) {
                System.err.println("Invalid count parameter: " + param);
            }
        }
        return 0;
    }
}