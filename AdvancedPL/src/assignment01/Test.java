package assignment01;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println(System.getProperty("java.class.path"));
		//System.out.println(Class.forName("java.lang.String"));
//		System.out.println(Class.forName("printer.PrinterD").getName());
		ServiceProvider sp = new ServiceProvider();
		sp.registClass("kim", "printer", "printer.PrinterB");
		
		Object o = sp.loadClass("kim", "printer");
		((IPrintable) o).printName();
	}
}
