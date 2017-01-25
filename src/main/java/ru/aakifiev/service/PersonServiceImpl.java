package ru.aakifiev.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aakifiev.dao.PersonDao;
import ru.aakifiev.model.Person;

import java.util.List;

/**
 * Created by aakifiev on 22.01.2017.
 */

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDao.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDao.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }
}
