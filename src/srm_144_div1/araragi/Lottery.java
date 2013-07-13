package srm_144_div1.araragi;

import java.util.Arrays;

/**
 * Class: Lottery
 * Method: sortByOdds
 * Parameters: String[]
 * Returns: String[]
 * Method signature: String[] sortByOdds(String[] rules)
 * (be sure your method is public)
 */

public class Lottery {

    class Game {
	private String m_name;
	private double m_nbValidTicket;
	double[][] matrix = new double[100][8];

	public double rec(int root, int depth) {
	    double sum = 0;
	    if (depth == 1)
		return (double) root;

	    if (matrix[root - 1][depth - 1] != -1)
		return matrix[root - 1][depth - 1];

	    for (int i = 1; i <= root; i++) {
		sum += rec(i, depth - 1);
	    }

	    matrix[root - 1][depth - 1] = sum;
	    return sum;
	}

	public double fact(int n) {
	    return n == 1 || n == 0 ? 1 : n * fact(n - 1);
	}

	public double perm(int n, int r) {
	    return fact(n) / fact(n - r);
	}

	public double comb(int n, int r) {
	    return fact(n) / fact(r) / fact(n - r);
	}

	Game(String name, int choices, int blanks, boolean sorted, boolean unique) {

	    for (int row = 0; row < 100; row++) {
		for (int col = 0; col < 8; col++) {
		    matrix[row][col] = -1;
		}
	    }
	    m_name = name;
	    if (!sorted && !unique) {
		m_nbValidTicket = (double) Math.pow(choices, blanks);
	    } else if (sorted && !unique) {
		m_nbValidTicket = rec(choices, blanks);
	    } else if (!sorted && unique) {
		m_nbValidTicket = perm(choices, blanks);
	    } else if (sorted && unique) {
		m_nbValidTicket = comb(choices, blanks);
	    }
	}

	public double getNbValidTicket() {
	    return m_nbValidTicket;
	}

	public String getName() {
	    return m_name;
	}
    }

    public String[] sortByOdds(String[] rules) {
	Game[] gameList = new Game[rules.length];

	for (int i = 0; i < rules.length; i++) {
	    String[] pair = rules[i].split(": ");
	    String nm = pair[0];
	    String[] opts = pair[1].split(" ");
	    gameList[i] = new Game(nm, Integer.parseInt(opts[0]), Integer.parseInt(opts[1]), opts[2].equals("T") ? true : false, opts[3].equals("T") ? true : false);
	    // System.out.println(gameList[i].getName() + " <==> " +
	    // gameList[i].getNbValidTicket());
	}

	for (int i = 0; i < gameList.length; i++) {
	    for (int j = 0; j < gameList.length - i - 1; j++) {
		if (gameList[j].getNbValidTicket() > gameList[j + 1].getNbValidTicket()) {
		    Game temp = gameList[j + 1];
		    gameList[j + 1] = gameList[j];
		    gameList[j] = temp;
		}
		if (gameList[j].getNbValidTicket() == gameList[j + 1].getNbValidTicket()) {
		    if (gameList[j].getName().compareTo(gameList[j + 1].getName()) > 0) {
			Game temp = gameList[j + 1];
			gameList[j + 1] = gameList[j];
			gameList[j] = temp;
		    }
		}
	    }
	}

	String[] res = new String[gameList.length];
	for (int i = 0; i < gameList.length; i++) {
	    res[i] = gameList[i].getName();
	}

	return res;
    }

    public static void main(String[] args) {
	String[] rules = new String[] {
		"PICK ANY TWO: 10 2 F F",
		"PICK TWO IN ORDER: 10 2 T F",
		"PICK TWO DIFFERENT: 10 2 F T",
		"PICK TWO LIMITED: 10 2 T T" };
	// String[] rules = new String[] {
	// "INDIGO: 93 8 T F",
	// "ORANGE: 29 8 F T",
	// "VIOLET: 76 6 F F",
	// "BLUE: 100 8 T T",
	// "RED: 99 8 T T",
	// "GREEN: 78 6 F T",
	// "YELLOW: 75 6 F F" };

	System.out.println(Arrays.toString(new Lottery().sortByOdds(rules)));
    }
}
