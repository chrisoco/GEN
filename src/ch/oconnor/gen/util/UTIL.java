package ch.oconnor.gen.util;

import ch.oconnor.gen.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UTIL {


	public static final Map<Character, String> GEN_ABTEILUNGEN(){

		HashMap<Character, String> abteilungMap = new HashMap<>();


		abteilungMap.put('E', "Einkauf"     );
		abteilungMap.put('B', "Buchhaltung" );
		abteilungMap.put('S', "Sek. / Pers.");
		abteilungMap.put('M', "Marketing"   );
		abteilungMap.put('V', "Verkauf"     );


		return abteilungMap;
	}

	public static final List<Person> GEN_PERSONEN(){

		List<Person> personList = new ArrayList<>();


		personList.add(new Person(1 , "Denton"   , "Carrillo" , 'E', 'M', 'S'));
		personList.add(new Person(2 , "Dara"     , "Humphrey" , 'E', 'B', 'V'));
		personList.add(new Person(3 , "Jared"    , "Raymond"  , 'M', 'B', 'S'));
		personList.add(new Person(4 , "Berk"     , "Coleman"  , 'B', 'S', 'M'));
		personList.add(new Person(5 , "Hu"       , "Donaldson", 'B', 'V', 'M'));
		personList.add(new Person(6 , "Christian", "Hobbs"    , 'S', 'V', 'M'));
		personList.add(new Person(7 , "Luke"     , "Case"     , 'V', 'S', 'E'));
		personList.add(new Person(8 , "Slade"    , "Clay"     , 'V', 'E', 'S'));
		personList.add(new Person(9 , "Rhiannon" , "Burks"    , 'E', 'S', 'B'));
		personList.add(new Person(10, "Ciaran"   , "Nichols"  , 'S', 'M', 'B'));

		personList.add(new Person(11, "Denton"   , "Carrillo" , 'E', 'M', 'S'));
		personList.add(new Person(12, "Dara"     , "Humphrey" , 'E', 'B', 'V'));
		personList.add(new Person(13, "Jared"    , "Raymond"  , 'M', 'B', 'S'));
		personList.add(new Person(14, "Berk"     , "Coleman"  , 'B', 'S', 'M'));
		personList.add(new Person(15, "Hu"       , "Donaldson", 'B', 'V', 'M'));
		personList.add(new Person(16, "Christian", "Hobbs"    , 'S', 'V', 'M'));
		personList.add(new Person(17, "Luke"     , "Case"     , 'V', 'S', 'E'));
		personList.add(new Person(18, "Slade"    , "Clay"     , 'V', 'E', 'S'));
		personList.add(new Person(19, "Rhiannon" , "Burks"    , 'E', 'S', 'B'));
		personList.add(new Person(20, "Ciaran"   , "Nichols"  , 'S', 'M', 'B'));


		return personList;

	}

	public static final void GEN_POPULATION() {}









}
