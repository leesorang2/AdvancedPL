package assignment01;

public class PrinterA implements IPrintable {
	public void printName() {
		System.out.println(this.getClass().getSimpleName());
	}
}
