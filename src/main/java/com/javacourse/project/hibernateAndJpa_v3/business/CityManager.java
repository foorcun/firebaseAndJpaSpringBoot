package com.javacourse.project.hibernateAndJpa_v3.business;

import com.javacourse.project.hibernateAndJpa_v3.dataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa_v3.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public class CityManager implements ICityService {

    @Autowired
    private ICityDal cityDal;
    public CityManager(ICityDal cityDal) {
        this.cityDal=cityDal;
    }

    @Override
    public List<City> getAll() {
        return cityDal.getAll();
    }

    @Override
    public void add(City city) {
        cityDal.add(city);

    }

    @Override
    public void update(City city) {
        cityDal.update(city);

    }

    @Override
    public void delete(City city) {
    cityDal.delete(city);
    }

    @Override
    public City getById(int id) {
        return cityDal.getById(id);
    }
}
