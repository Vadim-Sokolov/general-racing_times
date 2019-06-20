package foxminded.laptimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinalResultBuilder {

	private int index = 1;
	private int maxPilotNameLength;
	private int maxCarNameLength;

	public List<String> getFinalResult(List<Pilot> pilots) {
		List<String> result = new ArrayList<>();
		maxPilotNameLength = getMaxPilotNameLength(pilots);
		maxCarNameLength = getMaxCarNameLength(pilots);
		pilots.stream().forEach(p -> result.add(buildLine(p.getPilotName(), p.getCarName(), p.getLapTime())));
		if (result.size() > 15) {
			result.add(15, getUnderline());
		}
		return result;
	}

	private String buildLine(String pilotName, String carName, String lapTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(index++).append(". ");
		if (index <= 10) {
			sb.append(" ");
		}
		sb.append(pilotName).append(getEmptySpacesForPilotName(pilotName.length())).append("| ").append(carName)
				.append(getEmptySpacesForCarName(carName.length())).append("| ").append(lapTime);
		return sb.toString();
	}

	private int getMaxPilotNameLength(List<Pilot> pilots) {
		List<String> pilotNames = pilots.stream().map(Pilot::getPilotName).collect(Collectors.toList());
		return pilotNames.stream().mapToInt(String::length).max().getAsInt() + 1;
	}

	private int getMaxCarNameLength(List<Pilot> pilots) {
		List<String> carNames = pilots.stream().map(Pilot::getCarName).collect(Collectors.toList());
		return carNames.stream().mapToInt(String::length).max().getAsInt() + 1;
	}

	private String getEmptySpacesForPilotName(int nameLength) {
		int numberOfSpaces = maxPilotNameLength - nameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfSpaces; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private String getEmptySpacesForCarName(int nameLength) {
		int numberOfSpaces = maxCarNameLength - nameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfSpaces; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private String getUnderline() {
		int numberOfTicks = 16 + maxPilotNameLength + maxCarNameLength;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfTicks; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
