package design_pattern.adapter_7.iterenum;

import java.util.*;

public class EI {
	public static void main (String args[]) {
		Vector v = new Vector(Arrays.asList(2,4,6,7,8,9,0));
		Enumeration enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		Iterator iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
