package rushhour;

import java.util.LinkedList;
import java.util.List;

public class BaumKnoten {
	public MoeglichkeitAuto MoeglichkeitAusgefuehrtFuerUnterKnoten;
	public List<BaumKnoten> Unterknoten;
	public LinkedList<Auto> Autos;
	public BaumKnoten Vater;
	public BaumKnoten(MoeglichkeitAuto a,List<BaumKnoten>  u,LinkedList<Auto> b,BaumKnoten v) {
		MoeglichkeitAusgefuehrtFuerUnterKnoten=a;
		Unterknoten=u;
		Autos=b;
		Vater=v;
	}
}
