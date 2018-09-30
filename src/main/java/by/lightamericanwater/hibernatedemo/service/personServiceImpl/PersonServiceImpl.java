package by.lightamericanwater.hibernatedemo.service.personServiceImpl;

import by.lightamericanwater.hibernatedemo.dao.PersonDAO;
import by.lightamericanwater.hibernatedemo.model.Person;
import by.lightamericanwater.hibernatedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;


    @Override
    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    @Override
    @Transactional
    public List<Person> listPerson() {

        return personDAO.listPerson();
    }

    @Override
    @Transactional
    public Person getPersonId(int id) {
        return personDAO.getPersonId(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        personDAO.removePerson(id);
    }
}