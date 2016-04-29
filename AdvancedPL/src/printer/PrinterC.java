package printer;

import assignment01.IPrintable;

public class PrinterC implements IPrintable {
	public void printName() {
		System.out.println(this.getClass().getSimpleName());
	}
}
