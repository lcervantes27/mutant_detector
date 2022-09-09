package com.lgcm.mutantDetector.domain;
/**
 * @author lgerardocv@gmail.com
 * Class for stats response
 */
public class Stats {
	private long count_mutant_dna;
	private long count_human_dna;
	private float radio;
	
	public long getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(long count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public long getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(long count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	public float getRadio() {
		return radio;
	}
	public void setRadio(float radio) {
		this.radio = radio;
	}
	@Override
	public String toString() {
		return "Stats [count_mutant_dna=" + count_mutant_dna + ", count_human_dna=" + count_human_dna + ", radio="
				+ radio + "]";
	}
	
	
}
