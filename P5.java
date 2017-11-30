// Author: Damien Sudol
// Filename: P5
// Date: 11/29/17
// Version 1.0

package p5;
import java.util.*;
import java.lang.*;

// Description: Driver designed to test full functionality and boundries of
// invariants set forth in each respective class; Sequence, SequenceEnum,
// Inverter, SeqExtract and SpasEnum. All public methods will be tested for each
// class Type, with a random distribution of Objects, insuring all remain distinct
// and behave as expected. All state transitions will be tested as well as repeat
// calls, sequential calls and different parameters tested against all public methods.
// Type extension will be tested where applicable, ensuring all derived classes 
// maintain functional integrity and are of a IS-A relationship with parent/grandparent
// classes.
//
// Assumptions: Test full functionality of all classes and their public methods to 
// ensure they are logical in design and are self maintained and managed for 
// the purpose of being used in a pattern recognition application.

public class P5{
static String BREAK = "~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~";

public static void main(String[] args) {

Sequence sqe 	= new SequenceEnum("test SequenceEnum");
Sequence sqe2 	= new SequenceEnum("test SequenceEnum2");
Sequence sqe3 	= new SequenceEnum("test SequenceEnum_3");
Sequence sp 	= new SpasEnum("test SpasEnum");
Sequence sx 	= new SeqExtract("test SeqExtract");
Sequence iv 	= new Inverter("test Inverter");
Sequence iv2 	= new Inverter("equality test");
Sequence iv3	= new Inverter("equality test");

Sequence sqe4	= new SequenceEnum("");
Sequence sp1 	= new SpasEnum("O");
Sequence sx1 	= new SeqExtract("p");
Sequence iv4	= new Inverter("th");

SeqExtract sx2	= new SeqExtract("SeqExtract Functionality");


ArrayList<Sequence> sequenceList = new ArrayList<Sequence>(5);

sequenceList.add(sqe);
sequenceList.add(sp);
sequenceList.add(sx);
sequenceList.add(iv);
sequenceList.add(sqe2);
sequenceList.add(sqe3);

for (Sequence ies : sequenceList){
	if(ies instanceof SeqExtract)
		((SeqExtract)ies).setSubSeq("test Seq");
}

printWelcomeMessage();
printSequenceList(sequenceList);
printPossibleSeqExtract();

}

public static void printSequenceList(ArrayList<Sequence> sequenceList) {

for (Sequence esq : sequenceList){ 
	System.out.println();
	System.out.println(esq.toString());
	System.out.println("Type:\t\t\t" + esq.getClass().getSimpleName()); 
	System.out.println("Variant:\t\t" + esq.getVariant());
	System.out.println("Hash Code:\t\t" + esq.hashCode());
	System.out.println("Re-test Hash Code: \t" + esq.hashCode());
	System.out.println("Equal To Self:\t\t" + esq.equals(esq));
	System.out.println(BREAK);

}
}

public static void printPossibleSeqExtract(){

SeqExtract sx = new SeqExtract("Test SeqExtract");
System.out.println("Default:\t" + sx.getVariant());
sx.setSubSeq("");
System.out.println("No Substring:\t" + sx.getVariant());
sx.setSubSeq("Test SeqE");
System.out.println("xtract:\t\t" + sx.getVariant());
sx.setSubSeq("xtract");
System.out.println("Test SeqE:\t" + sx.getVariant());
sx.setSubSeq("Test SeqExtract");
System.out.println("Word Match:\t" + sx.getVariant());
System.out.println(BREAK);

}

public static void printWelcomeMessage(){
 System.out.println(BREAK);
 System.out.println("*\t\t\t\t~Welcome~\t\t\t\t\t*");
 System.out.println("*\t\t\t\t\t\t\t\t\t\t*");
 System.out.println("*\tName: Damien Sudol\t\t\t\t\t\t\t*");
 System.out.println("*\tProject 5 Driver\t\t\t\t\t\t\t*");
 System.out.println("*\tVersion: 1.0\t\t\t\t\t\t\t\t*");
 System.out.println("*\t\t\t\t\t\t\t\t\t\t*");
 System.out.println("*\tDriver designed to test full functionality and limits of classes\t*");
 System.out.println("*\tSequence, Inverter, SequenceEnum, SpasEnum,and SeqExtract.\t\t*");
 System.out.println("*\tALL public methods will be tested for each class type, with a\t\t*");
 System.out.println("*\trandom distribution of objects and insuring all objects remiain\t\t*");
 System.out.println("*\tdistinct. All state transitions will be tested, while adhering to\t*");
 System.out.println("*\tthe contract and invariants set forth by each class, respectively.\t*");
 System.out.println("*\t\t\t\t\t\t\t\t\t\t*");
 System.out.println("*\t\t\t\t\t\t\t\t\t\t*");
 System.out.println(BREAK);


}
}
