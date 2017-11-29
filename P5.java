package p5;
import java.util.*;
import java.lang.*;


public class P5{

public static void main(String[] args) {
String BREAK = "*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~";

Sequence sqe 	= new SequenceEnum("test SequenceEnum");
Sequence sqe1 	= new SequenceEnum("test SequenceEnum2");
Sequence sqe2 	= new SequenceEnum("test SequenceEnum_3");
Sequence sp 	= new SpasEnum("test SpasEnum");
Sequence sx 	= new SeqExtract("test SeqExtract");
Sequence iv 	= new Inverter("test Inverter");
Sequence dd 	= new Inverter("equality test");



ArrayList<Sequence> sequenceList = new ArrayList<Sequence>(5);

sequenceList.add(sqe);
sequenceList.add(sp);
sequenceList.add(sx);
sequenceList.add(iv);
sequenceList.add(sqe1);
sequenceList.add(sqe2);

for (Sequence ies : sequenceList){
	if(ies instanceof SeqExtract)
		((SeqExtract)ies).setSubSeq("test Seq");

}

for (Sequence esq : sequenceList){ 
	System.out.println();
	System.out.println(esq.toString());
	System.out.println("Type:\t\t\t" + esq.getClass().getSimpleName()); 
	System.out.println("Variant:\t\t" + esq.getVariant());
	System.out.println("Hash Code:\t\t" + esq.hashCode());
	System.out.println("Re-test Hash Code: \t" + esq.hashCode());
	System.out.println("Equal To Self:\t\t" + esq.equals(esq));
	System.out.println("Equal To Another:\t" +esq.equals(dd));
	System.out.println(BREAK);

}


}
}
