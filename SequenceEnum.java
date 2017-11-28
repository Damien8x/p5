//  Author: Damien Sudol
// Filename: SequenceEnum
// Date: 11/08/17
// Version: 1.0

package p5;
import java.util.*;
import java.lang.*;

public class SequenceEnum extends Inverter {

public SequenceEnum(String p_word)
{
super(p_word);
}
public String getVariant()
{	
	String temp = recursiveVariant();
	wordVariant = word;
	return temp;	
}

public boolean guessWord(String guessWord)
{
	return (word.equals(guessWord)) ? true : false;
}




private String recursiveVariant()
{

	StringBuilder str = new StringBuilder(wordVariant);

	int wordLength = word.length();
	int randomPosition = (int)(Math.random() * (wordLength- 1) + 0); 
	if(randomPosition % 2 == 0)
		recursiveVariant();
	char variantChar = word.charAt(randomPosition);
	str.insert(randomPosition, variantChar); 
	wordVariant = str.toString();
	return wordVariant;

}

}
