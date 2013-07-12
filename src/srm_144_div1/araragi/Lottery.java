package srm_144_div1.araragi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

	public double rec(int root, int depth, double[][] mat) {
	    double sum = 0;
	    if (depth == 1)
		return (double) root;

	    if (mat[root-1][depth-1] != -1)
		return mat[root-1][depth-1];

	    for (int i = 1; i <= root; i++) {
		sum += rec(i, depth - 1, mat);
	    }

	    mat[root-1][depth-1] = sum;
	    return sum;
	}

	public int fact(int n) {
	    return n == 1 || n == 0 ? 1 : n * fact(n - 1);
	}

	public int perm(int n, int r) {
	    return fact(n) / fact(n - r);
	}

	public int comb(int n, int r) {
	    return fact(n) / fact(r) / fact(n - r);
	}

	Game(String name, int choices, int blanks, boolean sorted, boolean unique) {
	    
	    double[][] matrix = new double[100][8];
	    
	    for (int row=0; row < 100; row++) {
		      for (int col=0; col < 8; col++) {
		        matrix[row][col] = -1;
		      }
		    }
	    m_name = name;
	    if (!sorted && !unique) {
		m_nbValidTicket = (int) Math.pow(choices, blanks);
	    } else if (sorted && !unique) {
		m_nbValidTicket = rec(choices, blanks, matrix);
	    } else if (!sorted && unique) {
		m_nbValidTicket = perm(choices, blanks);
	    } else if (sorted && unique) {
		m_nbValidTicket = comb(choices, blanks);
	    }
	}

	public double getNbValidTicket() {
	    return m_nbValidTicket;
	}
    }

    public String[] sortByOdds(String[] rules) {
	Game[] gameList = new Game[rules.length];

	for (int i = 0; i < rules.length; i++) {
	    String[] pair = rules[i].split(": ");
	    String nm = pair[0];
	    String[] opts = pair[1].split(" ");
	    gameList[i] = new Game(nm, Integer.parseInt(opts[0]), Integer.parseInt(opts[1]), opts[2].equals("T") ? true : false, opts[3].equals("T") ? true : false);
	    System.out.println(gameList[i].getNbValidTicket());
	}

	return null;
    }

    public static void main(String[] args) {
	String[] rules = new String[] { "PICK ANY TWO: 10 2 F F", "PICK TWO IN ORDER: 93 8 T F", "PICK TWO DIFFERENT: 10 2 F T", "PICK TWO LIMITED: 10 2 T T" };

	System.out.println(new Lottery().sortByOdds(rules));
//	System.out.println(new Lottery().rec(93, 8));
    }
}
