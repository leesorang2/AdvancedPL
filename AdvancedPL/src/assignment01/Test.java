package assignment01;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		// System.out.println(System.getProperty("java.class.path"));
		// System.out.println(Class.forName("java.lang.String"));
		// System.out.println(Class.forName("printer.PrinterD").getName());
		ServiceProvider.registClass("kim", "printer", "printer.PrinterB");

		Object o = ServiceProvider.loadClass("kim", "printer");
		((IPrintable) o).printName();
		System.gc();
		System.gc();
		o = ServiceProvider.loadClass("kim", "printer");
		((IPrintable) o).printName();
	}

}
