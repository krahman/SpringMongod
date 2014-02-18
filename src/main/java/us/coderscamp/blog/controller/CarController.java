package us.coderscamp.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import us.coderscamp.blog.model.Car;
import us.coderscamp.blog.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="/car", method = RequestMethod.GET)
	public String getCarList(ModelMap model){
		model.addAttribute("carList", carService.listCar());
		return "result";
	}
	
	@RequestMapping(value="/car/save", method = RequestMethod.POST)
	public View createCar(@ModelAttribute Car car, ModelMap model){
		if(StringUtils.hasText(car.getId())){
			carService.updateCar(car);
		}else{
			carService.addCar(car);
		}
		return new RedirectView("/SpringMongod/car");
	}
	
	@RequestMapping(value="/car/delete", method = RequestMethod.GET)
	public View deleteCar(@ModelAttribute Car car, ModelMap model){
		carService.deleteCar(car);
		return new RedirectView("/SpringMongod/car");
	}
}
