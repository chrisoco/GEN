package ch.oconnor.gen;


import java.util.List;

public class BitWorm {

	private int  size;
	private char worm [];

	private static final char [] ABTEILUNGEN  = {'E', 'B', 'V', 'M', 'S'};

	private static int MIN_TN;
	private static int MAX_TN;

	public BitWorm(int size) {

		this.size = size * 2;
		this.worm = new char[this.size];

		this.MIN_TN = ((int) size / 5) - 3;
		this.MAX_TN = ((int) size / 5) + 3;

		generateRandom();

	}

	public BitWorm(char [] worm) {

		this.worm = worm;
		this.size = worm.length;

		this.MIN_TN = ((int) size / 2 / 5) - 3;
		this.MAX_TN = ((int) size / 2 / 5) + 3;

		veb();

	}

	public void generateRandom() {

		for(int i = 0; i < this.size; i++) {

			worm [i] = ABTEILUNGEN[(int) (Math.random() * 5)];

		}

		veb();

	}

	private void veb() {


		for (int i = 0; i < this.size; i += 2) {

			/**
			 * Check if Pair are the Same
			 */
			while (worm[i] == worm[i+1]) {

				worm[i + (int) (Math.random() * 2)] = ABTEILUNGEN[(int) (Math.random() * 5)];

			}

			/**
			 *
			 * Check for Valid (Pair has at least 1 E, B or V else
			 * make rndm swap with other letter
			 *
			 */
			if(!(worm[i] == 'E' || worm[i] == 'B' || worm[i] == 'V')) {


				if(worm[i+1] == 'E' || worm[i+1] == 'B' || worm[i+1] == 'V') {


				} else {

					worm[i + (int) (Math.random() * 2)] = ABTEILUNGEN[(int) (Math.random() * 3)];

				}

			}

		}

	}

	public int eval(List<Person> personList) {

		int sum = 0;

		for (int i = 0; i < this.size / 2; i++) {

			int j = i * 2;

			sum += personList.get(i).eval(worm[j    ]);
			sum += personList.get(i).eval(worm[j + 1]);


		}

		return sum;

	}


	public boolean evalMinMax() {

		for (char c : ABTEILUNGEN) {

			int count1 = 0;
			int count2 = 0;

			for (int i = 0; i < worm.length; i += 2) {

				if(worm[i    ] == c) count1++;
				if(worm[i + 1] == c) count2++;

			}

			if(count1 < MIN_TN || count1 > MAX_TN) return false;
			if(count2 < MIN_TN || count2 > MAX_TN) return false;

		}

		return true;

	}

	public void mutate(final double MUTATION_RATE) {

		boolean mutated = false;

		for (int i = 0; i < this.worm.length; i++) {

			if(Math.random() < MUTATION_RATE) {

				this.worm[i] = ABTEILUNGEN[(int) (Math.random() * 5)];
				mutated = true;

			}

		}

		if(mutated) veb();

	}


	public char[] getWorm() {
		return worm;
	}

	public String getWormString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.worm.length; i++) {
			sb.append(worm[i]);
		}

		return sb.toString();
	}

	public String getWormString2() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.worm.length; i++) {
			sb.append(worm[i]);

			if(i % 2 == 1) sb.append(" ");

		}

		return sb.toString();
	}

}

