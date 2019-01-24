import java.util.AbstractCollection;
import java.util.Iterator;

//need to implement all  the methods in the interface
public class Concrete extends AbstractCollection<Integer> implements SimpleInterface{


	@Override
	public int add(int a, int b) 
	{
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
