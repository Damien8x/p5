// Filename: Sequence
// Date: 11/29
// Version 1.0

// pacakage and imports
package p5;
import java.util.*;


public abstract class Sequence{

// protected attribute "word" accesible to child classes
protected String word;

// class Constants
private int UPPER_BOUND_WORD_MIN = 2;
private String APPEND_TO_WORD = "a";

// Description: constructor accepts one argument of type String.
// Any argument less than 3 characters will have the character "a"
// appended until the  minimum length is met, before being assigned to
// the class variable "word".
// Preconditon:	  None
// Postcondition: ON 
public Sequence(String p_word)
{
	if (p_word.length() > UPPER_BOUND_WORD_MIN)
	{
		this.word = p_word;
	
	}
	else
	{
		while(p_word.length() <= UPPER_BOUND_WORD_MIN)
		{
			p_word += APPEND_TO_WORD;
		}
	
	this.word = p_word;

	}
}

// Description: Returns attribute "word"
// Precondition: ON
// Postcondition: ON
public String getWord() 
{
	return word;
}

// Description: Returns boolean for if argument is equal to attribute "word"
// Precondition: ON
// Postcondition: ON
public boolean guessWord(String guessWord)
{
	return (word.equals(guessWord)) ? true : false;
}



abstract String getVariant();

}
