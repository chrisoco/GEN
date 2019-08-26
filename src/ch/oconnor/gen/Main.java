package ch.oconnor.gen;

import ch.oconnor.gen.util.UTIL;

import java.util.*;

public class Main {


	private static final List<Person> PERSON_LIST = UTIL.GEN_PERSONEN();

	private static final int     ANZ_GENE         = 40_000;     // 40_000

	private static final int     ANZ_GENERATIONS  =     10;     // 10

	private static final double  KEEP_TOP         =      0.20;  // 0.2

	private static final double  NO_MUTATUION     =      0.10;  // 0.1

	private static final double  MUTATION_RATE    =      0.01;  // 0.01

	private static final boolean DEBUGG_ON        =   true;

	private List<BitWorm> genList = new ArrayList<>();



	public static void main(String[] args) {

		new Main().top();

	}

	private void top() {

		initGenList();

		for (int i = 1; i <= ANZ_GENERATIONS; i++) {

			crossOvers();
			mutation();
			removeNotMinMax();
			sortAndRemoveDuplicates();
			removeWorst();


			if(DEBUGG_ON) {

				System.out.println("\n\nGENERATION: # " + i);
				printTopFive();

			}
		}


		if(!DEBUGG_ON) {
			System.out.println("\nGENERATION: # " + ANZ_GENERATIONS);
			printTopFive();
		}


	}

	private void initGenList() {

		int size = PERSON_LIST.size();

		for(int i = 0; i < ANZ_GENE; i++)
			genList.add(new BitWorm(size));


		removeNotMinMax();
		sortAndRemoveDuplicates();
		removeWorst();

		if(DEBUGG_ON) {
			System.out.println("\nINITIAL GEN LIST :/>");
			printTopFive();
		}

	}

	private void sortAndRemoveDuplicates() {

		sort();

		int i = 0;

		while(i < genList.size() - 1) {

			String gen1 = genList.get(i    ).getWormString();
			String gen2 = genList.get(i + 1).getWormString();

			if(gen1.equals(gen2)) genList.remove(i + 1);
			else i++;

		}

		if(DEBUGG_ON) System.out.println("AFTER SORT+R = " + genList.size());

	}

	private void sort() {

		Collections.sort(genList, new Comparator<BitWorm>() {
			@Override
			public int compare(BitWorm o1, BitWorm o2) {
				return o2.eval(PERSON_LIST) - o1.eval(PERSON_LIST);
			}
		}.thenComparing(new Comparator<BitWorm>() {
			@Override
			public int compare(BitWorm o1, BitWorm o2) {
				return o1.getWormString().compareTo(o2.getWormString());
			}
		}));

	}

	private void removeNotMinMax() {

		int i = 0;

		while(i < genList.size()) {

			if   (genList.get(i).evalMinMax()) i++;
			else  genList.remove(i);

		}

		if(DEBUGG_ON) System.out.println("MIN MAX SIZE = " + genList.size());

	}

	private void removeWorst() {

		while(genList.size() > ANZ_GENE * KEEP_TOP)
			genList.remove(genList.size() - 1);


		if(DEBUGG_ON) System.out.println("REMLAST SIZE = " + genList.size());

	}

	private void crossOvers() {

		int numCrossOvers = (ANZ_GENE - genList.size());

		int j = 0;

		for (int i = 1; j + 1 < numCrossOvers; i++) {

			while(j < i) {

				genList.add(crossOver(genList.get(j).getWorm(), genList.get(i).getWorm()));

				j++;
			}

		}

		if(DEBUGG_ON) System.out.println("CROSSOVER    = " + genList.size());

	}

	private BitWorm crossOver(char [] b1, char [] b2) {

		int size = PERSON_LIST.size() * 2;

		char [] child = new char[size];

		for (int i = 0; i < size; i += 2) {

			if(Math.random() < 0.5) {

				child[i    ] = b1[i    ];
				child[i + 1] = b1[i + 1];

			} else {

				child[i    ] = b2[i    ];
				child[i + 1] = b2[i + 1];

			}

		}

		return new BitWorm(child);

	}

	private void mutation() {

		for (int i = (int) (genList.size() * NO_MUTATUION); i < genList.size(); i++)

			genList.get(i).mutate(MUTATION_RATE);

	}


	private void printList() {

		System.out.println("\n\n =========== \n");

		for (BitWorm bw : genList)
			System.out.println(bw.getWormString() + " = " + bw.eval(PERSON_LIST));

	}

	private void printTopFive() {

		for (int i = 0; i < 5; i++)
			System.out.println(genList.get(i).getWormString2() + " = " + genList.get(i).eval(PERSON_LIST));


	}


}
