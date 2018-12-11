package DailyCodingProblem4;

/*
Given a string, remove the vowels from the string and print the string without vowels.
 */

public class RemoveVowelsFromString {

	// This method removes all vowels from a string
	public static String removeVowels(String line) {

		// StringBuffer becus of mutability, you can delete StringBuffer
		// contents & modify it using deleteCharAt(index) method
		StringBuffer sb = new StringBuffer(line);

		for (int i = 0; i < sb.length(); i++) {
			// wherever find a, e, i, o or u , delete it
			if (sb.charAt(i) == 'a' | sb.charAt(i) == 'e' | sb.charAt(i) == 'i' | sb.charAt(i) == 'o'
					| sb.charAt(i) == 'u') {
				sb = sb.deleteCharAt(i);

				// re-initialize string to 0, i.e. start processing string again
				// from the start becus if 2 vowels appear simultaneously next
				// vowel will get skipped
				i = 0;
			}
		}

		// returns String representation of StringBuffer object
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("what is your name ? : " + removeVowels("what is your name ?"));
		System.out.println("welcome to reverse engineering : " + removeVowels("welcome to reverse engineering"));
	}

}
