// Author: Damien Sudol
// Filename: Inverter
// Date: 11/29/17
// Version 1.0


// package and imports
package p5;
import java.util.*;
import java.lang.*;

// Class Inverter extends Class Sequence, utilizing all available
// public methods, including the Sequence constructor.
class Inverter extends Sequence{

// Description: Accepts one parameter of type string. By utilizing 
// the parent class Sequence, any argument less than three characters
// will have the character "a" appended until the minimum number 
// of characters is met. Constructor passes argument to the construcor
// of it's parent class, Sequence.
// Precondtion: None.
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


public String toString()
{
	return "Your word is: " + this.word;
}

public boolean equals(Sequence obj)
{
	if (!(obj instanceof Inverter))
		return false;
	else if(obj.word.equals(word))
		return true;
	else
		return false;
}

public int hashCode()
{
	return (this.word.hashCode());

}

}

