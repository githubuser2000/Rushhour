package rushhour.backtracker;

public class Knoten {

	private WahrFalschOrBeides value=WahrFalschOrBeides.falsch;
	private Knoten branchA;
	private Knoten branchB;
	private Knoten father;
	
	public Knoten(Knoten branchA,Knoten branchB,Knoten father) {
		this.branchA=branchA;
		this.branchB=branchB;
		this.father=father;
		// TODO Auto-generated constructor stub
	}
	public void setValue(WahrFalschOrBeides value){
		this.value=value;
	}

}
