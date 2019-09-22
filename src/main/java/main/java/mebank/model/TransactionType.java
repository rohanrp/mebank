package main.java.mebank.model;

public enum TransactionType {
	PAYMENT("PAYMENT"),
	REVERSAL("REVERSAL");
	
	private final String type;

	TransactionType(final String type) {
        this.type = type;
    }

	public String getType() {
		return type;
	}
}
