package foxminded.laptimes;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class Runner {

	public static void main(String[] args) throws ParseException {
		ResultsListBuilder resultsListBuilder = new ResultsListBuilder();
		List<Pilot> pilots = resultsListBuilder.buildResultsList(ListHolder.START, ListHolder.END, ListHolder.NAMES);
		FinalResultBuilder finalResultBuilder = new FinalResultBuilder();
		List<String> result = finalResultBuilder.getFinalResult(pilots);
		result.stream().forEach(s -> System.out.println(s));
	}
}
