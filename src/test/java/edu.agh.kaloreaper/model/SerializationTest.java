package edu.agh.kaloreaper.model;

import org.junit.Test;
import org.springframework.util.SerializationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializationTest {

    @Test
    public void testSerialization(){
        User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setYearOfBirth(1990);
        user.setWeight(1990);
        user.setCaloriesDemand(20);
        user.setProteinsDemand(20);
        user.setCarbohydratesDemand(20);
        user.setFatsDemand(20);

        User otherUser = (User) SerializationUtils.deserialize(SerializationUtils.serialize(user));

        assertThat(otherUser.getFatsDemand()).isEqualTo(user.getFatsDemand());
        assertThat(otherUser.getCarbohydratesDemand()).isEqualTo(user.getCarbohydratesDemand());
        assertThat(otherUser.getProteinsDemand()).isEqualTo(user.getProteinsDemand());
        assertThat(otherUser.getCaloriesDemand()).isEqualTo(user.getCaloriesDemand());
        assertThat(otherUser.getWeight()).isEqualTo(user.getWeight());
        assertThat(otherUser.getYearOfBirth()).isEqualTo(user.getYearOfBirth());
        assertThat(otherUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(otherUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(otherUser.getName()).isEqualTo(user.getName());


    }
}
