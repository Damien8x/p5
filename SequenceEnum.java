// Author: Damien Sudol
// Filename: SequenceEnum
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
package p5;
import java.util.*;
import java.lang.*;

// class extends functionality of class hierarchy 
// SequenceEnum -> Inverter -> Sequence
public class SequenceEnum extends Inverter {

// private String wordVariant, utilized by getVariant and
// helper methodd recursieVariant.
private String wordVariant;

// Description: Constructor, argument is passed through class
// hierarchy, --> Inverter --> Sequence and set to attribute "word".
// wordVariant is set to value of word.
// Class Invariants: argument will be assigned to attribute "word"
// unmodified if interface invariants are met.
// Interface Invariants:
//	-Argument of Type String
//	-Minimum of 3 characters to avoid modification
// Precondition: None
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
// Class Invariants: Output dependent on method recursiveVariant.
// Interface Invariants:
//	-Object must be in valid state
//	-No limit on method calls
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
// Interface Invariants: None
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
