/**
 * NAME: TENZIN NGAWANG
 * PROJECT: CSCI-313 PROJECT 1, FALL 2016
 * DATE: 20TH OCTOBER 2016
 * PROFESSOR: DR. SVITAK 
 * DESCRIPTION: THIS PROJECT READ A VECTOR FROM TEXT FILE AND INSERT IN TO DOUBLYLINKEDLIST AND DO OPERATION AS INSTRUCTED.
 */
public class SparseVector 
{
	public SparseVector()
	{
		//Default Constructor
	}
	
	DoublyLinkedList<Element> S_List	= new DoublyLinkedList<>();
	
	public  void insert(int index, double newValue)
	{
//		if(S_List.isEmpty()) //if List is empty it will creates a element
//		{
			
			Element n = new Element();
			n.setValue(newValue);
			n.setIndex(index);
			S_List.add(n);
			
//		}
//		else //other wise check for same index 
//		{
//			for(int i=0;i<S_List.size();i++) //go through each index in List
//			{
//				System.out.print(S_List.get(i).getValue());
//				int Idx = S_List.get(i).getIndex();
//				if(Idx == index) //if index exist then add the value 
//				{
////					Element rest = new Element();
////					rest.setValue(S_List.get(Idx).getValue()+newValue);
////					S_List.set(Idx, rest);
//					S_List.set(Idx, S_List.get(Idx).getValue()+newValue);
//				}
//				else  //if index not exist then creates new element
//				{
//					System.out.print("here");
//					Element n = new Element();
//					n.setValue(newValue);
//					S_List.add(n);
//					
//				}
//			}
//
//		}
	}
	public int svSize()
	{
		return S_List.size();
	}
	public int getIndex(int i)
	{
		return S_List.get(i).getIndex();
	}
	public double getValue(int i)
	{
		return S_List.get(i).getValue();
	}
	private void display()
	{
		System.out.print("(");
		
		for(int i=0;i<this.S_List.size();i++)
			this.S_List.get(i).toString();
			
		System.out.print(")");
		System.out.println();
	}
	
	private void addElement(Element E)
	{
		S_List.add(E);
	}
	
	private Element getElement(int i)
	{
		return S_List.get(i);
	}
	private void removeElement(int index)
	{
		S_List.remove(index);
	}
	private void addElement(int index, Element e)
	{
		S_List.add(index, e);
	}

	public SparseVector add(SparseVector sv)
	{
		SparseVector result = new SparseVector();
	
		/////Larger Sparse Vector will be added straight in D-List
		int till=0;
		if(this.svSize()<sv.svSize())
		{
		 till=sv.svSize(); //if THIS sparse vector has more element
			for(int i=0;i<till;i++)
				result.addElement(sv.getElement(i));
		}
		else if(this.svSize()>sv.svSize()) // Else other vector 
		{
			till=this.svSize();
			for(int i=0;i<till;i++)
				result.addElement(this.getElement(i));
		}
		else  // if same has same length of element choose THIS
		{
			till=this.svSize();
			for(int i=0;i<till;i++)
				result.addElement(this.getElement(i));
		}
		
		//import whichever is not imported
		if(this.svSize()==result.svSize())  //if larger element is this=A (A.add(B))
		{
			//this.display();
			int x=0;
			while(x!=sv.svSize())  //end when comparison finished
			{
				int inserted=0;
				for(int i=0;i<result.svSize();i++)
				{
					int Idx = sv.getElement(x).compareTo(result.getElement(i));
					if(Idx ==0)
					{
						double addValue =(result.getElement(i).getValue()) + (sv.getElement(x).getValue()) ;
						result.getElement(i).setValue( addValue );
						inserted =1;   //signal variable, used for inserted or not
					}
				}
				if(inserted ==0)  //if not insert element will be added
				{
					result.addElement(sv.getElement(x));
				}
				x++;  //increment compare element
			}
			
		}
		else
		{
			int x=0;
			while(x!=this.svSize())
			{
				int inserted=0;
				for(int i=0;i<result.svSize();i++)
				{
					int Idx = this.getElement(x).compareTo(result.getElement(i));
					if(Idx ==0)
					{
						result.getElement(i).setValue((result.getElement(i).getValue())+(this.getElement(x).getValue()));
						inserted =1;
					}
				}
				if(inserted ==0)
				{
					//sv.getElement(x).setValue(0-sv.getElement(x).getValue()); //put - before value
					result.addElement(this.getElement(x));
				}
				x++;
			}
		}	
		
		this.display();
		System.out.println("+");
		sv.display();
		System.out.println("=");
		order(result).display();
		System.out.println("");
		
		return result;
	} //End of add(Sv)
	
