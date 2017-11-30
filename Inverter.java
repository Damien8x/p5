// Author: Damien Sudol
// Filename: Inverter
// Date: 11/29/17
// Version 1.0


// Description: Parent class of SequenceEnum, SpasEnum and SeqExtract. Child
// class of Sequence. Through parent class Sequence, Inverter encapsulates
// a word based on the constructor argument, with a minimum length of 3 characters.
// Functionality inherited from parent class Sequence includes; encapsulation and
// possible modification of construcor argument to ensure it is a minimum of three
// characters, and a method which compares an argument to the encapsulated word,
// returning a boolean if they match.

// Assumptions: Class is designed to be extended while fully utilizing the public
// methods of its parent class, where all classes together contribute to a
// pattern recognition test. Relationships are of a IS-A relationship:
// Inverter IS-A Sequence
// SequenceEnum, SpasEnum, SeqExtract IS-A Inverter
//
//	*State Transitions*
//
//Constructor(String) 			       	    -> ON
//Constructor(String)	-> getVariant()		 ON -> ON
//Constructor(String)	-> guessWord(string)	 ON -> ON
//Constructor(String)	-> toString()		 ON -> ON
//Constructor(String)	-> equals(Object)	 ON -> ON
//Constructor(String)	-> hashCode()		 ON -> ON
//getVariant() 		-> guessWord(string)	 ON -> ON
//getVariant()		-> toString()		 ON -> ON
//getVariant()		-> getVariant()		 ON -> ON
//getVariant()		-> equals(Object)	 ON -> ON
//getVariant()		-> hashCode()		 ON -> ON
//guessWord(string) 	-> getVariant()		 ON -> ON
//guessWord(string) 	-> getWord()		 ON -> ON
//guessWord(string)	-> guessWord(string)	 ON -> ON
//guessWord(string)	-> toString()		 ON -> ON
//guessWord(string)	-> hashCode()		 ON -> ON
//guessWord(string)	-> equals(Object)	 ON -> ON
//toString()		-> hashCode()		 ON -> OM
//toString()		-> equals(Object)	 ON -> ON
//toString()		-> toString()		 ON -> ON
//toString()		-> getVariant()		 ON -> ON
//toString()		-> guessWord()		 ON -> ON
//hashCode()		-> getVariant()		 ON -> ON
//hashCode()		-> guessWord(string)	 ON -> ON
//hashCode()		-> toString()		 ON -> OM
//hashCode()		-> hashCode()		 ON -> ON
//hashCode()		-> equals(Object)	 ON -> ON
//equals(Object)	-> getVariant()		 ON -> ON
//equals(Object)	-> guessWord(string)	 ON -> ON
//equals(Object)	-> toString()		 ON -> ON
//equals(Object)	-> hashCode()		 ON -> ON
//equals(Object)	-> equals(Object)	 ON -> ON


// package and imports
package p5;
import java.util.*;
import java.lang.*;

// Class Inverter extends Class Sequence, utilizing all available
// public and protected methods, including the Sequence constructor.
class Inverter extends Sequence{

// Description: Constructor utilizes super class Sequence,
// passing method argument to parent class constructor. If character
// minimum is not met, 'a' will be appended until 3 string is 
// 3 characters before being assigned to "word" attribute.
// Class Invariants: argument will be assigned to attribute "word"
// in parent class unmodified if interface invariants are met.
// Interface Invariants:
//	-Of Type String
// 	-Minimum of 3 characters to avoid modification
// Precondtion: None
// Postcondition: On
public Inverter(String word)
{
	super(word);
}


// Description: Method generates a random position within the 
// attribute "word" between index 0 and word.length() -1. The 
// character at this random position will swap position (index)
// with the following character. This newly generated String  
// will be returned.
// Class Invariants: No data member impacted by method call.
// Interface Invariants
//	-Object must be in valid state
//	-No limit on method calls
// Precondition: ON
// Postcondition: ON
public String getVariant()
{

	int wordLength = word.length();
	int randomPosition = (int)(Math.random() * (wordLength -1) + 0);
	char variantChar = word.charAt(randomPosition);
	char invertedChar = word.charAt(randomPosition + 1);
	String tempWord = word;
	StringBuilder sb = new StringBuilder(tempWord);
	sb.deleteCharAt(randomPosition);
	sb.deleteCharAt(randomPosition);
	sb.insert(randomPosition, variantChar);
	sb.insert(randomPosition, invertedChar);
	tempWord= sb.toString();
	return tempWord;


}

// Description: Returns a formatted String which displays
// the encapsulated word.
// Class Invariants: No data member impacted by method call.
// Interface Invariants: 
//	-Object in valid state
//	-No limit on method calls 
// Precondition: ON
// Postcondition: ON
public String toString()
{
	return "Encapuslated word:\t" + this.word;
}

// Description: Returns true if passed argument is
// of same type as *this* and if the encapsulated word is
// *equal* to *this*, using the String class' equals method.
// Class Invariants: No data member impacted by  method call.
// Interface Invariants: 
//	-Object must be in valid state
//	-Argument may be any Object in any State 
//	-No limit on method calls
// Precondition: ON
// Postcondition: ON 
public boolean equals(Object obj)
{
	if (!(obj instanceof Inverter))
		return false;
	else if(((Inverter)obj).word.equals(word))
		return true;
	else
		return false;
}

// Description: Overrides hashCode() method, returning an integer
// value based on using the String hashCode() and multiplying by
// the prime number 37.
// Class Invariants: No data member impacted by method call.
// Interface Invariants
//	-Object must be in valid state
//	-No limit on method calls
// Precondition: ON
// Postconditiion: ON
public int hashCode()
{
	return 37 * (this.word.hashCode());

}

}

