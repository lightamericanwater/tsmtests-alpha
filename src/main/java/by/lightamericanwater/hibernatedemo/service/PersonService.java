package by.lightamericanwater.hibernatedemo.service;

import by.lightamericanwater.hibernatedemo.model.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);
    void updatePerson(Person person);
    List<Person> listPerson();
    Person getPersonId(int id);
    void removePerson(int id);

}