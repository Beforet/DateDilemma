package datedilemma;

import java.util.ArrayList;

/**
 * 
 * @author Patrick
 * This project takes a set of malformed dates
 * and makes them conform to the ISO 8601 standard
 * (YYYY-MM-DD)
 */

public class DateDilemma {	

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add("2/13/15");
		input.add("1-31-10");
		input.add("5 10 2015");
		input.add("2012 3 17");
		input.add("2001-01-01");
		
		ArrayList<String> output = new ArrayList<String>();
		
		for(String current : input){
			Date date = new Date();
			char[] ca = current.toCharArray();			
			for(int i = 0; i < ca.length; i++){
				if(!Character.isDigit(ca[i])){
					ca[i] = ' ';
				}
			}
			String separatedString = new String(ca);
			String[] splitString = separatedString.split(" ");
			String newDate;
			if(splitString[0].length() == 4){
				newDate = correctYearFirst(splitString);
			} else {
				newDate = correctMonthFirst(splitString);
			}
			output.add(newDate);
		}
		
		for(String str : output){
			System.out.println(str);
		}
	}
	
	public static String correctYearFirst(String[] badDate){		
		if(badDate[0].length() == 2) {
			badDate[0] = "20" + badDate[0];
		}
		if(badDate[1].length() == 1){
			badDate[1] = "0" + badDate[1];
		}
		if(badDate[2].length() == 1){
			badDate[2] = "0" + badDate[2];
		}
		return String.join("-", badDate);
	}
	
	public static String correctMonthFirst(String[] badDate){
		String[] yearFirst = {badDate[2],
		                      badDate[0],
		                      badDate[1]};
		return correctYearFirst(yearFirst);
	}

}
