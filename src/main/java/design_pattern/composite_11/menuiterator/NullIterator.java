package design_pattern.composite_11.menuiterator;
 
import java.util.Iterator;
  
public class NullIterator implements Iterator {

	@Override
	public Object next() {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
