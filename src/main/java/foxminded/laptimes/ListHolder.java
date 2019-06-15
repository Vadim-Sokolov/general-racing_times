package foxminded.laptimes;

import java.util.List;

public class ListHolder {

	private static MyFileReader reader = new MyFileReader();
	private static String startPath = "c:/workspace/start.log";
	private static String endPath = "c:/workspace/end.log";
	private static String namesPath = "c:/workspace/abbreviations.txt";
	
	public static List<String> START;
	public static List<String> END;
	public static List<String> NAMES;
	
	static {
		START = reader.readFile(startPath);
		END = reader.readFile(endPath);
		NAMES = reader.readFile(namesPath);
	}
}
