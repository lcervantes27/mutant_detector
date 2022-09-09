package com.lgcm.mutantDetector.domain;
/**
 * @author lgerardocv@gmail.com
 * Class for DNA series input
 */
import java.util.Arrays;


public class DNASerie {
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "[dna=" + Arrays.toString(dna) + "]";
	}
	
	
	
}
