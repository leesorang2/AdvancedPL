package assignment01;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		ServiceProvider.registClass("kim", "B", "printer.PrinterB");
		ServiceProvider.registClass("kim", "C", "printer.PrinterC");
		ServiceProvider.registClass("kim", "A", "assignment01.PrinterA");

		Object o = ServiceProvider.loadClass("kim", "B");
		((IPrintable) o).printName();
		
		System.gc();
		
		o = ServiceProvider.loadClass("kim", "C");
		((IPrintable) o).printName();
		
		System.gc();
		
		o = ServiceProvider.loadClass("kim", "A");
		((IPrintable) o).printName();
	}
}
