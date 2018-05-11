package edu.agh.kaloreaper.Meal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Meals {

    private List<Meal> meals;

    @XmlElement
    public List<Meal> getMealList() {
        if (meals == null) {
            meals = new ArrayList<>();
        }
        return meals;
    }

}
