package foxminded.laptimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MyStringBuilder {

	private int index = 1;
	private int maxPilotNameLength;
	private int maxCarNameLength;
	private String lapTime = null;
	private String pilotName = null;
	private String carName = null;

	public List<String> getFinalResult(Map<String, String> lapTimes, Map<String, String> pilotNames,
			Map<String, String> carNames) {
		List<String> result = new ArrayList<>();
		maxPilotNameLength = getMaxPilotNameLength(pilotNames);
		maxCarNameLength = getMaxCarNameLength(carNames);
		for (Map.Entry<String, String> e : lapTimes.entrySet()) {
			lapTime = e.getKey();
			pilotName = pilotNames.get(e.getValue());
			carName = carNames.get(e.getValue());
			if (index == 16) {
				result.add(getUnderline());
			}
			result.add(buildLine(pilotName, carName, lapTime));
		}
		return result;
	}

	public String buildLine(String pilotName, String carName, String lapTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(index++).append(". ");
		if (index <= 10) {
			sb.append(" ");
		}
		sb.append(pilotName).append(getEmptySpacesForPilotName(pilotName.length()))
				.append("| ").append(carName).append(getEmptySpacesForCarName(carName.length())).append("| ")
				.append(lapTime);
		return sb.toString();
	}

	public int getMaxPilotNameLength(Map<String, String> pilotNames) {
		return pilotNames.values().stream().mapToInt(String::length).max().getAsInt() + 1;
	}

	public int getMaxCarNameLength(Map<String, String> carNames) {
		return carNames.values().stream().mapToInt(String::length).max().getAsInt() + 1;
	}

	public String getEmptySpacesForPilotName(int nameLength) {
		int numberOfSpaces = maxPilotNameLength - nameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfSpaces; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public String getEmptySpacesForCarName(int nameLength) {
		int numberOfSpaces = maxCarNameLength - nameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfSpaces; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public String getUnderline() {
		int numberOfTicks = 16 + maxPilotNameLength + maxCarNameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfTicks; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
