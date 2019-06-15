package foxminded.laptimes;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LapTimeHandler {

	public Map<String, String> getLapTimes(List<String> startLog, List<String> endLog) throws ParseException {
		Map<String, String> start = getNameAndTime(startLog);
		Map<String, String> end = getNameAndTime(endLog);
		return processLapTimes(start, end);
	}

	public Map<String, String> getNameAndTime(List<String> list) {
		Map<String, String> result = new TreeMap<>();
		String name = null;
		String time = null;
		for (String s : list) {
			name = s.substring(0, 3);
			time = s.substring(s.lastIndexOf('_') + 1);
			result.put(name, time);
		}
		return result;
	}

	public Map<String, String> processLapTimes(Map<String, String> start, Map<String, String> end) throws ParseException {
		Map<String, String> lapTimes = new TreeMap<>();
		for (String key : start.keySet()) {
			String startTime = start.get(key);
			String endTime = end.get(key);
			String lapTime = calculateLapTime(startTime, endTime);
			lapTimes.put(lapTime, key);
		}
		return lapTimes;
	}

	public String calculateLapTime(String startTime, String endTime) throws ParseException {
		DateFormat format = new java.text.SimpleDateFormat("hh:mm:ss.SSS");
		Date start = format.parse(startTime);
		Date end = format.parse(endTime);
		long milliseconds = end.getTime() - start.getTime();
		return convertMilliSecondsToTime(milliseconds);
	}

	public static String convertMilliSecondsToTime(long milliseconds) {
		long minutes = (milliseconds / 1000) / 60;
		long seconds = (milliseconds / 1000) % 60;
		long remainder = milliseconds - (minutes * 60 * 1000) - (seconds * 1000);
		return String.format("%d:%02d:%03d", minutes, seconds, remainder);
	}
}
