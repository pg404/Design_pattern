package design_pattern.adapter_7.iterenum;

import java.util.*;

public class EnumerationIterator implements Iterator {
	Enumeration enumeration;
 
	public EnumerationIterator(Enumeration enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
