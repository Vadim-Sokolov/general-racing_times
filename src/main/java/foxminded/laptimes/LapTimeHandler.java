package foxminded.laptimes;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LapTimeHandler {

	public List<Pilot> setAbbereviationsAndStartTimes(List<String> list) {
		String abbreviation = null;
		String startTime = null;
		List<Pilot> result = new ArrayList<>();
		for (String s : list) {
			Pilot pilot = new Pilot();
			abbreviation = s.substring(0, 3);
			startTime = s.substring(s.lastIndexOf('_') + 1);
			pilot.setAbbreviation(abbreviation);
			pilot.setStartTime(startTime);
			result.add(pilot);
		}
		return result;
	}
	
	public List<Pilot> setEndTimes(List<String> endLog, List<Pilot> pilots) {
		String abbreviation = null;
		String endTime = null;
		List<Pilot> result = new ArrayList<>();
		for (String s : endLog) {
			abbreviation = s.substring(0, 3);
			endTime = s.substring(s.lastIndexOf('_') + 1);
			Pilot pilot = getPilotByAbbreviation(pilots, abbreviation);
			pilot.setEndTime(endTime);
			result.add(pilot);
		}
		return result;
	}
	
	private Pilot getPilotByAbbreviation(List<Pilot> pilots, String abbreviation) {
		return pilots.stream().filter(p -> p.getAbbreviation().equals(abbreviation)).findFirst().get();
	}
	
	public List<Pilot> setLapTimes(List<Pilot> pilots) {
		pilots.stream().forEach(p -> {
			try {
				p.setLapTime(calculateLapTime(p));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		return pilots;
	}

	private String calculateLapTime(Pilot p) throws ParseException {
		DateFormat format = new java.text.SimpleDateFormat("hh:mm:ss.SSS");
		Date start = format.parse(p.getStartTime());
		Date end = format.parse(p.getEndTime());
		long milliseconds = end.getTime() - start.getTime();
		return convertMilliSecondsToTime(milliseconds);
	}

	private static String convertMilliSecondsToTime(long milliseconds) {
		long minutes = (milliseconds / 1000) / 60;
		long seconds = (milliseconds / 1000) % 60;
		long remainder = milliseconds - (minutes * 60 * 1000) - (seconds * 1000);
		return String.format("%d:%02d:%03d", minutes, seconds, remainder);
	}
}
