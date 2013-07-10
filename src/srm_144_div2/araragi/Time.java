package srm_144_div2.araragi;

/**
 * Class: Time
 * Method: whatTime
 * Parameters: int Returns: String
 * Method signature: String whatTime(int seconds)
 * (be sure your method is public)
 */

public class Time {

    public String whatTime(int seconds) {
	int hour = seconds / 60 / 60;
	int min = (seconds - hour * 60 * 60) / 60;
	int sec = seconds - hour * 60 * 60 - min * 60;
	return hour + ":" + min + ":" + sec;
    }

    public static void main(String[] args) {
	Time t = new Time();
	System.out.println(t.whatTime(3661));
	System.out.println("hello world");
    }

}
