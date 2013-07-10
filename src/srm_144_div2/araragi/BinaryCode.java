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

	for (int i = 0; i < len - 1; i++) {

	    // special case for the first encrypted code digit
	    if (i == 0)
		p[i + 1] = q[i] - p[i];
	    else
		p[i + 1] = q[i] - p[i - 1] - p[i];
	    /*
	     * note that: q[len - 1] (last encrypted code digit) has not been used
	     */

	    if (p[i + 1] != 1 && p[i + 1] != 0) {
		return "NONE";
	    }
	}

	/*
	 * using last encrypted code digit to test the correctness of last
	 * original code digit
	 */
	if (p[len - 1] + p[len - 2] != q[len - 1]) {
	    return "NONE";
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

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	BinaryCode bc = new BinaryCode();
	String q = "123210120";
	System.out.println(Arrays.toString(bc.decode(q)));
    }
}