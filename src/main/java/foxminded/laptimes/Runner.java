package foxminded.laptimes;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Runner {

	public static void main(String[] args) throws ParseException {

		LapTimeHandler lapHandler = new LapTimeHandler();
		Map<String, String> lapTimes = lapHandler.getLapTimes(ListHolder.START, ListHolder.END);

		NameHandler nameHandler = new NameHandler();
		Map<String, String> pilotNames = nameHandler.getPilotNames(ListHolder.NAMES);
		Map<String, String> carNames = nameHandler.getCarNames(ListHolder.NAMES);

		MyStringBuilder resultBuilder = new MyStringBuilder();
		List<String> result = resultBuilder.getFinalResult(lapTimes, pilotNames, carNames);
		result.stream().forEach(s -> System.out.println(s));
	}
}
