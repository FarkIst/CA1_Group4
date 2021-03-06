/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author AR
 */
@Entity
public class Person extends InfoEntity {

    private String firstName;
    private String lastName;
   
    
    @ManyToMany
    private List<Hobby> hobbies;
    
    private Person() {
    }

    public Person(String email, String firstName, String lastName) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + getId() + ", email=" + getEmail() + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbies=" + hobbies + '}';
    }
    
}
