// Author: Damien Sudol
// Filename: P5
// Date: 11/29/17
// Version 1.0

//package p5;
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
//
// Implementation: For purposes of this driver all State transitions, calls to public methods,
// Type extension and inputs will be tested. Intended implementation will always begin with
// the Initialization of a derived Sequence Tyoe, which will encapsulate a word. This should be 
// followed by calls to getVariant() until a *user* guesses (guessWord(String)). Class design 
// allows for mutliple calls to getVariant and guessWord(), all other methods are for application
// designer to utilize for display and Type management.
public class P5{
static String BREAK = "~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~";

public static void main(String[] args) {

// Objects to be addded to ArrayList, designed as benchmark for each class to be tested
Sequence sqe 		= new SequenceEnum("test SequenceEnum");
Sequence sp 		= new SpasEnum("test SpasEnum");
Sequence sx 		= new SeqExtract("test SeqExtract");
Sequence iv 		= new Inverter("test Inverter");

ArrayList<Sequence> sequenceList = new ArrayList<Sequence>(5);

sequenceList.add(sqe);
sequenceList.add(sp);
sequenceList.add(sx);
sequenceList.add(iv);

// Objects to be added to ArrayList, designed to be tested against benchmark for equality
Sequence sqeEqual 	= new SequenceEnum("test SequenceEnum");
Sequence spEqual 	= new SpasEnum("test SpasEnum");
Sequence sxEqual 	= new SeqExtract("test SeqExtract");
Sequence ivEqual 	= new Inverter("test Inverter");

ArrayList<Sequence> sequenceListEqual = new ArrayList<Sequence>(5);

sequenceListEqual.add(sqeEqual);
sequenceListEqual.add(spEqual);
sequenceListEqual.add(sxEqual);
sequenceListEqual.add(ivEqual);


// Objects to be added to ArrayList, designed to be tested against benchmark for equality
Sequence sqeDiffType	= new SpasEnum("test SequenceEnum");
Sequence spDiffType	= new SequenceEnum("test SpasEnum");
Sequence sxDiffType	= new Inverter("test SeqExtract");
Sequence ivDiffType	= new SeqExtract("test Inverter");

ArrayList <Sequence> sequenceListDiffType = new ArrayList<Sequence>(5);

sequenceListDiffType.add(sqeDiffType);
sequenceListDiffType.add(spDiffType);
sequenceListDiffType.add(sxDiffType);
sequenceListDiffType.add(ivDiffType);


// Objects to be added to ArrayList, designed to test appending of 'a' for constructor
// arguments under 3 characters
Sequence sqeAppend	= new SequenceEnum("");
Sequence spAppend 	= new SpasEnum("O");
Sequence sxAppend 	= new SeqExtract("p");
Sequence ivAppend	= new Inverter("th");

ArrayList<Sequence> appendSequenceList = new ArrayList<Sequence>(4);

appendSequenceList.add(sqeAppend);
appendSequenceList.add(spAppend);
appendSequenceList.add(sxAppend);
appendSequenceList.add(ivAppend);

// Display Driver Welcome Message
printWelcomeMessage();

// Test Child Casting for SeqExtract
printTestChildCasting(sequenceList);

// Test all public methods for Sequence derived classes
printSequenceList(sequenceList);

// Test full functionality of SeqExtract with all possible inputs
// to setSubSeq()
printPossibleSeqExtract();

// Test appending of character 'a' for all Sequence Derived Classes
printTestAppend(appendSequenceList);

// Test Equality for equal class type and encapsulated word: expect true
printTestEqual(sequenceList, sequenceListEqual);

// Test Equality for equal class type and non equal encapsulated word: expect false
printTestEqual(sequenceList, appendSequenceList);

// Test Equality for Non equal class type and equal encapsulated word: expect false
// with exception to comparision to Inverter where there is an IS-A relationship
printTestEqual(sequenceList, sequenceListDiffType);

// Displays output for all possible State transitions for all Sequence derived classes
printTestAllStateTransitions(sequenceList);

// Test that ALL classes are derived from Sequence and All classes aside from
// Sequence Extend Inverter
printTestIsA(sequenceList);

// Test Child casting for SeqExtract for 2nd time
printTestChildCasting(sequenceListEqual);

// Test multiple calls to same method, consequatively
printMultipleMethodCalls(sequenceList);
}


// Description: SeqExtract is the only derived class from Sequence with additonal
// public methods. To test the ability for fully functioning type extension
// we demonstrate here, the ability to access the public method setSubSeq()
// so that in a collection of Sequence objects, full functionality of
// SeqExtract objects is possible. Full functionality of seqExtract is
// dependent on legal calls to setSubSeq. 
// Expect intial getVariant() to equal default.
// Expect second getVariant() to equal "Extract")
// Invariants:
//	-ArrayList of Sequence Objects in Legal States
// Precondiiton: All Objects ON
// Modify: objects with an "instanceof" SeqExtract will be modified,
//	   attribute subSeq will be set to "test Seq".
//	   Other types will not be impacted
// Postcondition: All Objects ON
public static void printTestChildCasting(ArrayList<Sequence> sequenceList){

for (Sequence ies : sequenceList){
	if(ies instanceof SeqExtract){
		System.out.println("Original getVariant():\t" + ies.getVariant());
		((SeqExtract)ies).setSubSeq("test Seq");
		System.out.println("Modified getVariant():\t" + ies.getVariant());
}
}
System.out.println(BREAK);
}

// Description: Tests that all classes in collection of Sequence objects
// are of an "instanceof" Inverter and Sequence. Expect results to always
// be true.
// Invariants:
//	-ArrayList of Sequence Objects in Legal States
// Precondition: All Objects ON
// Modify: No impact on objects
// Postcondition: All Objects ON
public static void printTestIsA(ArrayList<Sequence> sequenceList)
{
for( Sequence esq : sequenceList){
System.out.println(esq.getClass().getSimpleName() + "\tIS-A Sequence:\t" +
(esq instanceof Sequence));
System.out.println(esq.getClass().getSimpleName() + "\tIS-A Inverter:\t" +
(esq instanceof Inverter));
System.out.println(BREAK); 
}
}

// Description: Testing of overridden "equals" method for all derived Sequence
// types. Expect true if Type is equal && toString() (encapsulated word) is equal.
// Types may differ and return true if type one is of type Inverter. All Sequence
// derived objects are derived from Inverter as well.
// Invariants:
// 	-Two Arraylist of type Sequence
//	-All objects in Valid legal states
// Precondition: All objects are ON
// Modify: No impact on Objects
// Postcondition: All objects are ON
public static void printTestEqual(ArrayList<Sequence> sequenceList,
ArrayList<Sequence> sequenceListEqual){

for(int i = 0; i < sequenceList.size(); i ++) {
	if(sequenceListEqual.contains(sequenceListEqual.get(i))){
	System.out.println("Obj. 1 Type:\t\t" + sequenceList.get(i).getClass().getSimpleName());
	System.out.println("Obj. 2 Type:\t\t" + sequenceListEqual.get(i).getClass().getSimpleName());
	System.out.println("Obj. 1 toString():\t" + sequenceList.get(i).toString());
	System.out.println("Obj. 2 toString():\t" + sequenceListEqual.get(i).toString());
	System.out.println("Objects Equal:\t\t" + sequenceList.get(i).equals(sequenceListEqual.get(i)));
	System.out.println(BREAK);
	}
}
}

// Description: Testing of All public methods common to all derived Sequence objects.
// Testing for expected functionality of each type's respective getVariant() function.
// re-testing of hashcode ensures entries are static.
// Invariants:
//	-ArrayList of type Sequence
//	-All objects are in Valid states
// Precondition: All objects are ON
// Modify: No impact on Objects
// Postcondition: All objects are ON
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

// Description: SeqExtract is unique in that it has one additonal public method
// which must be accessed for full functionality, setSubSeq(). To ensure functiaonlity
// is as expected for ALL possible logic in getVariant we must call setSubSeq
// with multiple String variations; default (no call to setSubSeq), No subString of 
// encapsulated word, front subString of encapsulated word, back substring of 
// encapsulated word, word match and String longer than encapsulated word.
// Invariants: None
// Precondition: None
// Modify: Object in scope is modified multiple times, first constructed and then
// has attribute subSeq set 5 times before becoming out of scope.
// Postconditon: Object ON (Out of Scope)
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
sx.setSubSeq("Test SeqExtract but too long");
System.out.println("Too Long:\t" + sx.getVariant());
System.out.println(BREAK);

}

