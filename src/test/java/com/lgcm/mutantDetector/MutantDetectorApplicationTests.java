package com.lgcm.mutantDetector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.lgcm.mutantDetector.utilities.*;

@SpringBootTest
class MutantDetectorApplicationTests {
	@Autowired
	private static MutantUtilities MutantUtilities;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void inputTest() {
		String[] dnaCorrect = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		String[] dnaWrong1 = {"ATGCGA","CAGTGC","TTATGT","AGAAGGG","CCCCTA","TCACTG"};
		String[] dnaWrong2 = {"ATGCGA","CAGTGC","TTATGT","AGAAGY","CCCCTA","TCACTG"};
		assertEquals(MutantUtilities.inputValidation(dnaCorrect),true);
		assertEquals(MutantUtilities.inputValidation(dnaWrong1),false);
		assertEquals(MutantUtilities.inputValidation(dnaWrong2),false);
	}
	
	@Test
	public void countMutantSeriesSingleLineTest() {
		String dna1 = "CCCCTA";
		String dna2 = "TTTTTATTTTATTTT";
		String dna3 = "TTTTTATTTT";
		String dna4 = "CTCCTA";
		assertEquals(MutantUtilities.countMutantSeriesSingleLine(dna1),1);
		assertEquals(MutantUtilities.countMutantSeriesSingleLine(dna2),2);
		assertEquals(MutantUtilities.countMutantSeriesSingleLine(dna3),2);
		assertEquals(MutantUtilities.countMutantSeriesSingleLine(dna4),0);
	}
	
	@Test
	public void isMutantTest() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		String[] dna2 = {"ATGCGA","CAGTGC","TATTTT","AGACGG","GCGTCA","TCACTG"};
		assertEquals(MutantUtilities.isMutant(dna),true);
		assertEquals(MutantUtilities.isMutant(dna2),false);
	}

}
