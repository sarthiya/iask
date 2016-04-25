package com.cisco.iask.dbresource;

import com.cisco.iask.dao.UserDAO;
import com.cisco.iask.entity.User;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    /**
     * The DAO object to manipulate employees.
     */
    private UserDAO userDAO;
    /**
     * Constructor.
     *
     * @param userDAO DAO object to manipulate employees.
     */

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    /**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * employees stored in the database.
     *
     * @param username query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring or list of all employees stored in the database.
     */
    /*@GET
    @UnitOfWork
    public List<User> findByUserName(@QueryParam("username") Optional<String> username) {
        if (username.isPresent()) {
            return userDAO.findByUserName(username.get());
        }
    }*/
    /**
     * Method looks for an employee by her id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<User> findById(@PathParam("id") LongParam id) {
        return userDAO.findById(id.get());
    }

    @POST
    @Path("/user/signup")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Optional<User> createUser(@FormParam("first_name") String firstname,
                                     @FormParam("last_name") String lastname,
                                     @FormParam("username") String username,
                                     @FormParam("password") String password,
                                     @FormParam("e_mail") String e_mail

    ) {
        System.out.println(firstname);
        User user = new User(firstname,lastname,username,e_mail,password);
        return userDAO.create(user);
    }

}