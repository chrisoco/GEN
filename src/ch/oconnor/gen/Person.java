package ch.oconnor.gen;

public class Person {


	private final int id;
	private final char pref1, pref2, pref3;
	private final String firstName, lastName;

	private int abteilung1ID, abteilung2ID;


	public Person(int id, String firstName, String lastName, char pref1, char pref2, char pref3) {

		this.id        = id;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.pref1     = pref1;
		this.pref2     = pref2;
		this.pref3     = pref3;

	}

	public int eval(char c) {

		if     (pref1 == c) return 10;
		else if(pref2 == c) return  5;
		else if(pref3 == c) return  3;

		return 0;

	}


}
