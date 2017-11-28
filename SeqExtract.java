// Author: Damien Sudol
// Filename: SeqExtract.cpp
// Date: 11/08/17
// Version: 1.0

package p5;
import java.util.*;

public class SeqExtract extends SequenceEnum{

public SeqExtract(String word)
{
super(word);
}

public String getVariant(String subSeq)
{
	if(word.equals(subSeq))
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

/*
private String getVariant()
{
 
	return "";
}
*/
}
