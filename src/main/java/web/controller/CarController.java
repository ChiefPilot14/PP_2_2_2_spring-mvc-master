package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

@Controller
public class CarController {
	private final CarService carService;

	@Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
	@GetMapping("/cars")
	public String index(HttpServletRequest request) {
		String count = request.getParameter("count");
		System.out.println(count);
		if (count == null) {
			System.out.println(carService.listCars().toString());

		} else {
			int icount = Integer.parseInt(count);
			if (icount >= 5) {
				System.out.println(carService.listCars().toString());
			} else {
				System.out.println(carService.getCarByQuantity(icount).toString());
			}
		}
		return "cars";
	}
//    @GetMapping("/cars{count}")
//	public String show(@PathVariable("count") int count, Model model) {
//		model.addAttribute("cars", carService.getCarByQuantity(count));
//		return "cars";
//	}
	
}