package hello.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import hello.springboot.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Person> persons;
	
	static{
		persons= populateDummyPersons();
	}

	public List<Person> findAllPersons() {
		return persons;
	}
	
	public Person findById(long id) {
		for(Person person : persons){
			if(person.getId() == id){
				return person;
			}
		}
		return null;
	}
	
	public Person findByName(String name) {
		for(Person person : persons){
			if(person.getName().equalsIgnoreCase(name)){
				return person;
			}
		}
		return null;
	}
	
	public void savePerson(Person person) {
		person.setId(counter.incrementAndGet());
		persons.add(person);
	}

	public void updatePerson(Person person) {
		int index = persons.indexOf(person);
		persons.set(index, person);
	}

	public void deletePersonById(long id) {
		
		for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
		    Person person = iterator.next();
		    if (person.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isPersonExist(Person person) {
		return findByName(person.getName())!=null;
	}
	
	public void deleteAllPersons(){
		persons.clear();
	}

	private static List<Person> populateDummyPersons(){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(counter.incrementAndGet(),"Sam",30, 70000));
		persons.add(new Person(counter.incrementAndGet(),"Tom",40, 50000));
		persons.add(new Person(counter.incrementAndGet(),"Jerome",45, 30000));
		persons.add(new Person(counter.incrementAndGet(),"Silvia",50, 40000));
		return persons;
	}

}
