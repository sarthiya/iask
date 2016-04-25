package com.cisco.iask.dao;

import com.cisco.iask.entity.Question;
import com.google.common.base.Optional;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sarthiya on 24/04/16.
 */
@Log4j
public class QuestionDAO extends AbstractDAO<Question> {

    public QuestionDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Question> findById(long id) {
        return Optional.fromNullable(get(id));
    }

    public List<Question> findByUserName(String username) {
        return list(namedQuery("com.cisco.iask.entity.Question.findbyUserName").setParameter("name", username));

    }

    public List<Question> findAllQuestions(){
        return list(namedQuery("com.cisco.iask.entity.Question.findAllQuestions"));
    }

    public Optional<Question> create(Question question) {
        return Optional.fromNullable(persist(question));
    }

    public List<Question> searchByText(String title){
        return list(namedQuery("com.cisco.iask.entity.Question.searchbyText").setParameter("title", title));
    }
}
