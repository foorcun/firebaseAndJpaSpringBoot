package com.javacourse.project.hibernateAndJpa_v3.restApi;

import com.javacourse.project.hibernateAndJpa_v3.business.CityManager;
import com.javacourse.project.hibernateAndJpa_v3.business.ICityService;
import com.javacourse.project.hibernateAndJpa_v3.dataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa_v3.entities.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityControllerCallFlowTest {

    private CityController sut;

    @Autowired
    private ICityService cityManager;

    @Mock
    private ICityDal mockCityDal;

    ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);

    @BeforeEach
    public void setUp(){
        cityManager = new CityManager(mockCityDal);
        sut = new CityController(cityManager);

    }

    @Test
     void getAllListSizeTest(){
        //arrange
        List<City> listCity= new ArrayList<>();
        listCity.add(new City());
        when(mockCityDal.getAll()).thenReturn(listCity);

        //act
        var listoCitto = sut.getAll();

        //assert
        assertEquals(1,listoCitto.size());

    }

    @Test
    public void addCityTest(){
        //arrange
        List<City> listCity= new ArrayList<>();
        listCity.add(new City());

        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);

//        when(hibernateCityDal.add(new City())).thenReturn((Throwable) listCity.add(new City()));
//        when(hibernateCityDal.getAll()).thenReturn(listCity);


        //act
        sut.add(new City());
//        var listoCitto = sut.getAll();
        //assert
//        assertEquals(1,listoCitto.size());
        verify(mockCityDal).add(cityArgumentCaptor.capture());
    }



    @Test
    void updateCityTest(){
        //arrange
        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);

        //act
        sut.update(new City());

        //assert
        verify(mockCityDal).update(cityArgumentCaptor.capture());

    }

    @Test
    void deleteCityTest(){
        //arrange
        //act
        sut.delete(new City());
        //assert
        verify(mockCityDal).delete(cityArgumentCaptor.capture());

    }

    @Test
    public void getByIdTest(){

        //arrange
        List<City> listCity= new ArrayList<>();
        listCity.add(new City());
        when(mockCityDal.getById(0)).thenReturn(listCity.get(0));

        //act
        var citto = sut.getById(0);


        //assert
        assertEquals(listCity.get(0),citto);

    }


}