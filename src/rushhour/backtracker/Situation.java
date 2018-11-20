package rushhour.backtracker;

import rushhour.AutoList;

public class Situation {
	public int durchlauf;
	public AutoList situationAutoList;
	public Situation(int durchlauf,AutoList situation) {
		this.durchlauf=durchlauf;
		this.situationAutoList=situation.clone();
		// TODO Auto-generated constructor stub
	}

}
