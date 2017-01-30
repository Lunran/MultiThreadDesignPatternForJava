package com.sample;

public class Person {

	private final String name;
	private final String address;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ Person: name = ");
		return sb.append(name).append(", address = ").append(address).append(" ]").toString();
	}
}
