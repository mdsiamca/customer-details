public class ElectronicDetails implements Process {
	private int tv;
	private int pc;
	private int ac;

	// Variables should be private
	public ElectronicDetails() {
	}

	public ElectronicDetails(int tv, int pc, int ac) {
		this.tv = tv;
		this.pc = pc;
		this.ac = ac;

	}

	public double price() {
		if (tv >= 2) {
			return ((50000 * tv) + (80000 * pc) + (60000 * ac)) * 0.8;
		} else {
			return (50000 * tv) + (80000 * pc) + (60000 * ac);
		}

	}
	/*
	 * Modify this calculation for price for the following condition - If a person
	 * buy two tv's then the customer will
	 * get 20% discount. and the price will be shown after the discount.
	 */

}
