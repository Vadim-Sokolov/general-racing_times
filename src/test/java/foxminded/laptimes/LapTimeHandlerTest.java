package foxminded.laptimes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LapTimeHandlerTest {

	LapTimeHandler lapTimeHandler = new LapTimeHandler();

	@Test
	void shouldSetCorrectStartTimeAndAbbreviation() {
		// Given
		List<String> list = new ArrayList<>();
		list.add("abr_startTime");
		String expectedAbbreviation = "abr";
		String expectedStartTime = "startTime";

		// When
		List<Pilot> pilots = lapTimeHandler.setAbbereviationsAndStartTimes(list);
		String actualAbbreviation = pilots.get(0).getAbbreviation();
		String actualStartTime = pilots.get(0).getStartTime();

		// Then
		assertEquals(expectedAbbreviation, actualAbbreviation);
		assertEquals(expectedStartTime, actualStartTime);
	}

	@Test
	void shouldSetCorrectEndTime() {
		List<String> list = new ArrayList<>();
		list.add("abr_endTime");
		Pilot pilot = new Pilot();
		pilot.setAbbreviation("abr");
		List<Pilot> pilots = new ArrayList<>();
		pilots.add(pilot);
		String expectedEndTime = "endTime";

		// When
		pilots = lapTimeHandler.setEndTimes(list, pilots);
		String actualEndTime = pilots.get(0).getEndTime();

		// Then
		assertEquals(expectedEndTime, actualEndTime);
	}
	
	@Test
	public void shouldThrowException_whenAbbreviationIsTooShort() {
		// Given
				List<String> list = new ArrayList<>();
				list.add("s1");
				List<Pilot> pilots = new ArrayList<>();
				Pilot pilot = new Pilot();
				pilots.add(pilot);

				// Then
				Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
					lapTimeHandler.setEndTimes(list, pilots);
				});
	}

	@Test
	public void shouldThrowException_whenPilotAbbreviationIsNull() {
		// Given
		List<String> list = new ArrayList<>();
		list.add("s11");
		List<Pilot> pilots = new ArrayList<>();
		Pilot pilot = new Pilot();
		pilots.add(pilot);

		// Then
		Assertions.assertThrows(NullPointerException.class, () -> {
			lapTimeHandler.setEndTimes(list, pilots);
		});
	}
}
