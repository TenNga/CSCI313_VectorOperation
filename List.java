/**
 * NAME: TENZIN NGAWANG
 * PROJECT: CSCI-313 PROJECT 1, FALL 2016
 * DATE: 20TH OCTOBER 2016
 * PROFESSOR: DR. SVITAK 
 * DESCRIPTION: THIS PROJECT READ A VECTOR FROM TEXT FILE AND INSERT IN TO DOUBLYLINKEDLIST AND DO OPERATION AS INSTRUCTED.
 */
import java.util.Iterator;

public interface List<AnyType>
{
  void clear();
  
  int size();

  boolean isEmpty();

  AnyType get(int index);

  AnyType set(int index, AnyType newValue);

  boolean add(AnyType newValue);

  void add(int index, AnyType newValue);

  AnyType remove(int index);

  Iterator<AnyType> iterator();
}
