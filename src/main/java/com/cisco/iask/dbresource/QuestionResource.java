package com.cisco.iask.dbresource;

import com.cisco.iask.dao.QuestionDAO;
import com.cisco.iask.entity.Question;
import com.google.api.client.util.DateTime;
import com.google.common.base.Optional;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sarthiya on 24/04/16.
 */
@Path("/question")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionResource {

    /**
     * The DAO object to manipulate employees.
     */
    private QuestionDAO questionDAO;
    /**
     * Constructor.
     *
     * @param questionDAO DAO object to manipulate employees.
     */

    public QuestionResource(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
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
    @Path("/{username}")
    @UnitOfWork
    public List<Question> findByUserName(@QueryParam("username") String username) {
        return questionDAO.findByUserName(username);
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
    public Optional<Question> findById(@PathParam("id") LongParam id) {
        return questionDAO.findById(id.get());
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Optional<Question> createQuestion(@FormParam("title") String title,
                                             @FormParam("description") String description,
                                             @FormParam("username") String username,
                                             @FormParam("answers") long answers,
                                             @FormParam("datetime") DateTime dateTime

                                             ) {
        System.out.println(title);
        Question question = new Question(title,description,username,answers,dateTime);
        return questionDAO.create(question);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Question> findAll() {
        return questionDAO.findAllQuestions();
    }


    @GET
    @Path("/user/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Question> findbyUserName(@PathParam("userName") String userName) {
        return questionDAO.findByUserName(userName);
    }

    @GET
    @Path("/search/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Question> searchByTitle(@PathParam("title") String title) {
        String titlepart = "%" + title + "%";
        return questionDAO.searchByText(titlepart);
    }

}
