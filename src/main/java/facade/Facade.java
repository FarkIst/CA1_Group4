package facade;

import entity.CityInfo;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Facade implements IFacade{

    private EntityManager em;

    @Override
    public Person getPerson(long id) {
       return (Person) em.find(InfoEntity.class, id);
    }

    @Override
    public List<Person> getPersonsByPhoneNumber(String phoneNumber) {
        Query q = em.createQuery("SELECT p.infoEntity FROM Phone p WHERE p.number = :number");
        q.setParameter("number", phoneNumber);
        List<Person> persons =  q.getResultList();
        return persons;
    }

    @Override
    public List<Person> getPersons() {
        Query q = em.createQuery("SELECT p FROM Person p");
        List<Person> persons =  q.getResultList();
        return persons;
    }

    @Override
    public List<Person> getPersonsByZipCode(String zipCode) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.address.cityInfo.zipCode = :zipCode");
        q.setParameter("zipCode", zipCode);
        List<Person> persons =  q.getResultList();
        return persons;
    }

    @Override
    public List<Person> getPersonsByCity(CityInfo cityInfo) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.address.cityInfo = :cityInfo");
        q.setParameter("cityInfo", cityInfo);
        List<Person> persons =  q.getResultList();
        return persons;
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.hobbies = :hobby");
        q.setParameter("hobby", hobby);
        List<Person> persons =  q.getResultList();
        return persons;
    }

    @Override
    public Person createPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person editPerson(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person deletePerson(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        return person;
    }
    
}
