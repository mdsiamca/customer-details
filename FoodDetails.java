public class FoodDetails implements Process {
	// All the variables should be private, also add two more variables for a string
	private int burger;
	private int pizza;
	private int shake;
	private String authorName;
	private String authorAddress;
	private double total;

	// and a double type data
	public FoodDetails() {
	}

	public FoodDetails(int burger, int pizza, int shake, String authorName, String authorAddress) {
		this.burger = burger;
		this.pizza = pizza;
		this.shake = shake;
		this.authorName = authorName;
		this.authorAddress = authorAddress;

	}

	public FoodDetails(int burger, int pizza, int shake) {
		this.burger = burger;
		this.pizza = pizza;
		this.shake = shake;

	}

	public double price() {
		return (200 * burger) + (1350 * pizza) + (150 * shake);
	}

	public String toString() {
		return "Burger: " + burger + " Pizza: " + pizza + " Shake: " + shake + " Total: " + price();
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getAuthorAddress() {
		return authorAddress;
	}

	public double total(int quantity) {
		this.total = quantity * price();
		return total = quantity * price();
	}

	public double getTotal() {
		return total;
	}

}