// Driver Welcome Message
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

// Description: Prints object.toString() for all objects in a Sequence ArrayList.
// Intended to test the appending of 'a' on Sequece objects with construcotr arguments
// under 3 characters, although acceptable to be used by any Sequence Collection
// which needs to just display contained object's toString() method.
// Invariants:
//	-ArrayList of Type Sequence
//	-All objects are in valid states
// Preconditon: All objects ON
// Modify: No objects impacted
// Postcondition: All objects ON
public static void printTestAppend(ArrayList<Sequence> appendSequenceList){

for (Sequence asq : appendSequenceList){
	System.out.println(asq.toString());
}
System.out.println(BREAK);

}

// Description: Test multiple calls to the same method to ensure consistancy.
// expect all repeat calls with tag "static" to return the same. Some get Variants
// due to the design of method may return dynamic or repeating. Expect that
// any object of type SeqExtract to return static Strings for getVariant()
// for the purpose of this test.
// Invariants:
// 	-ArrayList of type Sequence
//	--All objects are in valid states
// Precondition: All objects are ON
// Modify: No objects impaccted
// Postcondition: All objects ON
public static void printMultipleMethodCalls(ArrayList<Sequence> sequenceList)
{
for (Sequence seq : sequenceList){
	System.out.println("Test multiple calls of toString() (expect static):");
	System.out.println("\t" + seq.toString());
	System.out.println("\t" + seq.toString());
	System.out.println("\t" + seq.toString());
	System.out.println("Test multiple calls of HashCode() (expect static):");
	System.out.println("\t" + seq.hashCode());
	System.out.println("\t" + seq.hashCode());
	System.out.println("\t" + seq.hashCode());
	System.out.println("Test multiple calls to guessWord() (expect static):");
	System.out.println("\t" + seq.guessWord("NOT IT"));
	System.out.println("\t" + seq.guessWord("NOT IT"));
	System.out.println("\t" + seq.guessWord("NOT IT"));
	System.out.println("Test multiple calls to getVariant() (may be static):");
	System.out.println("\t" + seq.getVariant());
	System.out.println("\t" + seq.getVariant());
	System.out.println("\t" + seq.getVariant());
	System.out.println(BREAK);

}
}

