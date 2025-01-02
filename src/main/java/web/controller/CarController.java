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
	public String index(HttpServletRequest request, Model model) {
		String count = request.getParameter("count");
		System.out.println(count);
		if (count == null) {
			System.out.println(carService.listCars().toString());
			model.addAttribute("cars", carService.listCars());
			return "cars";
//			for (Car car : carService.listCars()) {
//				model.addAttribute("car", car);
//				return "car";
//			}

		} else {
			int icount = Integer.parseInt(count);
			if (icount >= 5) {
				System.out.println(carService.listCars().toString());
				model.addAttribute("cars", carService.listCars());
				return "cars";

			} else {
				System.out.println(carService.getCarByQuantity(icount).toString());
				List<Car> cars = carService.getCarByQuantity(icount);
				model.addAttribute("cars", cars);
				return "cars";
			}
		}
	}
//    @GetMapping("/cars{count}")
//	public String show(@PathVariable("count") int count, Model model) {
//		model.addAttribute("cars", carService.getCarByQuantity(count));
//		return "cars";
//	}
	
}