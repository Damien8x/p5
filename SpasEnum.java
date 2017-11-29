// Author: Damien Sudol
// Filename: SpasEnum
// Date: 11/29/17
// Version: 1.0

// package and imports
package p5;
import java.util.*;

// class extendds functionality of SequenceEnum and its hierarchy
// SpasEnum > SequenceEnum > Inverter > Sequence
public class SpasEnum extends Inverter{

// Description: Constructor accepts argument of type String, passes argument to it's 
// super class and through the class hierarchy, utilizing the methods found in
// class Sequence.
public SpasEnum(String word)
{
super(word);
}

// Description: Ovverides inherited SequenceEnum.getVariant() method.
// Based on length of the encapsulated "word" the a concatenation
// of "word" will be returned through helper function concatenate, or
// a truncation of "word" will be retuned through helper function
// truncate.
// Precondition: ON
// Postcondition: ON
public String getVariant()
{

	if(word.length() %2 == 0)
	{
		String concat = concatenate();
		return concat;
	}
	else
	{
		 String trunc = truncate();
		 return trunc;
	}
}

//Description: helper function for getVariant(), returning a concatenation
//of encapsulated word and a randomly generated subsequence.
//precondition:ON 
//modify: None
//postcondition:ON
private String concatenate()
{
	String tempWord = word;
	int wordSize = word.length();
	int randomPosition = (int)(Math.random() * (wordSize - 1) + 0);
	String concat = tempWord.substring(randomPosition, wordSize);
	concat = tempWord+concat;
	return concat;
}


//Description: helper function for getVariant(), returning a truncated
//random subsequence of encapsulated word.
//precondition: ON
//modify: None
//postcondition: ON
private String truncate()
{
	String tempWord = word;
	int wordSize = word.length();
	int randomPosition = (int)(Math.random() * (wordSize) + 1) ;
	String truncate = tempWord.substring(0, randomPosition);
	return truncate;
}

}
