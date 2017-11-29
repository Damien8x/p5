package p5;
import java.util.*;

public class P5{

public static void main(String[] args) {

Sequence sqe = new SequenceEnum("test SequenceEnum");
Sequence sqe1 = new SequenceEnum("test SequenceEnum2");
Sequence sqe2 = new SequenceEnum("test SequenceEnum_3");
Sequence sp = new SpasEnum("test SpasEnum");
Sequence sx = new SeqExtract("test SeqExtract");
Sequence iv= new Inverter("test Inverter");




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
	System.out.println(esq.getVariant());
}


System.out.println(sqe.toString());

System.out.println(sqe.equals(sqe));

System.out.println(sqe.hashCode());

}

}
