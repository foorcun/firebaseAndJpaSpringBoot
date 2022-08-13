package com.javacourse.project.hibernateAndJpa_v3.business;

import com.javacourse.project.hibernateAndJpa_v3.entities.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();

    void add(City city);

    void update(City city);

    void delete(City city);

    City getById(int id);
}
