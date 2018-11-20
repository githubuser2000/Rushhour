package rushhour.backtracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import rushhour.*;

public class Backtrack {

	//private Spielfeld spielfeld;
	//private AutoList situationAutos;
	private final byte maxDepth_=20;
	private  AutoListSet autoListenSet=new AutoListSet();;
	private long funktionsAufrufe;
	int frei;
	private List<Situation> durchlaufe=new LinkedList<Situation>();
	int min;
	int max;
	
	public Situation[] getMinMaxWays(){
	    if (durchlaufe.size()==0)
	        return null;
		Situation sit[]={durchlaufe.get(min),durchlaufe.get(max)};
		return sit;
	}
	public List<Situation> getSituationen() {
	    return durchlaufe;
	}
	
	public Backtrack(rushhour.Spielfeld spielfeld) {
		//this.spielfeld=spielfeld;
	    frei=0;
	    funktionsAufrufe=0;
	    System.out.println("start ");    
		AutoList autos_anfangs = spielfeld.getAutos().clone();
		autoListenSet.clear();
		durchlaufe.clear();
		Rekursion(autos_anfangs,maxDepth_,0,false,false,false,new LinkedList<Movement>(),0);
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		int i=0;
		for (Situation durchlauf : durchlaufe) {
		    //System.out.println("NonAutoFelder: "+this.countNonCars(durchlauf.situationAutoList));
		    //System.out.println("EiswagenX("+i+"): "+durchlauf.situationAutoList.getEiswagen().getX());
			if (durchlauf.durchlauf<min) {
				min=i;
			}
			if (durchlauf.durchlauf>max) {
				max=i;
			}
			i++;
		}
		/*
		System.out.println("durchlaufe.get(0) size: "+durchlaufe.size());
		Spielfeld.AutoFeld2(durchlaufe.get(0).situationAutoList);
		System.out.println("durchlaufe.get(max) mit max="+max);
		Spielfeld.AutoFeld2(durchlaufe.get(max).situationAutoList);
		System.out.println("min: "+min+" max: "+max);
		*/
		// jetzt muss ich alle autos aus dem Urzustand hier rein holen
		// dann teste ich jedes Auto auf hin und zurückfahrbarkeit
		// wenn es hin oder zurück fahrbar ist, wird das gelistet als
		// Autonummer mit Datentyp byte und richtung als enum
		System.out.println("Funktionsaufrufe: "+funktionsAufrufe);
		System.out.println("Funktionsaufrufe2: "+AutoList.vielfaeltigkeiten);		
		
	}
	/*
	public static int countNonCars(AutoList autos) {
	    int amount=0;
	    for (int i=0;i<6;i++) {
	        for (int k=0;k<6;k++) {
	            if (Spielfeld.AutoFeld(autos, (byte)i, (byte) k)==null)
	                amount++;
	        }
	            
	    }
	    //Spielfeld.getAutos().getAutoPos();
	    return amount;
	}
	*/
	//private boolean stoppen;
	
