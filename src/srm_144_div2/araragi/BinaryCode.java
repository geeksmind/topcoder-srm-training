package srm_144_div2.araragi;

import java.util.Arrays;

/**
 * Class: BinaryCode
 * Method: decode
 * Parameters: String
 * Returns: String[] Method
 * signature: String[] decode(String message) (be sure your method is public)
 */

public class BinaryCode {

    public String recover(int[] q, int assume) {
	int len = q.length;
	int[] p = new int[len];
	p[0] = assume;

	// test first and last digit of encrypted code
	if (q[0] != 0 && q[0] != 1 && q[0] != 2)
	    return "NONE";

	if (q[len - 1] != 0 && q[len - 1] != 1 && q[q.length - 1] != 2)
	    return "NONE";

	for (int i = 1; i < len; i++) {

	    // test first and last digit of original code
	    if (i == 1)
		p[i] = q[i - 1] - p[i - 1];
	    else if (i == len - 1)
		p[i] = q[i] - p[i - 1];
	    else
		p[i] = q[i - 1] - p[i - 1] - p[i - 2];
	  

	    if (p[i] != 1 && p[i] != 0) {
		return "NONE";
	    }
	}
	return Arrays.toString(p).replaceAll("(\\[|\\]|,| )", ""); 
    }

    public String[] decode(String message) {
	int[] encrypted = new int[message.length()];
	for (int i = 0; i < message.length(); i++) {
	    encrypted[i] = Character.getNumericValue(message.charAt(i));
	}
	return new String[] { recover(encrypted, 0), recover(encrypted, 1) };
    }

    public static void main(String[] args) {
	BinaryCode bc = new BinaryCode();
	String q = "123210120";
	System.out.println(Arrays.toString(bc.decode(q)));
    }
}