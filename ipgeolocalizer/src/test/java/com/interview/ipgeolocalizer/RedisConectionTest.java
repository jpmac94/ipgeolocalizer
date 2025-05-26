package com.interview.ipgeolocalizer;


import com.interview.ipgeolocalizer.model.City;
import com.interview.ipgeolocalizer.repository.CityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class RedisConectionTest {

    @Autowired
private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private CityRepository redisRepository;

    @Test
    public void deleteAll(){
        redisRepository.deleteAll();
    }

    @Test
    public void saveBsAs(){
        City city=new City("BsAs","Buenos Aires",4.0,5.0);
        redisRepository.save(city);
    }

    @Test
    public void deleteBsAs(){
        redisRepository.deleteById("BsAs");
    }

    @Test
    public void findAllCity(){
        redisRepository.findAll().forEach(c-> System.out.println(c.getName()));
    }

    @Test
    public void getCity(){
        Optional<City> city= redisRepository.findById("pergaCity");
        System.out.println(city.get().getLongitude());
    }

    @Test
    public void saveCity(){
        City city=new City("pergaCity","pergamino",2.0,2.0);
        redisRepository.save(city);
    }

    @Test
    public void checkCityRepository(){
        Assertions.assertNotNull(redisRepository);
    }

    @Test
    public void conectionTest(){
        Assertions.assertNotNull(redisTemplate);
    }

    @Test
    public void saveTest(){
        redisTemplate.opsForValue().set("city","pergamino");
    }

    @Test
    public void getAll(){
        Set<String> keys=redisTemplate.keys("*");

        HashMap<String,String> allValues=new HashMap<>();
        if(keys!=null){
            for (String key: keys){
                String value=redisTemplate.opsForValue().get(key);
                allValues.put(key,value);
                System.out.println("key: "+key+", value: "+value);
            }
        }
    }

    @Test
    public void delete(){
        redisTemplate.delete("city");
    }
}
