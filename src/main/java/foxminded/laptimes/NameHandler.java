package foxminded.laptimes;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NameHandler {

	public Map<String, String> getPilotNames(List<String> names) {
		Map<String, String> result = new TreeMap<>();
		String abbreviation = null;
		String pilotName = null;
		for (String s : names) {
			abbreviation = s.substring(0, 3);
			pilotName = s.substring(s.indexOf("_") + 1);
			pilotName = pilotName.substring(0, pilotName.indexOf("_"));
			result.put(abbreviation, pilotName);
		}
		return result;
	}
	
	public Map<String, String> getCarNames(List<String> names) {
		Map<String, String> result = new TreeMap<>();
		String abbreviation = null;
		String carName = null;
		for (String s : names) {
			abbreviation = s.substring(0, 3);
			carName = s.substring(s.indexOf("_") + 1);
			carName = carName.substring(carName.indexOf("_") + 1);
			result.put(abbreviation, carName);
		}
		return result;
	}
}
