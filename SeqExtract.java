// Author: Damien Sudol
// Filename: SeqExtract
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

// Class Extends functionality of Class Inverter 
public class SeqExtract extends Inverter{

// private attributes used by method getVariant() and setSubSeq().
private String subSeq;
private boolean subSeqSet;

// Description: By utilizing 
// the class hirearchy, -> Inverter -> Sequence,  any argument less than three characters
// will have the character "a" appended until the minimum number 
// of characters is met. Constructor passes argument to the construcor
// of it's parent class, Inverter, which calls it's parent class Sequence.
// A default value for subSeq and subSeqSet, used by getVariant and setSubSeq is set.
// Class Invariants: Argument must be of type String. Any argument under 3 characters will
// be modified, having 'a' appended to end until String is at least 3 characters.
// Interface Invariants:
//	-Argument of Type String
//	-Minimum of 3 characters to avoid modification
// Precondtion: None.
// Postcondition: State: ON
public SeqExtract(String word)
{
super(word);
subSeqSet = false;
subSeq = "Sub Sequence Not Set";
}

// Description: Accepts argument of type String, setting the attribute
// "subSeq" to its value. Count is increased by one for reference by 
// method getVariant();
// Class Invariants: Method getVariant() is dependent on setSubSeq().
// If setSubSeq has not been called then getVariant() will always return
// the default value, "Sub Sequence Not Set".
// Interface Invariants:
//	-Argument of Type String
//	-No length requirements
// Precondition:  State: ON
// Postcondition: State ON
public void setSubSeq(String subSeq)
{
this.subSeq = subSeq;
this.subSeqSet = true;
}

// Description: Method overrides parent class, returning a String based
// on the value of class attribute "subSeq". No call to method setSubSeq
// will result in a default return value. Multiple calls to method without
// changing value of subSeq through additonal calls to setSubSeq will
// always result in the same return value as previous call.
//			*Possible Return Values*
//
// If setSubSeq has not been called:	Returns  Default Value of SubSeq
// If subSeq equals "word":		Returns String "Word Match"
// If subSeq's length > "word":		Returns String "Word Too Long"
// If subSeq is subString of 
// the beginning of "word":		Retruns ending subString 
// If subSeq is substring of
// the end of "word"			Returns beginning subString
// If subSeq is not a subString		Returns String "No substring detected"
//
// Class Invariants: Return value based on class variable "subSeq" in relation
// to class variable "word". 
// Interface Invariants:
//	-Object must be in valid state
//	-No limit on method calls
// Precondition:  State: ON
// Postcondition: State: ON
public String getVariant()
{
	if (subSeqSet == false)
		return subSeq;
	else if(word.equals(subSeq))
		return "Word Match";

	int subSeqSize = subSeq.length();
	int wordSize = word.length();

	if(subSeqSize > wordSize)
		return "Word Too Long";

	int subStringStartSize = wordSize - ( wordSize - subSeqSize);
	int subStringEndSize =wordSize - subSeqSize;
	String subStringEnd = word.substring(subStringStartSize, wordSize);
	String subStringEndSequence = word.substring(subStringEndSize, wordSize);
	String subStringStart = word.substring(0 , subStringEndSize);

	for(int i = 0; i < subSeqSize; i++)
	{
		char c1 = subSeq.charAt(i);
		char c2 = subStringEndSequence.charAt(i);	

		 if(c1 != c2)
			break;
		return subStringStart;
	}

	for(int i = 0; i < subSeqSize; i++)
	{
		char c1 = subSeq.charAt(i);
		char c2 = word.charAt(i);	

	 if(c1 != c2)
			break;
		return subStringEnd;
	}

	return ("No substring detected ");
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
	if (!(obj instanceof SeqExtract))
		return false;
	else if(((Inverter)obj).word.equals(word))
		return true;
	else
		return false;
}


}
