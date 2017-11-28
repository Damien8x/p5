package p5;
import java.util.*;



public class Sequence{

String word;
String wordVariant;

int UPPER_BOUND_WORD_MIN = 2;
String APPEND_TO_WORD = "a";


public Sequence(String p_word)
{
	if (p_word.length() > UPPER_BOUND_WORD_MIN)
	{
		this.word = p_word;
		this.wordVariant = p_word;
	}
	else
	{
		while(p_word.length() <= UPPER_BOUND_WORD_MIN)
		{
			p_word += APPEND_TO_WORD;
		}
	
	this.word = p_word;
	this.wordVariant = p_word;
	}
}
public String getWord() 
{
	return word;
}

}
