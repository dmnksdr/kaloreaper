package edu.agh.kaloreaper.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NamedEntityTest {
    @Test
    public void getName() throws Exception {
        NamedEntity namedEntity = new NamedEntity();
        namedEntity.setName("name");
        Assert.assertEquals(true, namedEntity.getName() == "name");
    }

}
