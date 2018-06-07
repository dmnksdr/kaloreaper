package edu.agh.kaloreaper.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void getFirstName() throws Exception {
        Person person = new Person();
        person.setFirstName("firstName");
        Assert.assertEquals(true, person.getFirstName() == "firstName");
    }

    @Test
    public void getLastName() throws Exception {
        Person person = new Person();
        person.setLastName("lastName");
        Assert.assertEquals(true, person.getLastName() == "lastName");
    }

}
