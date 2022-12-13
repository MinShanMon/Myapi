package nus.iss.myApi.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nus.iss.myApi.Model.Person;

public interface PersonDao {
    Person insertPerson(UUID id, Person person);
    default Person insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
