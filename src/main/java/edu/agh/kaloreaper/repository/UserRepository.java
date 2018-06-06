package edu.agh.kaloreaper.repository;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


public interface UserRepository extends Repository<User, Integer> {


    @Query("SELECT user FROM User user WHERE user.id =:id")
    @Transactional(readOnly = true)
    User findById(@Param("id") Integer id);

//    void save(User meal);

    @Query("SELECT user FROM User user WHERE user.name =:name")
    @Transactional(readOnly = true)
    User findByName(@Param("name") String name);


    @Transactional(readOnly = true)
    Collection<Meal> findAll() throws DataAccessException;

}
