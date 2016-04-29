package exam02;

class Super {
	public void h(Super s) { System.out.println("super"); }
}

public class Sub extends Super {
	public void h(Sub s) { System.out.println("sub"); }
}
