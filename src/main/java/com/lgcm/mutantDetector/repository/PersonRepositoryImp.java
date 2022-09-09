package com.lgcm.mutantDetector.repository;
/**
 * @author lgerardocv@gmail.com
 * Class for implementation of Person repository
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lgcm.mutantDetector.domain.Person;

@Repository
public class PersonRepositoryImp {
	@Autowired
	private PersonRepository PersonRepository;
	
	public void addPerson(Person person) {
		PersonRepository.save(person);
	}
	
	public Person findByDna(String dna) {
		return PersonRepository.findByDna(dna);
	}
	
	public long mutantsCounter() {
		return PersonRepository.getNumberOfMutants();
	}
	
	public long humansCounter() {
		return PersonRepository.count();
	}
}