	public SparseVector subtract(SparseVector sv)
	{
		SparseVector result = new SparseVector();
		
			for(int i=0;i<this.svSize();i++)
				result.addElement(this.getElement(i));
			
			int x=0;
			while(x!=sv.svSize())
			{
				int inserted=0;
				for(int i=0;i<result.svSize();i++)
				{
					int Idx = sv.getElement(x).compareTo(result.getElement(i));
					if(Idx ==0)
					{
						result.getElement(i).setValue(result.getElement(i).getValue()-sv.getElement(x).getValue());
						inserted =1;
					}
				
				}
				if(inserted ==0)
				{
					sv.getElement(x).setValue(0-sv.getElement(x).getValue()); //put - before value
					result.addElement(sv.getElement(x));
				}
				x++;
			}
			this.display();
			System.out.println("-");
			sv.display();
			System.out.println("=");
			order(result).display();
			System.out.println("");
		
		return result;
	} //end of Subtract

	public SparseVector dot(SparseVector sv)
	{
		SparseVector result = new SparseVector();
		//***************************
//		int x=0;
//		while(x!=sv.svSize())  //end when comparison finished
//		{
//
//			for(int i=0;i<this.svSize();i++)
//			{
//				int Idx = sv.getElement(x).compareTo(this.getElement(i));
//				if(Idx ==0)
//				{
//					result.getElement(i).setValue(result.getElement(i).getValue()+sv.getElement(x).getValue());
//					//System.out.print("here ");
//				}
//			
//			}
//			x++;  //increment compare element
//		}
		//******************************
		
		int till=0;
		if(this.svSize()<sv.svSize())
		{
		 till=sv.svSize(); //if THIS sparse vector has more element
//			for(int i=0;i<till;i++)
//				result.addElement(sv.getElement(i));
		}
		else if(this.svSize()>sv.svSize()) // Else other vector 
		{
			till=this.svSize();
//			for(int i=0;i<till;i++)
//				result.addElement(this.getElement(i));
		}
		else  // if same has same length of element choose THIS
		{
			till=this.svSize();
		}
		//import whichever is not imported
		if(this.svSize()==till)  //if larger element is this=A (A.add(B))
		{
			int x=0;
			while(x!=sv.svSize())  //end when comparison finished
			{
				for(int i=0;i<this.svSize();i++)
				{
					int Idx = sv.getElement(x).compareTo(this.getElement(i));
					if(Idx ==0)
					{
						this.getElement(i).setValue(this.getElement(i).getValue()+sv.getElement(x).getValue());
						result.addElement(this.getElement(i));
					}
				}
				x++;  //increment compare element
			}	
		}
		else
		{
			int x=0;
			while(x!=this.svSize())
			{
				int inserted=0;
				for(int i=0;i<result.svSize();i++)
				{
					int Idx = this.getElement(x).compareTo(result.getElement(i));
					if(Idx ==0)
					{
						result.getElement(i).setValue(result.getElement(i).getValue()+this.getElement(x).getValue());
						//System.out.print("here ");
						inserted =1;
					}
				}
				if(inserted ==0)
				{
					//sv.getElement(x).setValue(0-sv.getElement(x).getValue()); //put - before value
					result.addElement(this.getElement(x));
				}
				x++;
			}
		}
		
		this.display();
		System.out.println("*");
		sv.display();
		System.out.println("=");
		order(result).display();
		System.out.println("");
		
		return result;
	} //end of dot
	
	private SparseVector order(SparseVector newSV)
	{
		//SparseVector ordered = new SparseVector();
		int size=newSV.svSize();
		Element temp;
		//	temp = newSV.getElement(0);
			
			for(int i=0; i< size;i++)
				for(int j=i+1;j<size;j++)
				{
					int comp=newSV.getElement(i).compareTo(newSV.getElement(j));
					if(comp==1)
					{
						temp = newSV.getElement(j);
						newSV.removeElement(j);
						newSV.addElement(j, newSV.getElement(i));
						newSV.removeElement(i);
						newSV.addElement(i, temp);
					}
				}
			
		return newSV;
	}
	
	
}//End of SparseVector class
