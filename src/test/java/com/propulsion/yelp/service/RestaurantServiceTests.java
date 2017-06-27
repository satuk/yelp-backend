package com.propulsion.yelp.service;

import com.propulsion.yelp.domain.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
@Transactional
@Sql("/test-data.sql")
public class RestaurantServiceTests {
    
    @Autowired
    RestaurantService service;
    
    @Test
    public void findAll() {
        assertThat( service.findAll().size() ).isEqualTo( 1 );
    }
    
    @Test
    public void findByName() {
        assertThat( service.findByName( "Petra" ).size() ).isEqualTo( 1 );
    }
    
    @Test
    public void findById() {
        Restaurant restaurant = service.findById( 3L );
        assertThat( restaurant.getId() ).isEqualTo( 3 );
    }
}
