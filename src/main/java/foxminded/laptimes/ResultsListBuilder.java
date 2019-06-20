package foxminded.laptimes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultsListBuilder {

	LapTimeHandler lapTimeHandler = new LapTimeHandler();
	NameHandler nameHandler = new NameHandler();

	public List<Pilot> buildResultsList(List<String> startLog, List<String> endLog, List<String> names)
			throws ParseException {
		List<Pilot> pilots = new ArrayList<>();
		pilots = lapTimeHandler.setAbbereviationsAndStartTimes(startLog);
		pilots = lapTimeHandler.setEndTimes(endLog, pilots);
		pilots = lapTimeHandler.setLapTimes(pilots);
		pilots = nameHandler.setPilotNamesAndCarNames(pilots, names);
		pilots.sort(Comparator.comparing(Pilot::getLapTime));
		return pilots;
	}
}
