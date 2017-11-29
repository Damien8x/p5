// Author: Damien Sudol
// Filename: SeqExtract
// Date: 11/29/17
// Version: 1.0

// package and imports
package p5;
import java.util.*;

// Class Extends functionality of Class SequenceEnum
public class SeqExtract extends Inverter{

// private attributes used by method getVariant() and setSubSeq().
private String subSeq;
private int count;
// Description: Accepts one parameter of type string. By utilizing 
// the parent class (Sequence > Inverter), any argument less than three characters
// will have the character "a" appended until the minimum number 
// of characters is met. Constructor passes argument to the construcor
// of it's parent class, Inverter, which calls it's parent class Sequence.
// A default value for subSeq and count, used by getVariant and setSubSeq is set.
// Precondtion: None.
// Postcondition: State 1: ON
//		  State 2: OFF
public SeqExtract(String word)
{
super(word);
count = 0;
subSeq = "Sub Sequence Not Set";
}

// Description: Accepts argument of type String, setting the attribute
// "subSeq" to its value. Count is increased by one for reference by 
// method getVariant();
// Precondition:  State 1: ON
//		  State 2: May or May not be ON
// Postcondition: State 1: ON
//		  State 2: ON
public void setSubSeq(String subSeq)
{
this.subSeq = subSeq;
this.count++;
}

// Description: Method overrides parent class, returning a String based
// on the value of "subSeq" and the state of the object. If attribute "count"
// is greater than 0 it ensures subSeq is set to a value other than it's default
// and that the object's state is on for both State 1 and State 2. 
// ~~~  Code is re-used from file p4.SeqExtract.cpp
// ~~~  Syntax has been changed to work with Java
//
//			*Possible Return Values*
//
// If State 2 is OFF:			Returns  Default Value of SubSeq
// If argument equals "word":		Returns String "Word Match"
// If arguments length > "word":	Returns String "Word Too Long"
// If argument is subString of 
// the beginning of "word":		Retruns ending subString 
// If argument is substring of
// the end of "word"			Returns beginning subString
// If argument is not a subString	Returns String "No substring detected"
// Precondition:  State 1: ON
// 		  State 2: ON
// Postcondition: State 1: ON
// 		  State 2: ON

public String getVariant()
{
	if (count < 1)
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
}
