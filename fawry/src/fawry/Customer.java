package fawry;

class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.setName(name);
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public void minus(double amt) { this.balance -= amt; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}