// Description: Test all possible State Transitions, excluding repeat calls and 
// call directly from Constructor. Expected output is static for guessWord(),
// toString(), hashCode(), equals() but possibly dynamic for getVariant().
// Invariants:
// 	-ArrayList of Type Sequence
//	-All objects are in valid states
// Precondition: All objects are ON
// Modify: No objects impacted
// Postcondition: All objects are ON
public static void printTestAllStateTransitions(ArrayList<Sequence> sequenceList)
{
for (Sequence seq : sequenceList){
	System.out.println("getVariant()\t\t->\tgetVariant()");
	System.out.println(seq.getVariant() + "\t\t" + seq.getVariant());
	System.out.println("getVariant()\t\t->\tguessWord(String)");
	System.out.println(seq.getVariant() + "\t\t" + seq.guessWord("Random"));
	System.out.println("getVariant()\t\t->\ttoString()");
	System.out.println(seq.getVariant() + "\t\t" + seq.toString());
	System.out.println("getVariant()\t\t->\thashCode()");
	System.out.println(seq.getVariant() + "\t\t" + seq.hashCode());
	System.out.println("getVariant()\t\t->\tequals(Object)");
	System.out.println(seq.getVariant() + "\t\t" + seq.equals(seq));
	System.out.println("guessWord(String)\t->\ttoString()");
	System.out.println(seq.guessWord("guess") + "\t\t\t\t" + seq.toString());
	System.out.println("guessWord(String)\t->\tequals(Object)");
	System.out.println(seq.guessWord("guess") + "\t\t\t\t" + seq.equals(seq));
	System.out.println("guessWord(String)\t->\thashCode()");
	System.out.println(seq.guessWord("guess") + "\t\t\t\t" + seq.hashCode());
	System.out.println("toString()\t\t->\thashCode()");
	System.out.println(seq.toString() + "\t\t\t" + seq.hashCode());
	System.out.println("toString()\t\t->\tequals(Object)");
	System.out.println(seq.toString() + "\t\t\t" + seq.equals(seq));
	System.out.println("hashcode()\t\t->\tequals(Object)");
	System.out.println(seq.hashCode() + "\t\t\t" + seq.equals(seq));
	System.out.println(BREAK);


}
}

}
