package foxminded.laptimes;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NameHandler {
	
	public List<Pilot> setPilotNamesAndCarNames(List<Pilot> pilots, List<String> names) {
		String abbreviation = null;
		String pilotName = null;
		String carName = null;
		for (String s : names) {
			abbreviation = s.substring(0, 3);
			pilotName = s.substring(s.indexOf("_") + 1);
			pilotName = pilotName.substring(0, pilotName.indexOf("_"));
			carName = s.substring(s.indexOf("_") + 1);
			carName = carName.substring(carName.indexOf("_") + 1);
			Pilot pilot = getPilotByAbbreviation(pilots, abbreviation);
			pilot.setPilotName(pilotName);
			pilot.setCarName(carName);
		}
		return pilots;
	}

	private Pilot getPilotByAbbreviation(List<Pilot> pilots, String abbreviation) {
		return pilots.stream().filter(p -> p.getAbbreviation().equals(abbreviation)).findFirst().get();
	}
}
