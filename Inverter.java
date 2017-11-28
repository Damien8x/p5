package p5;
import java.util.*;
import java.lang.*;

class Inverter extends Sequence{

public Inverter(String word)
{
super(word);
}


public String getVariant(){

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
}

