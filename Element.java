/**
 * NAME: TENZIN NGAWANG
 * PROJECT: CSCI-313 PROJECT 1, FALL 2016
 * DATE: 20TH OCTOBER 2016
 * PROFESSOR: DR. SVITAK 
 * DESCRIPTION: THIS PROJECT READ A VECTOR FROM TEXT FILE AND INSERT IN TO DOUBLYLINKEDLIST AND DO OPERATION AS INSTRUCTED.
 */
public class Element implements Comparable<Element>{
	private int index;
	private double value;
	
	public Element()
	{
		//Default constructor
	}
	
	public int getIndex(){ return index; }
	public void setIndex(int newIndex){ index = newIndex; }
	public double getValue(){ return value; }
	public void setValue(double newValue){ value = newValue; }
	
	public String toString(){
		System.out.print("["+this.getIndex()+","+this.getValue()+"]");
		String end =")";
		return end;
	}

	public int compareTo(Element n) {
		if(this.getIndex()>n.getIndex())
			return 1;
		if(this.getIndex()<n.getIndex())
			return (-1);
		else
			return 0;
	}
	

}
