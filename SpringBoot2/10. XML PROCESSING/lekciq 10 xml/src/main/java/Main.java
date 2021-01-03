import model.Address;
import model.Person;
import model.PhoneNumber;
import model.Persons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


//        Address address1=new Address(1L,"Bulgaria", "Sofia", "bul. Tzar Osvoboditel, 1");
//        Person person1= new Person(1L,"Petar","Petrov",address1
//                ,Set.of(new PhoneNumber ("+359 885123456"),new PhoneNumber("+359 2 9731425")));
//
//        //1. Create JAXBContext
//
//        try {
//
//            JAXBContext ctx= JAXBContext.newInstance(Person.class);
//
//            //2. Create Marshaller
//
//            Marshaller marshaller= ctx.createMarshaller()   ;
//
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            //3. Marshal POJO to xml
//
//            marshaller.marshal(person1,System.out);
//            marshaller.marshal(person1,new File("person.xml"));
//
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }


        List<Address> addresses = List.of(
                new Address(1L, "Bulgaria", "Sofia", "bul. Tzar Osvoboditel, 1"),
                new Address(2L, "Bulgaria", "Plovdiv", "ul. Gladston, 15"));


        List<Person> persons = List.of(
                new Person(1L, "Petar", "Petrov", addresses.get(0)
                        , Set.of(new PhoneNumber("+359 885 123456"), new PhoneNumber("+359 2 9731425"))),
                new Person(2L, "Georgi", "Hristov", addresses.get(1)
                        , Set.of(new PhoneNumber("+359 899 121895"), new PhoneNumber("+359 32 612345"))),
                new Person(3L, "Staman", "Petrov", addresses.get(0)
                        , Set.of(new PhoneNumber("+359 885 987654"), new PhoneNumber("+359 2 95232212"))));

        //1. Create JAXBContext

        try {

            JAXBContext ctx = JAXBContext.newInstance(Person.class, Persons.class);

            //2. Create Marshaller

            Marshaller marshaller = ctx.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //3. Marshal POJO to xml

//            marshaller.marshal(persons.get(0), System.out);
            marshaller.marshal(persons.get(0), new File("person.xml"));

            //4. Marshal multiple persons to persons.xml
            marshaller.marshal(new Persons(persons), new File("persons.xml"));
            marshaller.marshal(new Persons(persons), System.out);

            //5. Unmarshal multiple Persons from xml to java

            Unmarshaller unmarshaller=ctx.createUnmarshaller();
            Persons unmarshalled= (Persons) unmarshaller.unmarshal(new File("persons.xml"));
            unmarshalled.getPersons().forEach(p->
                            System.out.printf("| %5d | %-15.15s | %-15.15s | %-40.40s | %-40.40s |%n",
                                    p.getId(),p.getFirstName(),p.getLastName(),
                                    p.getAddress().getCountry() +", " + p.getAddress().getCity() + ", "+ p.getAddress().getStreet(),
                                    p.getPhoneNumbers().stream().map(PhoneNumber::getNumber).collect(Collectors.joining(", ")))
                    );

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
