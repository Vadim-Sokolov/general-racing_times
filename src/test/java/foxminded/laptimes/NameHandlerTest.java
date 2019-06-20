package foxminded.laptimes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameHandlerTest {

	NameHandler nameHandler = new NameHandler();

	@Test
	void shouldSetCorrectPilotNameAndCarName() {
		List<String> names = new ArrayList<>();
		names.add("bbm_bob_mini");
		Pilot pilot = new Pilot();
		pilot.setAbbreviation("bbm");
		List<Pilot> pilots = new ArrayList<>();
		pilots.add(pilot);
		String expectedPilotName = "bob";
		String expectedCarName = "mini";

		// When
		pilots = nameHandler.setPilotNamesAndCarNames(pilots, names);
		String actualPilotName = pilots.get(0).getPilotName();
		String actualCarName = pilots.get(0).getCarName();

		// Then
		assertEquals(expectedPilotName, actualPilotName);
		assertEquals(expectedCarName, actualCarName);
	}

	@Test
	public void shouldThrowException_whenAbbreviationIsTooShort() {
		// Given
		List<String> names = new ArrayList<>();
		names.add("s1");
		List<Pilot> pilots = new ArrayList<>();
		Pilot pilot = new Pilot();
		pilots.add(pilot);

		// Then
		Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
			nameHandler.setPilotNamesAndCarNames(pilots, names);
		});
	}

	@Test
	public void shouldThrowException_whenPilotAbbreviationIsNull() {
		// Given
		List<String> names = new ArrayList<>();
		names.add("s11_sss_kdk");
		List<Pilot> pilots = new ArrayList<>();
		Pilot pilot = new Pilot();
		pilots.add(pilot);

		// Then
		Assertions.assertThrows(NullPointerException.class, () -> {
			nameHandler.setPilotNamesAndCarNames(pilots, names);
		});
	}
}
