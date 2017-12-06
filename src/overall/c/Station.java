package overall.c;

public class Station {
	public String name;
	public int fare;
	public Station(String name, int fare) {
		this.name = name;
		this.fare = fare;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}

	public String toString() {
		return this.name + "駅まで\t" + this.fare + "円";
	}
}
