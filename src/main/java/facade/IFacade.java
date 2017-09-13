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
    
    public Person getPerson(long id);
    public List<Person> getPersonsByPhoneNumber(String phoneNumber);
    public List<Person> getPersons();
    public List<Person> getPersonsByZipCode(String zipCode);
    public List<Person> getPersonsByCity(CityInfo city);
    public List<Person> getPersonsByHobby(Hobby hobby);
    public Person createPerson(Person person);
    public Person editPerson(Person person);
    public Person deletePerson(Person person);
    
    
}
