package edu.agh.kaloreaper.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseEntityTest {
    @Test
    public void getId() throws Exception {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setId(1);
        Assert.assertEquals(true,baseEntity.getId() == 1);
    }

    @Test
    public void isNew() throws Exception {
        BaseEntity baseEntity = new BaseEntity();
        Assert.assertTrue(baseEntity.isNew());
    }

}
