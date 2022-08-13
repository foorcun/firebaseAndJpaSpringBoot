package com.javacourse.project.hibernateAndJpa_v3.restApi;

import com.javacourse.project.hibernateAndJpa_v3.business.ICityService;
import com.javacourse.project.hibernateAndJpa_v3.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/api")
public class CityController {

    private ICityService cityManager;

    public CityController(ICityService cityManager) {
        this.cityManager = cityManager;
    }

    @GetMapping("/cities")
    public List<City> getAll() {
        System.out.println("getAll() calisti");

        return cityManager.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody City city) {
        System.out.println("add() calisti");

        cityManager.add(city);
    }

    @PostMapping("/update")
    public void update(@RequestBody City city) {
        cityManager.update(city);
        System.out.println("update() calisti");

    }

    @PostMapping("/delete")
    public void delete(@RequestBody City city) {
        cityManager.delete(city);
        System.out.println("delete() calisti");

    }

    @GetMapping ("/cities/{id}")
    public City getById(@PathVariable int id) {
        return cityManager.getById(id);

    }
}