	private void  Rekursion(AutoList autosA,byte maxDepth,int stepBetweenUrsprungAndFinished,boolean finished1,boolean finished2,boolean einZweigWarImUrsprung,List<Movement> Moves,int durchlaeufe) {
	    /*int noncars2=countNonCars(autosA);
	    System.out.println("noncars: "+noncars+" noncars2: "+noncars2);
	    if (noncars2!=noncars&&!stoppen) {
	    	Spielfeld.AutoFeld2(autosA);
	        System.out.println("Dieser Error");
	        autosA.getAutoPos();
	        stoppen=true;
	        einZweigWarImUrsprung=true;
	       //System.exit(0);
	        this.durchlaufe.clear();    
	        this.durchlaufe.add(new Situationen(durchlaeufe,autosA));
	    }
// if (!stoppen) { */
	    AutoList autosE=null;
		durchlaeufe++;
		finished1=true;	
	    funktionsAufrufe++;
		AutoList autosB = autosA.clone();	
		autosB.setOldBacktracked(false);
		//System.out.println("Autos: "+autosA.size());
		//AutoList autosC = autosA.clone();
		//Iterator<Auto> it=autosB.iterator();		
		int i=0;
		//int SetSize=autoListenSet.size();		
		while (i<autosA.size()) {
		    AutoList autosC = autosB.clone();
		    AutoList autosD = autosB.clone();
		    Auto autoAusC=autosC.get(i);
		    Auto autoAusD=autosD.get(i);

		    /*
		    for (AutoList list : autoListenSet) {
		    	if (list.oldBacktracked) {}
		    }
		    */
		    
			if (autoAusC.FreiVorn()==Weg.Frei) {
				/*System.out.println("nach Vorn vorher:");
				Spielfeld.AutoFeld2(autosC);
				int a=countNonCars(autosC);*/
				autoAusC.setVor();
				/*int b=countNonCa
				 * rs(autosC);
				System.out.println("a-b="+(a-b));
				System.out.println("nach Vorn nachher:");
				Spielfeld.AutoFeld2(autosC);*/
				//System.out.println("eiswagen: "+(autoAusC.istEiswagen())+" "+autoAusC.getX());
				if (autoAusC.istEiswagen() && autoAusC.getX()==Spielfeld.spielfeldgroesse-2) {		    		
		    		if (einZweigWarImUrsprung) {
		    			System.out.println("gewonnen2");
		    			finished2=true;
		    		}
		    	}
				//System.out.println("gleich?: "+(autoAusC.getGoedelNumber()==autosA.clone().get(i).getGoedelNumber()));
				//System.out.println("gleich2?: "+(autoAusC.getGoedelNumber()==autosA.get(i).getGoedelNumber()));
			    // -> die Autos sind schon doch unterschiedlich wie es sein soll
				/*
				for (Auto auto : autosC) {
					auto.getGoedelNumber();
				}
				for (Auto auto : autosA) {
					auto.getGoedelNumber();
				}
				*/
				//System.out.println("Auto Nr. "+i+" "+autosC.get(i).getGoedelNumber()+" == "+autosA.get(i).getGoedelNumber());				
				//System.out.println("gleich3?: "+(autosC.getGoedelNumber()==autosA.getGoedelNumber()));
				
				// trotz unterschiedlicher Autos sei die Gödelnummer von 2 Autolisten gleich
				
				
				//System.out.println("gleich4?: "+(autoAusC.getGoedelNumber()==autosC.get(i).getGoedelNumber()));
				//System.out.println("gleich5?: "+(autoAusC.getGoedelNumber()==autosA.get(i).getGoedelNumber()));
				//System.out.println("gleich2b?: "+(autoAusC.Eigenschaften()));
				//System.out.println("gleich2c?: "+(autosA.get(i).Eigenschaften()));
				//System.out.println("gleich6?: "+(autosC.getGoedelNumber()==autosA.getGoedelNumber()));
				//System.out.println("7?: "+(autosC.compareTo(autosA)));

			   // if (!autoListenSet.contains(autosC)) {
			        frei++;
			        autoListenSet.add(autosC);			        
			        //System.out.println("bla: "+autoListenSet.toArray(new AutoList[autoListenSet.size()])[i].oldBacktracked);
			    	//System.out.println(autosC.getGoedelNumber());
//					if (autoListenSet.contains(o))

			   // }
				//Moves.add(new Movement((byte)i,VorORZurueck.vor,einZweigWarImUrsprung,finished));
			}            
			if (autoAusD.FreiHinten()==Weg.Frei) {	
				/*System.out.println("nach Vorn vorher:");
				Spielfeld.AutoFeld2(autosD);
				int a=countNonCars(autosC);*/
			    autoAusD.setZurueck();
			    
			    /*int b=countNonCars(autosC);
				System.out.println("a-b="+(a-b));
			    System.out.println("nach Vorn nachher:");
				Spielfeld.AutoFeld2(autosD);*/
				//System.out.println("gleich?: "+(autoAusD.getGoedelNumber()==autosA.clone().get(i).getGoedelNumber()));
			    //System.out.println("gleich2?: "+(autoAusD.getGoedelNumber()==autosA.get(i).getGoedelNumber()));
			    // -> die Autos sind schon doch unterschiedlich wie es sein soll
				//System.out.println("Auto Nr. "+i+" "+autosD.get(i).getGoedelNumber()+" == "+autosA.get(i).getGoedelNumber());
				//System.out.println("gleich3?: "+(autosD.getGoedelNumber()==autosA.getGoedelNumber()));
				
				//System.out.println("gleich4?: "+(autoAusD.getGoedelNumber()==autosD.get(i).getGoedelNumber()));
				//System.out.println("gleich5?: "+(autoAusD.getGoedelNumber()==autosA.get(i).getGoedelNumber()));
			    //System.out.println("gleich6?: "+(autosD.getGoedelNumber()==autosA.getGoedelNumber()));
			    //System.out.println("7?: "+(autosD.compareTo(autosA)));
			    //System.out.println("gleich?: "+(autosA.clone().get(i).getGoedelNumber()==autoAusD.getGoedelNumber()));
			   // if (!autoListenSet.contains(autosD)) {
			    	frei++;
			    	autoListenSet.add(autosD);				
			    	//System.out.println(autosD.getGoedelNumber());
			    	if (autoAusD.istEiswagen() && autoAusD.getX()==0&&!einZweigWarImUrsprung&&!finished2&&finished1) {			
			    		System.out.println("ursprung");
			    		einZweigWarImUrsprung=true;	
			    		//autosE=autosD;
			    		this.durchlaufe.add(new Situation(durchlaeufe,autosD));
			    	}
			   // }
				//Moves.add(new Movement((byte)i,VorORZurueck.zurueck,einZweigWarImUrsprung,finished));				
			}			
			i++;
		}
		//boolean hasChanged=SetSize!=autoListenSet.size(); 
		
		
		
		if (einZweigWarImUrsprung&&!finished2) {
			stepBetweenUrsprungAndFinished++;
		}
	    //System.out.println("frei: "+frei);
		//System.out.println("stepBetweenUrsprungAndFinished: "+stepBetweenUrsprungAndFinished);
		//System.out.println("autoListenSet Bewegungsmoeglichkeiten Anzahl: "+autoListenSet.size());
		//System.out.println("Schritte der Bewegung: "+ Moves.size());
		//System.out.println("Schritte bis zum Ende: "+ maxDepth);
		
		/*List<Movement> MovesCloned=new LinkedList<Movement>();
		for (Movement m : Moves) {
			MovesCloned.add(m.clone());
		}
		*/
		if (maxDepth > 0 /* && ! einZweigWarImUrsprung*/ ) {
			
			//boolean flag=false;	
			/*
			for (AutoList autosEinerSituation : autoListenSet) {
				if (autosEinerSituation.oldBacktracked==false) {
					// anstelle hier alle jedesmal durchzutesten könnte man einen
					// binärbaum machen, der an den knoten noch mal ne zusammenfassung
					// macht, ob die unteren beiden false oder true oder unterschiedlich sind
					flag=true;
				} 
			}*/
			//if (hasChanged) {
				
				//int cd=0;
				/*
				List<Boolean> boollist=new LinkedList<Boolean>();				
				for (AutoList autosEinerSituation : autoListenSet) {
					boollist.add(autosEinerSituation.oldBacktracked);
				}
				 for (AutoList autosEinerSituation : autoListenSet) {
			         autosEinerSituation.setOldBacktracked(true);
			      }*/
				//autoListenSet.
				
				//autoListenSet.toArray(new AutoList[autoListenSet.size()]);
				//AutoListSet autolistset2=autoListenSet.clone();
				//Iterator<AutoList> it=autolistset2.iterator();
				i=0;
				Set<Integer> intlist=new HashSet<Integer>();
				for (AutoList autosEinerSituation : autoListenSet) {
					if (!autosEinerSituation.getoldBacktracked() /*|| einZweigWarImUrsprung*/) {
						intlist.add(i);
						//cd++;
						autosEinerSituation.setOldBacktracked(true);
						//einZweigWarImUrsprung=false;
						AutoList.vielfaeltigkeiten++;						
						//startRekursion(it.next().clone(),(byte)(maxDepth -1),stepBetweenUrsprungAndFinished,finished1,finished2,einZweigWarImUrsprung,Moves);
						//startRekursion(autoListenSet.,(byte)(maxDepth -1),stepBetweenUrsprungAndFinished,finished1,finished2,einZweigWarImUrsprung,Moves);
						//System.out.println("true!!!");
					} else {
						//System.out.println("false!!!");
						//flag=true;
					}
					i++;
				}
				i=0;
				for (AutoList autosEinerSituation : autoListenSet.clone()) {
					if (intlist.contains(i)){					  
					  //System.out.println("drin ");
					  Rekursion(autosEinerSituation,(byte)(maxDepth -1),stepBetweenUrsprungAndFinished,finished1,finished2,einZweigWarImUrsprung,Moves,durchlaeufe);
					}
					i++;
				}
				//stem.out.println("abcd "+i+" "+cd);
			//}
//				if (einZweigWarImUrsprung)
//				    this.durchlaufe.add(new Situation(durchlaeufe,autosE));
		}
		
//} 
	} 
}

