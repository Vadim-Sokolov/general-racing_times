package foxminded.laptimes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinalResultBuilderTest {

	FinalResultBuilder finalResultBuilder = new FinalResultBuilder();

	@Test
	void shouldReturnCorrectStringInList() {
		// Given
		List<Pilot> list = new ArrayList<>();
		Pilot pilot = new Pilot();
		pilot.setPilotName("pip");
		pilot.setCarName("cap");
		pilot.setLapTime("zzz");
		list.add(pilot);
		String expected = "1.  pip | cap | zzz";

		// When
		List<String> actualList = finalResultBuilder.getFinalResult(list);
		String actual = actualList.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldThrowException_whenInputIsNull() {
		// Given
		List<Pilot> list = new ArrayList<>();
		Pilot pilot = new Pilot();
		list.add(pilot);

		// Then
		Assertions.assertThrows(NullPointerException.class, () -> {
			finalResultBuilder.getFinalResult(list);
		});
	}

}
