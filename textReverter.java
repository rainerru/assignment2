public class textReverter implements Assignment2 {

	public String translate(String inputString) {

		StringBuilder resultString = new StringBuilder();

		int index = goToNextNonBlankCharacter(inputString,resultString,0);

		while ( index < inputString.length() && inputString.charAt( index ) != '.' ) {
			index = addWord( inputString, resultString, index );
			index = goToNextNonBlankCharacter( inputString, resultString, index );
			index = addRevertedWord( inputString, resultString, index );
			index = goToNextNonBlankCharacter( inputString, resultString, index );
		}
		resultString.append(".");

		return resultString.toString();

	}

	public int addRevertedWord ( String input, StringBuilder output, int givenIndex ) {

		int index = givenIndex;
		while ( index < input.length() &&
						input.charAt( index ) != ' ' &&
						input.charAt( index ) != '.' 
					) {
			index = addRevertedWord( input, output, ++index );
			output = output.append( String.valueOf( input.charAt( givenIndex ) ) );
		}
		return index;

	}

	public int addWord ( String input, StringBuilder output, int givenIndex ) {

		int index = givenIndex;
		while ( index < input.length() &&
					  input.charAt( index ) != ' ' &&
						input.charAt( index ) != '.' 
					) {
			output = output.append( String.valueOf( input.charAt( index ) ) );
			index++;
		}
		return index;

	}

	public int goToNextNonBlankCharacter ( String input, StringBuilder output, int givenIndex ) {

		int index = givenIndex;
		while ( index < input.length() && input.charAt( index ) == ' ' ) {
			output = output.append(" ");
			index++;
		}
		return index;

	}

}
