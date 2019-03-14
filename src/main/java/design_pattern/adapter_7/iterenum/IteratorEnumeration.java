package design_pattern.adapter_7.iterenum;

import java.util.*;

public class IteratorEnumeration implements Enumeration {
	Iterator iterator;
 
	public IteratorEnumeration(Iterator iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public Object nextElement() {
		return iterator.next();
	}
}
