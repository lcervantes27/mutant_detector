package com.lgcm.mutantDetector.services;
/**
 * @author lgerardocv@gmail.com
 * Service Class
 */
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcm.mutantDetector.domain.Person;
import com.lgcm.mutantDetector.domain.Stats;
import com.lgcm.mutantDetector.repository.PersonRepositoryImp;
import com.lgcm.mutantDetector.utilities.*;

@Service
public class MutantDetectorService {
	@Autowired
	private PersonRepositoryImp PersonRepositoryImp;
	private MutantUtilities MutantUtilities = new MutantUtilities();
	
	public boolean registerPerson(String[] dna) throws Exception {
		//System.out.println("Service:"+Arrays.toString(dna));
		if(PersonRepositoryImp.findByDna(Arrays.toString(dna))!=null) {
			throw new Exception("This person is already registered");
		}
		if(!MutantUtilities.inputValidation(dna)) {
			throw new Exception("Wrong format in DNA sequence");
		}
		boolean is_mutant=MutantUtilities.isMutant(dna);
		Person p= new Person();
		p.setDna(Arrays.toString(dna));
		p.setMutant(is_mutant);
		PersonRepositoryImp.addPerson(p);
		return is_mutant;
	}
	
	public Stats getStats() {
		Stats stats = new Stats();
		stats.setCount_mutant_dna(PersonRepositoryImp.mutantsCounter());
		stats.setCount_human_dna(PersonRepositoryImp.humansCounter());
		if(stats.getCount_human_dna()==0) {
			stats.setRadio(Float.valueOf(0) );
		}
		else {
			stats.setRadio(Float.valueOf(PersonRepositoryImp.mutantsCounter()) /Float.valueOf(PersonRepositoryImp.humansCounter()) );
		}
		return stats;
	}
}
