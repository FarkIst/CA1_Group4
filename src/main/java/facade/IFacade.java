package facade;

import entity.Company;
import entity.Person;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import java.util.List;

/**
 *
 * @author Maksymilian
 */
public interface IFacade {
    
    public Person getPersonById(long id);
    public List<Person> getPersonsByPhoneNumber(String phoneNumber);
    public List<Person> getPersons();
    public List<Person> getPersonsByZipCode(int zipCode);
    public List<Person> getPersonByCity(CityInfo city);
    public List<Person> getPersonsByHobby(Hobby hobby);
    public Person createPerson(Person person);
    public Person editPerson(long id, Person person);
    public Person deletePerson(Person person);
    
    
}
