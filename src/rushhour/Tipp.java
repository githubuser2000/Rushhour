package rushhour;


// noch nicht oder nie fertig implementierte bzw. veraltete Klasse
public class Tipp {
	private Auto Auto;
	private boolean vor; // bei false=zurueck
	public Tipp(Auto a,boolean v) {
		Auto=a;
		vor=v;
	}
	public Auto getAuto() {
		return Auto;
	}
	public boolean Vorwaerts() {
		return vor;
	}
	public boolean Rueckwaerts() {
		return !vor;
	}
}
