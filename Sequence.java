// Filename: Sequence
// Date: 11/29
// Version 1.0

// Description: Base abstract class which all pattern recognition classes extends from.
// Class provides common functionality utilized by all child classes, including;
// Sequence Constructor which encapsulates a word, appending the character 'a'
// to the end of any passed argument under 3 characters until a minimum of 3
// characaters is met, then assigning the value to attribute "word". Class also
// provides the method guessWord(string) which compares an argument to the encapsulated
// word, returning true if they match. Sequence also contains abstract method getVariant()
// which all child classes must override to allow instantiation.

// Assumptions: Sequence is an abstract class which cannot be instantiatied. It is designed
// as base class, utilized for its functions and design, while allowing for containment of 
// all objects which decend from Sequence.
// SeqExtract, SpasEnum, SequenceEnum, Inverter IS-A Sequence
//
//	  * No State Transitions *
//	OBJECT CANNOT BE INSTANTIATED 

// pacakage and imports
package p5;
import java.util.*;

// Abstract Class. Cannot be instantiated
public abstract class Sequence{

// protected attribute "word" accesible to child classes
protected String word;

// class Constants
private int UPPER_BOUND_WORD_MIN = 2;
private String APPEND_TO_WORD = "a";

// Description: Constructor encapsulates String argument, assigning
// it to class attribute "word".
// Class Invariants: Any argument less than 3 characters will have the character 'a'
// appended until the  minimum length is met before assignment to "word".
// Interface Invariants:
//	-Argument of Type String
//	-Minimum of 3 characters to avoidd modification.
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

// Description: Returns boolean for if argument is equal to attribute "word"
// Class Invariants: No data members impacted by method call.
// Interface Invariants:
//	-Argument of Type String
//	-No length requirements
//	-No limit to method calls
// Precondition: ON
// Postcondition: ON
public boolean guessWord(String guessWord)
{
	return (word.equals(guessWord)) ? true : false;
}


// Description: abstract method, requiring all child class' to override
// method getVariant()
abstract String getVariant();

}
