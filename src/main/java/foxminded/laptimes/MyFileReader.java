package foxminded.laptimes;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileReader {

	public List<String> readFile(String path) throws IOException {
		List<String> list = new ArrayList<String>();
		InputStream in = Runner.class.getResourceAsStream(path);
		String s = convertToString(in);
		list = convertToList(s);
		return list;
	}

	private String convertToString(InputStream inputStream) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		return result.toString(StandardCharsets.UTF_8.name());
	}

	private List<String> convertToList(String s) {
		List<String> result = new ArrayList<>();
		String[] temp = s.split("\\r?\\n");
		for (String st : temp) {
			result.add(st);
		}
		return result;
	}
}
