// Author: Damien Sudol
// Filename: SpasEnum
// Date: 11/29/17
// Version: 1.0

// Description: Child class of Inverter. Grandchild class of Sequence. Through
// parent class Inverter and base class Sequence, class encapsulates a word
// based on the constructor argument, with a minimum length of 3 characters.
// Functionality inherited includes; encapsulation and possible modification of 
// construcotr argument to ensure it is a minimum of three characters, method
// guessWord(string) which compares argument to the encapsulated word, returning 
// true if they match, as well as provided equals(Object), toString() and hashCode()
// methods.
//
// Assumptions: Class is designed to be minimal while utilizing all inherited 
// functions, contributing a distinct output pattern from overridden method getVariant().
// All classes contribute to the development of a pattern recognition test.

// SeqExtract IS-A Sequence
// SeqExtract IS-A Inverter
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

//NOTE:	 ~class utilizes logic and portions of code from P4~
//	  ~all Syntax has been changed to work with Java~



// package and imports
//package p5;
import java.util.*;

// class extends functionality of class hierarchy 
// SpasEnum -> Inverter -> Sequence
public class SpasEnum extends Inverter{

// Description: Constructor, argument is passed through class
// hierarchy, --> Inverter --> Sequence and set to attribute "word".
// Class Invariants: argument will be assigned to attribute "word"
// unmodified if interface invariants are met.
// Interface Invariants:
//	-Argument of Type String
//	-Minimum of 3 characters to avoid modification
// Precondition: None
// Postcondition: ON
public SpasEnum(String word)
{
super(word);
}

// Description: Ovverides inherited getVariant() method.
// Based on a random number, either the a concatenation
// of "word" will be returned through helper function concatenate, or
// a truncation of "word" will be retuned through helper function
// truncate.
// Class Invariants: Output dependent on random number "arbNumber",
// arbitrarily determining whether to truncate or  concatenate.
// Repeat calls may or may not result in different return  values.
// Interface Invariants:
//	-Object must be in valid state
//	-No limit on method calls
// Precondition: ON
// Postcondition: ON
public String getVariant()
{
	int arbNumber = (int)(Math.random() * (10) + 1);
	if(arbNumber %2 == 0)
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
	if (!(obj instanceof SpasEnum))
		return false;
	else if(((Inverter)obj).word.equals(word))
		return true;
	else
		return false;
}


}
