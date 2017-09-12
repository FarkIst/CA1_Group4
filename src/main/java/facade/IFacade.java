package facade;

import entity.Company;
import entity.Person;
import entity.Address;
import java.util.List;

/**
 *
 * @author Maksymilian
 */
public interface IFacade {
    Person getPerson(int id); 
    List<Person> getPersons();
    List<Person> getPersons(int zipCode);
    Address getAddress(int id); 
    List<Address> getAddress();
    
    Company getCompany(String cvr);
    
    
    
    
    
    

    
}
