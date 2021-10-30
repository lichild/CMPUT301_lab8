package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize+1, list.getCount());
    }

    // test the method hasCity on happy path
    @Test
    public void testHasCityHappy(){
        City city = new City("Halifax", "NS");
        list.addCity(city);
        boolean result = list.hasCity(city);
        assertEquals(true, result);
    }


    // test the method hasCity on fail pass
    @Test
    public void testHasCityFail(){
        City city = new City("Halifax", "NS");
        list.addCity(city);
        City city2 = new City("Edmonton", "AB");
        boolean result = list.hasCity(city2);
        assertEquals(false, result);
    }

    // test the method delete on happy path
    @Test
    public void testDeleteHappy(){
        City city = new City("Halifax", "NS");
        list.addCity(city);
        list.delete(city);
        assertEquals(false, list.hasCity(city));
    }

    // test the method delete on fail path
    @Test
    public void testDeleteFail(){
        City city = new City("Halifax", "NS");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });

    }

    // test the method countCities
    @Test
    public void testCountCities(){
        assertEquals(0, list.countCities());
        City city = new City("Halifax", "NS");
        list.addCity(city);
        assertEquals(1, list.countCities());
        City city2 = new City("Edmonton", "AB");
        list.addCity(city2);
        assertEquals(2, list.countCities());
        list.delete(city2);
        assertEquals(1, list.countCities());




    }

}
