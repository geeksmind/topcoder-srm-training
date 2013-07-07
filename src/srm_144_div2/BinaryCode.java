package srm_144_div2;

/**
 * Class: BinaryCode
 * Method: decode Parameters: String
 * Returns: String[]
 * Method signature: String[] decode(String message)
 * (be sure your method is public)
 */

public class BinaryCode {

	public String[] decode(String message) {
		int[] encrypted = new int[message.length()];
		int[] original = new int[message.length()];
		
		for (int i = 0; i < message.length(); i++) {
			encrypted[i] = Character.getNumericValue(message.charAt(i));
		}
		
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryCode bc = new BinaryCode();
		String q = "123210122";
		System.out.println(bc.decode(q));
	}
}