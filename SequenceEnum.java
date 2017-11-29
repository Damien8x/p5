// Author: Damien Sudol
// Filename: SequenceEnum
// Date: 11/29/17
// Version: 1.0

// package and imports
package p5;
import java.util.*;
import java.lang.*;

// class extends functionality of class Inverter
// (Sequence > Inverter > SequenceEnum)
public class SequenceEnum extends Inverter {

// private String wordVariant, utilized by getVariant and
// helper methodd recursieVariant.
private String wordVariant;

// Description: Constructor, argument is passed through class
// hierarchy, --> Inverter --> Sequence and set to attribute "word".
// wordVariant is set to value of word.
// Precondition: OFF
// Postcondition: ON
public SequenceEnum(String p_word)
{
super(p_word);
this.wordVariant = p_word;
}

// Description: Returns a String variant of encapsulated word. Returned
// String may contain one or many repeating characters from attribute "word",
// as well as all characters of word in the same sequence relative to original 
// characters. This is accomplished by a call to recursive function, recursiveVariant().
// Precondition: ON
// Postcondition: ON
public String getVariant()
{	
	String temp = recursiveVariant();
	wordVariant = word;
	return temp;	
}

// Description: Helper method responsible for generating and returning the 
// variant word for getVariant, per method description.
// Precondition: ON
// Postcondition: ON
private String recursiveVariant()
{
	int wordLength = word.length();
	int randomPosition = (int)(Math.random() * (wordLength- 1) + 0); 
	if(randomPosition % 2 == 0)
	recursiveVariant();
	StringBuilder str = new StringBuilder(wordVariant);
	char variantChar = word.charAt(randomPosition);
	str.insert(randomPosition, variantChar); 
	wordVariant = str.toString();
	return wordVariant;
}

}
