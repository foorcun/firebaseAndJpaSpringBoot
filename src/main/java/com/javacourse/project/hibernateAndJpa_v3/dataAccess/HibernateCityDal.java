package com.javacourse.project.hibernateAndJpa_v3.dataAccess;


import com.javacourse.project.hibernateAndJpa_v3.entities.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HibernateCityDal implements ICityDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        return cities;
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToDelete = session.get(City.class, city.getId());
        session.delete(cityToDelete);

    }

    @Override
    @Transactional

    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);

        return city;
    }
}
