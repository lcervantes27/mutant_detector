package com.lgcm.mutantDetector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lgcm.mutantDetector.domain.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
	Person findByDna(String dna_sequence);
	
	@Query("Select count(p) from Person p where p.mutant=true")
	long getNumberOfMutants();
}
