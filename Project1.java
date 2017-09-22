/**
 * NAME: TENZIN NGAWANG
 * PROJECT: CSCI-313 PROJECT 1, FALL 2016
 * DATE: 20TH OCTOBER 2016
 * PROFESSOR: DR. SVITAK 
 * DESCRIPTION: THIS PROJECT READ A VECTOR FROM TEXT FILE AND INSERT IN TO DOUBLYLINKEDLIST AND DO OPERATION AS INSTRUCTED.
 */
import java.util.Scanner;
import java.io.*;

public class Project1 
{
	public static void main(String arg[]) throws IOException
	{
		FileInputStream inF = new FileInputStream("project1.txt");
		Scanner read = new Scanner(inF);
		SparseVector A = new SparseVector();
		SparseVector B = new SparseVector();
		
		int lineNum= 1;
	while(read.hasNextLine())
	{
		if(lineNum ==1)  //first Line to A
		{
			String line = read.nextLine();
			String []StrArray = line.split(" ");
			int i=0;
			insertSV(i,StrArray,A);
			lineNum++;
		}
		else if(lineNum==2)  //Second line to B
		{
			String line = read.nextLine();
			String []StrArray = line.split(" ");
			int i=0;
			insertSV(i,StrArray,B);
			lineNum++;
		}
		else // operation instruction 
		{
			String line = read.nextLine();
			opcode(line,A,B);
		}
	}
	read.close();
	}// end of main
	
	
	
	
	public static void insertSV(int i, String[] s,SparseVector x) //insert into SparseVector
	{
		while(i<s.length)
		{ 
			int index = Integer.parseInt(s[i]);
			double value = Double.parseDouble(s[i+1]);
			x.insert(index, value);
			i=i+2;
		}
	}
	
	public static void opcode(String s, SparseVector x, SparseVector y) //do operation as mention
	{
		if(s.equals("ADD")||s.equals("add"))
		{
			x.add(y);
		}
		else if(s.equals("SUBTRACT")||s.equals("subtract"))
		{
			  x.subtract(y);
		}
		else if(s.equals("DOT")||s.equals("dot"))
		{
				x.dot(y);
		}
		else
			 System.out.println("! ERROR: THIS PROGRAM ONLY DO ADD, SUBTRACT AND MULTIPLE OPERATION");
			// System.out.println(read.nextLine());
		
	}
	
} // of class
