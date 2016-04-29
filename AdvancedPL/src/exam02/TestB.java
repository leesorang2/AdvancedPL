package exam02;


public class TestB extends TestA {
	public void f() {
		System.out.println("B.f");
	}
	
	public void g() {
		super.g();
	}
	
	public static void main(String[] args) throws Exception {
//		Method[] method = (new TestB()).getClass().getSuperclass().getMethods();
//		System.out.println(method[0].getName());
//		method[0].invoke(Class.forName("exam02.TestA").newInstance(), null);
		(new TestB()).getClass().getSuperclass().getMethods()[0].invoke((new TestB()).getClass().getSuperclass().newInstance(), null);
	}
}