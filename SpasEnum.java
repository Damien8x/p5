// Author: Damien Sudol
// Filename: SpasEnum.cpp
// Date: 11/08/17
// Version: 1.0

package p5;
import java.util.*;


public class SpasEnum extends SequenceEnum{

public SpasEnum(String word)

{
super(word);
}

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
	
private String concatenate()
{
	String tempWord = word;
	int wordSize = word.length();
	int randomPosition = (int)(Math.random() * (wordSize - 1) + 0);
	String concat = tempWord.substring(randomPosition, wordSize);
	concat = tempWord+concat;
	return concat;
}
private String truncate()
{
	String tempWord = word;
	int wordSize = word.length();
	int randomPosition = (int)(Math.random() * (wordSize) + 1) ;
	String truncate = tempWord.substring(0, randomPosition);
	return truncate;
}

}
