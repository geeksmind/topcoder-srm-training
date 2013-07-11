package srm_144_div1.araragi;

/**
 * Class: Lottery
 * Method: sortByOdds
 * Parameters: String[]
 * Returns: String[]
 * Method signature: String[] sortByOdds(String[] rules)
 * (be sure your method is public)
 */

public class Lottery {

    public String[] sortByOdds(String[] rules) {
	return null;
    }

    public static void main(String[] args) {
	String[] rules = new String[] {
		"PICK ANY TWO: 10 2 F F",
		"PICK TWO IN ORDER: 10 2 T F",
		"PICK TWO DIFFERENT: 10 2 F T",
		"PICK TWO LIMITED: 10 2 T T" };

	System.out.println(new Lottery().sortByOdds(rules));
    }
}
