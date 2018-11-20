package rushhour.backtracker;

import rushhour.*;

public class Movement implements Cloneable {
	private byte carNumber;
	private VorORZurueck voz;
	private boolean finish2;
	private boolean ursprung;
	Movement(byte carNumber,VorORZurueck voz,boolean ursprung,boolean finish2) {
		this.voz=voz;
		this.carNumber=carNumber;
		this.ursprung=ursprung;
		this.finish2=finish2;
	}
	public byte getCarNumber() {
		return carNumber;
	}
	public VorORZurueck getVorORZurueck() {
		return voz;
	}
	public Movement clone() {
		return new Movement(carNumber,voz,ursprung,finish2);
		
	}
}
