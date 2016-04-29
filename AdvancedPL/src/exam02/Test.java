package exam02;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(1);
//		A b = (A) a.clone();
		System.out.println(a.getI());
//		System.out.println(b.getI());
		System.out.println();
		System.out.println(a.getClass().getName());
//		System.out.println(b.getClass().getName());
	}
}
