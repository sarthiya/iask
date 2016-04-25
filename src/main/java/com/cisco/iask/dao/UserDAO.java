package com.cisco.iask.dao;

import com.cisco.iask.entity.User;
import com.google.common.base.Optional;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;

/**
 * Created by sarthiya on 21/04/16.
 */
@Log4j
public class UserDAO extends AbstractDAO<User>{

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method looks for an employee by id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    public Optional<User> findById(long id) {
        return Optional.fromNullable(get(id));
    }

    public List<User> findByUserName(String username) {
        //return (List<User>) namedQuery("com.cisco.iask.entity.User.findbyUsername");
       // Query query = namedQuery("com.cisco.iask.entity.User.findbyUsername");
       // query.setParameter("name", username);
       // return Optional.of((List<User>)query.uniqueResult()).get();
        return list(namedQuery("com.cisco.iask.entity.User.findbyUsername").setParameter("name", username));

    }

    public Optional<User> create(User user) {
        return Optional.fromNullable(persist(user));
    }
}
