package by.lightamericanwater.hibernatedemo.dao;

import by.lightamericanwater.hibernatedemo.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final Logger log = LoggerFactory.getLogger(PersonDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
        log.info("person saved successfully, person details: " + person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
        log.info("person updated, person details: " + person);
    }

    @Override
    public List<Person> listPerson() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();
        for (Person person: personList) {
            log.info("Person List: " + person);
        }
        return personList;
    }

    @Override
    public Person getPersonId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        log.info("person was loaded, person details: " + person);
        return person;
    }

    @Override
    public void removePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        if(person != null) {
            session.delete(person);
        }
        log.info("person was removed, person details: " + person);
    }
}