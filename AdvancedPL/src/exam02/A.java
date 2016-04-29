package exam02;

public class A implements Cloneable {
	private int i;

	public A(int a_i) {
		i = a_i;
	}

	public int getI() {
		return i;
	}
	
	@Override
	public A clone() throws CloneNotSupportedException {
		A clone = (A) super.clone();
		clone.i++;
		return clone;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(1);
		A b = a.clone();
		A c = b.clone();
		
		System.out.println(a.getI());
		System.out.println(b.getI());
		System.out.println(c.getI());
	}
}
