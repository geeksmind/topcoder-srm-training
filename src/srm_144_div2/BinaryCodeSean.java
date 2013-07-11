package srm_144_div2;

public class BinaryCodeSean {

	/**
	 * @param args
	 */
	public String[] decode(String message) {
		int[] msg,dec0,dec1;
		msg = new int[message.length()];
		dec0 = new int[message.length()];
		dec1 = new int[message.length()];
		String[] res = {"",""};
		int i = 0;
		for (char c : message.toCharArray()){
			msg[i] = c-48;
			i++;
		}
		dec0[0] = 0;
		dec0[1] = msg[0] - dec0[0];
		dec1[0] = 1;
		dec1[1] = msg[0] - dec1[0];
		for (i=2;i<message.length();i++){
			dec0[i] = msg[i-1]-dec0[i-1]-dec0[i-2];
			dec1[i] = msg[i-1]-dec1[i-1]-dec1[i-2];
			}
		i--;
		
		if (msg[i] == dec0[i]+dec0[i-1]) for (int st:dec0) res[0] += st;
		else res[0] = "NONE";
		if (msg[i] == dec1[i]+dec1[i-1]) for (int st:dec1) res[1] += st;
		else res[1] = "NONE";
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryCodeSean test = new BinaryCodeSean();
		String[] printtest = test.decode("123210122");
		System.out.println(printtest[0]+","+printtest[1]);
	}

}
