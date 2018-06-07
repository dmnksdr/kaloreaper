package edu.agh.kaloreaper.model;

import org.junit.Assert;
import org.junit.Test;


public class UserTest {
    @Test
    public void getFirstName() throws Exception {
        User user = new User();
        user.setFirstName("firstName");
        Assert.assertEquals(true, user.getFirstName() == "firstName");
    }

    @Test
    public void getLastName() throws Exception {
        User user = new User();
        user.setLastName("lastName");
        Assert.assertEquals(true, user.getLastName() == "lastName");
    }

    @Test
    public void getYearOfBirth() throws Exception {
        User user = new User();
        user.setYearOfBirth(1990);
        Assert.assertEquals(true, user.getYearOfBirth() == 1990);

    }

    @Test
    public void getWeight() throws Exception {
        User user = new User();
        user.setWeight(1990);
        Assert.assertEquals(true, user.getWeight() == 1990);
    }

    @Test
    public void getCaloriesDemand() throws Exception {
        User user = new User();
        user.setCaloriesDemand(20);
        Assert.assertEquals(true, user.getCaloriesDemand() == 20);
    }

    @Test
    public void getProteinsDemand() throws Exception {
        User user = new User();
        user.setProteinsDemand(20);
        Assert.assertEquals(true, user.getProteinsDemand() == 20);
    }

    @Test
    public void getCarbohydratesDemand() throws Exception {
        User user = new User();
        user.setCarbohydratesDemand(20);
        Assert.assertEquals(true, user.getCarbohydratesDemand() == 20);
    }

    @Test
    public void getFatsDemand() throws Exception {
        User user = new User();
        user.setFatsDemand(20);
        Assert.assertEquals(true, user.getFatsDemand() == 20);
    }

}
