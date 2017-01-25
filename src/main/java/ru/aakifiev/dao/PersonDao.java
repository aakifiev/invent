package ru.aakifiev.dao;

import ru.aakifiev.model.Person;

import java.util.List;

/**
 * Created by aakifiev on 22.01.2017.
 */
public interface PersonDao {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
