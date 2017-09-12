/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entity.*;
import java.util.List;
/**
 *
 * @author AR
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
