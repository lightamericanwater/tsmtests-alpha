package by.lightamericanwater.hibernatedemo.dao;

import by.lightamericanwater.hibernatedemo.model.Person;

import java.util.List;

public interface PersonDAO {

    void addPerson(Person person);
    void updatePerson(Person person);
    List<Person> listPerson();
    Person getPersonId(int id);
    void removePerson(int id);

}