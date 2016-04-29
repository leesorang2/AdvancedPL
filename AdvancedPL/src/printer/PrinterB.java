package printer;

import assignment01.IPrintable;

public class PrinterB implements IPrintable {
	public void printName() {
		System.out.println(this.getClass().getSimpleName());
	}
}
