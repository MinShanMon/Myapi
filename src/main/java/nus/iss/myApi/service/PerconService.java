package nus.iss.myApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nus.iss.myApi.Model.Person;
import nus.iss.myApi.repo.PersonDao;

@Service
public class PerconService {
    private final PersonDao personDao;
    @Autowired
    public PerconService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao=personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
}
