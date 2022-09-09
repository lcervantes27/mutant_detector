package com.lgcm.mutantDetector.utilities;
/**
 * @author lgerardocv@gmail.com
 * Class with utilities for mutant detection
 */
import java.util.Arrays;

public class SeriesUtilities {
	
	/*
	 * Get all series from a DNA matrix
	 * */
	public static String[] getAllSeries(String[] dna) {
		String[] dna_series= dna; 
		String[] verticalSeries =SeriesUtilities.verticalSeries(dna_series);
		String[] diagonalSeries =SeriesUtilities.diagonalSeries(dna_series);
		String[] diagonalSeriesInv =SeriesUtilities.diagonalSeriesInv(dna_series);
		dna_series=ArrayConcatUtil.concatWithCollection(dna_series, verticalSeries);
		dna_series=ArrayConcatUtil.concatWithCollection(dna_series, diagonalSeries);
		dna_series=ArrayConcatUtil.concatWithCollection(dna_series, diagonalSeriesInv);
		return dna_series;
	}
	
	/*
	 * Get vertical series from a DNA matrix
	 * */
	public static String[] verticalSeries(String[] dna) {
		int n=dna.length;
		String[] vertical_series= new String[n];  
		for(int i=0;i<n;i++) {
			String verticalString="";
			for(int j=0;j<n;j++) {
				verticalString=verticalString+dna[j].charAt(i);
			}
			vertical_series[i]=verticalString;
		}
		return vertical_series;
	}
	
	/*
	 * Get diagonal series from a DNA matrix
	 * */
	public static String[] diagonalSeries(String[] dna) {
		int length = dna.length;
		int diagonalLines = (length + length) - 1;
		int midPoint = (diagonalLines / 2) + 1;
		String[] diagonal_series= new String[diagonalLines]; 
		int itemsInDiagonal=0;
		for (int i = 1; i <= diagonalLines; i++) {
			int rowIndex;
			int columnIndex;
			String diagonalString="";

			if (i <= midPoint) {
			    itemsInDiagonal++;
			    for (int j = 0; j < itemsInDiagonal; j++) {
			        rowIndex = (i - j) - 1;
			        columnIndex = j;
			        diagonalString=diagonalString+dna[rowIndex].charAt(columnIndex);
			    }
			} else {
			    itemsInDiagonal--;
			    for (int j = 0; j < itemsInDiagonal; j++) {
			        rowIndex = (length - 1) - j;
			        columnIndex = (i - length) + j;
			        diagonalString=diagonalString+dna[rowIndex].charAt(columnIndex);
			    }
			}
			diagonal_series[i-1]=diagonalString;
		}
		return diagonal_series;
	}
	
	public static String[] diagonalSeriesInv(String[] dna) {
		int length = dna.length;
		int diagonalLines = (length + length) - 1;
		String[] diagonal_series= new String[diagonalLines]; 
		int index_serie=0;
		for (int i = 0; i < length; i++) {
	        int row = 0, col = i;
	        String diagonalString="";
	        String diagonalString2="";
	        while (col < length && row < length) {
	        	if(row==col) {
	        		diagonalString=diagonalString+dna[row].charAt(col);
	        	}
	        	else {
	        		diagonalString=diagonalString+dna[row].charAt(col);
		        	diagonalString2=diagonalString2+dna[col].charAt(row);
	        	}
	            row++;
	            col++;
	        }
	        diagonal_series[index_serie]=diagonalString;
	        index_serie++;
	        if(diagonalString2!="") {
	        	diagonal_series[index_serie]=diagonalString2;
		        index_serie++;
	        }
	    }
		return diagonal_series;
	}
}
