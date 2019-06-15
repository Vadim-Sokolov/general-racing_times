package foxminded.laptimes;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileReader {

	public List<String> readFile(String path) {
		ArrayList<String> list = new ArrayList<String>();
		try (Scanner scanner = new Scanner(new FileReader(path))) {
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
