package design_pattern.adapter_7.iterenum;

import java.util.*;

public class EnumerationIteratorTestDrive {
	public static void main (String args[]) {
		Vector v = new Vector(Arrays.asList(1,5,2,6,3,67));
		Iterator iterator = new EnumerationIterator(v.elements());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
