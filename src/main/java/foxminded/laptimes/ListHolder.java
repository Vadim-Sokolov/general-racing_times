package foxminded.laptimes;

import java.io.IOException;
import java.util.List;

public class ListHolder {

	private static MyFileReader reader = new MyFileReader();
	private static String startPath = "/start.log";
	private static String endPath = "/end.log";
	private static String namesPath = "/abbreviations.txt";

	public static List<String> START;
	public static List<String> END;
	public static List<String> NAMES;

	static {
		try {
			START = reader.readFile(startPath);
			END = reader.readFile(endPath);
			NAMES = reader.readFile(namesPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
