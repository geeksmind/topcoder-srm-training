package srm_144_div2.araragi;

/**
 * Class: PowerOutage
 * Method: estimateTimeOut
 * Parameters: int[], int[], int[]
 * Returns: int Method signature: int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength)
 * (be sure your method is public)
 */

public class PowerOutage {

    public int longestPath(int root, int[] fromJunction, int[] toJunction, int[] ductLength) {
	int longest = 0;
	boolean isLeave = true;
	for (int i = 0; i < fromJunction.length; i++) {
	    if (root == fromJunction[i]) {
		isLeave = false;
		int len = ductLength[i] + longestPath(toJunction[i], fromJunction, toJunction, ductLength);
		if (longest < len) {
		    longest = len;
		}
	    }
	}
	return isLeave ? 0 : longest;
    }

    public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
	int sum = 0;
	for (int i : ductLength) {
	    sum += i;
	}
	return 2 * sum - longestPath(fromJunction[0], fromJunction, toJunction, ductLength);
    }

    public static void main(String[] args) {
	int[] from = new int[] { 0, 0, 0, 1, 4, 4, 6, 7, 7, 7, 20 };
	int[] to = new int[] { 1, 3, 4, 2, 5, 6, 7, 20, 9, 10, 31 };
	int[] dlen = new int[] { 10, 10, 100, 10, 5, 1, 1, 100, 1, 1, 5 };

	System.out.println(new PowerOutage().estimateTimeOut(from, to, dlen));
    }

}
