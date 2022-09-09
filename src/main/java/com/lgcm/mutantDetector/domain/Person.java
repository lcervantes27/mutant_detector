package com.lgcm.mutantDetector.domain;
/**
 * @author lgerardocv@gmail.com
 * Entity for persons(Mutants & No mutants)
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id_person;
	@Column(name="dna_serie")
	private String dna;
	@Column(name="is_mutant")
	private boolean mutant;
	
	public Integer getId_person() {
		return id_person;
	}
	public void setId_person(Integer id_person) {
		this.id_person = id_person;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public boolean isMutant() {
		return mutant;
	}
	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}
	@Override
	public String toString() {
		return "Person [id_person=" + id_person + ", dna=" + dna + ", mutant=" + mutant + "]";
	}
	
	
	
}
