package rest.bank.domain;

public enum SubscriptionType {
	EMAIL("mailChannel"),
	SMS("smsChannel");
	
	private String name;

	private SubscriptionType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
