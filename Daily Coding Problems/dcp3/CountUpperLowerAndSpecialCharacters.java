package DailyCodingProblem3;

import java.util.ArrayList;
import java.util.Scanner;

/*
Given a string, write a program to count the occurrence of Lowercase characters, Uppercase characters, Special characters and Numeric values. 

lowercase : a to z
uppercase : A to Z
numerics : 0 to 9
special characters : !@#$%^&*.;[space]
 */

public class CountUpperLowerAndSpecialCharacters {

	//Method that counts number of different characters in a given line
	//This method will count for uppercase, lowercase, special & numeric characters in a line
	public static void countNumberOfCharacters(String line) {
		int numberOfUpperCharacters = 0;
		int numberOfLowerCharacters = 0;
		int numberOfSpecialCharacters = 0;
		int numberOfNumericCharacters = 0;

		// List of special characters to look for
		ArrayList<Character> specialCharacters = new ArrayList<Character>() {
			{
				add('!');
				add('@');
				add('#');
				add('$');
				add('%');
				add('^');
				add('^');
				add('&');
				add('*');
				add('.');
				add(';');
				add(' ');
			}
		};

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
				numberOfLowerCharacters++;
			} else if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
				numberOfUpperCharacters++;
			} else if (specialCharacters.contains(line.charAt(i))) {
				numberOfSpecialCharacters++;
			} else if (line.codePointAt(i) >= 48 && line.codePointAt(i) <= 57) {
				numberOfNumericCharacters++;
			}
		} // end of for loop

		System.out.println("Lowercase : " + numberOfLowerCharacters);
		System.out.println("Uppercase : " + numberOfUpperCharacters);
		System.out.println("Special : " + numberOfSpecialCharacters);
		System.out.println("Numeric : " + numberOfNumericCharacters);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter line : ");
		String line = sc.nextLine();
		countNumberOfCharacters(line);
	}

}
