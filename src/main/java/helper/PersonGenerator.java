package helper;

import entity.Person;
import java.util.Random;

public class PersonGenerator {
    private static final Random r = new Random();
    
    public static String randomChoice(String[] items) {
        int index = r.nextInt(items.length);
        return items[index];
    }
    public static Person randomPerson() {
        String[] firstNames = {"Bob", "Alice", "Charlie", "Dave", "Eve", "Frank", "George"};
        String[] lastNames = "Ahmad Ahmed Ali Andersen Andersson Andreasen Andreassen Andresen Asmussen Bach Bak Bang Bech Beck Bendtsen Berg Bertelsen Berthelsen Bisgård Bisgaard Bjerre Bjerregård Bjerregaard Bonde Brandt Brodersen Bruun Buch Bundgård Bundgaard Carlsen Carstensen Christensen Christiansen Christoffersen Clausen Dahl Dalgård Dalgaard Dalsgård Dalsgaard Dam Damgård Damgaard Danielsen Davidsen Enevoldsen Eriksen Eskildsen Fischer Frandsen Frederiksen Friis Frost Gade Gregersen Hald Hansen Hassan Hedegård Hedegaard Hemmingsen Henningsen Henriksen Hermansen Hjorth Hoffmann Holm Holst Hougård Hougaard Ibsen Iversen Jacobsen Jakobsen Jensen Jeppesen Jepsen Jespersen Jessen Johannesen Johannsen Johansen Johansson Johnsen Juhl Justesen Juul Jønsson Jørgensen Karlsen Khan Kirkegård Kirkegaard Kjeldsen Kjær Kjærgård Kjærgaard Klausen Knudsen Koch Kofoed Kragh Kristensen Kristiansen Kristoffersen Krog Krogh Kruse Lange Larsen Lassen Lauridsen Lauritsen Lauritzen Laursen Laustsen Leth Lind Lorentzen Lorenzen Lund Madsen Markussen Mathiasen Mathiesen Meyer Michelsen Mikkelsen Mogensen Mohamed Mortensen Munch Munk Müller Mølgård Mølgaard Møller Nguyen Nielsen Nikolajsen Nilsson Nissen Nygård Nygaard Nørgård Nørgaard Olesen Olsen Olsson Overgård Overgaard Paulsen Pedersen Persson Petersen Poulsen Rasmussen Ravn Riis Schmidt Schou Schrøder Schultz Simonsen Skov Skovgård Skovgaard Sloth Sommer Steffensen Svendsen Svensson Søgård Søgaard Søndergård Søndergaard Sørensen Thomassen Thomsen Thorsen Thygesen Thøgersen Toft Vestergård Vestergaard Villadsen Vinther Winther Østergård Østergaard Ågård Aagård Ågaard Aagaard".split(" ");
        String[] emailProviders = {"google.com", "yahoo.com", "hotmail.com"};
        String firstName = randomChoice(firstNames);
        String lastName = randomChoice(lastNames);
        String emailProvider = randomChoice(emailProviders);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + emailProvider;
        return new Person(email, firstName, lastName);
    }
    public static void printPerson(Person person) {
        System.out.println("INSERT INTO PERSON (email, firstName, lastName)  VALUES ("
                + "'" + person.getEmail() + "', "
                + "'" + person.getFirstName() + "', "
                + "'" + person.getLastName() + "');");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            printPerson(randomPerson());
        }
    }
}
