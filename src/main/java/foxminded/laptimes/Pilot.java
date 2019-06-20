package foxminded.laptimes;

public class Pilot {

	private String abbreviation;
	private String pilotName;
	private String carName;
	private String startTime;
	private String endTime;
	private String lapTime;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	@Override
	public String toString() {
		return "Pilot [abbreviation=" + abbreviation + ", pilotName=" + pilotName + ", carName=" + carName
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", lapTime=" + lapTime + "]";
	}
}
