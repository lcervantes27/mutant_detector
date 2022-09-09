package com.lgcm.mutantDetector.utilities;
/**
 * @author lgerardocv@gmail.com
 * Class with utilities for mutant detection
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class MutantUtilities {
	/*
	 *Validation for user input 
	 * */
	public boolean inputValidation(String[] dna) {
		int size=dna.length;
		long wrong_inputs=Arrays.stream(dna).filter(
				n -> n.length()!=size||
				!Pattern.matches("^[ATCG]+$", n)
			).count();
		if(wrong_inputs==0) {
			return true;
		}
		return false;
	}
	
	/*
	 *Validation for a valid DNA serie
	 * */
	public boolean isMutant(String[] dna) {
		String[] dna_series= SeriesUtilities.getAllSeries(dna); 
		//System.out.println("DNA SERIES: "+Arrays.toString(dna_series));
		if(countMutantSeries(dna_series)>1) {
			return true;
		}
		return false;
	}
	
	/*
	 *Count number of series with mutant gen 
	 * */
	public int countMutantSeries(String[] dna_series) {
		String[] mutant_series=Arrays.stream(dna_series).filter(n ->(
						n.contains("AAAA")||
						n.contains("TTTT")||
						n.contains("CCCC")||
						n.contains("GGGG")
					)
				).toArray(String[]::new);
		//System.out.println("SEIRES WITH MUTANT GEN:"+Arrays.toString(mutant_series));
		if (mutant_series.length!=1) {
			return mutant_series.length;
		}
		else {
			return countMutantSeriesSingleLine(mutant_series[0]);
		}
	}
	
	/*
	 *Check number of mutants gens in a  DNA serie 
	 * */
	public int countMutantSeriesSingleLine(String dna_serie) {
		Queue<Character> q= new LinkedList<>();
		int counter =0;
		for (char ch: dna_serie.toCharArray()) {
			if(q.peek()==null||ch!=q.peek()) {
				if (q.size()>=4) {
					counter++;
					if (counter>1) {
						return counter;
					}
				}
				q.clear();
				q.add(ch);
			}
			else {
				q.add(ch);
			}
		}
		if (q.size()>=4) {
			counter++;
		}
		return counter;
	}
}
