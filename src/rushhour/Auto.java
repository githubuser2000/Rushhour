package rushhour;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

// Ein Auto ist an koordinaten x y und +1 ggf. +2
// Bild wird gezeichnet von oben links nach unten rechts - dementsprechend die Koordinaten
public class Auto implements Cloneable , Comparable<Auto> {
	//private int _autonr;
	//private int[] _position;
	private boolean _istEiswagen;
	//private int[] _ausgangsposition;
	//private Spielfeld Spielfeld;
	//spiel.Spielfeldfenster _unnamed_Spielfeldfenster_;
	private byte xx,yy;
	private final byte llaenge;
	private final hochkantORLaengs aausrichtung;
	//private final AutoList Autos;
	private int compareNumber;
	private AutoList autos;

	public  Auto(hochkantORLaengs ausrichtung, byte laenge,byte x, byte y,AutoList Autos) {
		
		this.aausrichtung=ausrichtung;
		this.llaenge=laenge;
		this.xx=x;
		this.yy=y;
		//this.Spielfeld=sf;
	    this.autos=Autos;
		this.compareNumber=this.calculateCompareNumber();
	}
	/*
	public Spielfeld getSpielfeld() {
	    return Spielfeld;
	}
	*/
	public byte getY(){
		return yy;
	}
	public byte getX(){
		return xx;
	}
	public byte laenge(){
		return llaenge;
	}
	public hochkantORLaengs ausrichtung(){
		return aausrichtung;
	}
	
	
	public int[] getPosition() {
		int[] a={xx,yy};
		return a;
	}

	public boolean istEiswagen() {
		return _istEiswagen;
		}
	public void ToEiswagen() {
		_istEiswagen=true;
		this.compareNumber=this.calculateCompareNumber();
		} 
	private Weg vor(boolean bewege) {
		//System.out.println("Spielfeld.spielfeldgroesse"+Spielfeld.spielfeldgroesse);
		if (aausrichtung==hochkantORLaengs.laengs) { // waargerecht
			if (xx+llaenge==Spielfeld.spielfeldgroesse)				
				return Weg.Wand; 
			else {
				//System.out.println("xx->"+xx+" "+llaenge+"<-llaenge");
				// 
				//System.out.println("Autos: "+this.autos.getCompareNumber());
				if (Spielfeld.AutoFeld(this.autos,(byte)(xx+llaenge),yy)==null) {
					if (bewege) {		
						this.compareNumber=calculateCompareNumber();
						xx++;										
					}
					return Weg.Frei;
				} else {					
					return Weg.Auto;
				}
			}			
		} else {
			if (yy+llaenge==Spielfeld.spielfeldgroesse)
				return Weg.Wand; 
			else {
				//System.out.println("yy->"+yy+" "+llaenge+"<-llaenge");
				
				// rich
				if (Spielfeld.AutoFeld(this.autos,xx,(byte)(yy+llaenge))==null) {
					if (bewege) {		
						
						yy++;
						this.compareNumber=this.calculateCompareNumber();
						
					}
					return Weg.Frei;
				} else
					return Weg.Auto;
			}
		}
		
	}
	
	public Weg setVor() {
	    //System.out.println("vor mit Eigenschaften:");
	    //System.out.println(this.Eigenschaften());
		return vor(true);
	}
	public Weg FreiVorn() {
		return vor(false);
	}
	private Weg zurueck(boolean bewege) {
		//System.out.println(xx+" "+yy);
		if (aausrichtung==hochkantORLaengs.laengs) { // waargerecht
			if (xx==0)				
				return Weg.Wand; 
			else {				
				if (Spielfeld.AutoFeld(this.autos,(byte)(xx-1),yy)==null) {
					if (bewege) {	
						
						xx--;	
						
						
					}
					return Weg.Frei;
				} else
					return Weg.Auto;
				
			}			
		} else {
			if (yy==0)
				return Weg.Wand; 
			else {				
				if (Spielfeld.AutoFeld(this.autos,(byte)xx,(byte)(yy-1))==null) {
					if (bewege) {
						
						yy--;		
						this.compareNumber=calculateCompareNumber();
						
					}
					return Weg.Frei;
				} else
					return Weg.Auto;
			}
		}
	}
	
	public void clicked(byte x, byte y) {
		if (istDiesesAuto(x, y)) {			
		    //System.out.println(this.FreiVorn()+" "+this.FreiHinten());
			if ((xx == x) && (yy == y)) {
				zurueck(zurueck(false) == Weg.Frei); 
			} else {
				if ((llaenge == 2) || (((xx+1 != x) && (yy+1 != y)))){
					vor(vor(false) == Weg.Frei);
				}
			}
			if (this.istEiswagen()) {
				if (this.xx == 4) {
					JOptionPane.showMessageDialog(null, "Gewonnen!");
				}
			}
		}
	
	}
	
	public Auto clone(AutoList autolist) {
		Auto Auto=new Auto( aausrichtung,  llaenge, xx,  yy, autolist);
		if (this.istEiswagen()) Auto.ToEiswagen();
		return Auto;
	}
	
	public boolean istDiesesAuto(byte x, byte y) {
		if (this.xx==x&&this.yy==y)
			return true;
		if (this.aausrichtung==hochkantORLaengs.laengs) {
			if (this.xx+1==x&&this.yy==y)
				return true;
			if (llaenge==3&&this.xx+2==x&&this.yy==y)
				return true;
		} else {
			if (this.xx==x&&this.yy+1==y)
				return true;
			if (llaenge==3&&this.xx==x&&this.yy+2==y)
				return true;
		}
		return false;
	}
	
	public Weg setZurueck() {
	    //System.out.println("zur�ck mit Eigenschaften:");
        //System.out.println(this.Eigenschaften());
		return zurueck(true);
	}
	public Weg FreiHinten() {
		return zurueck(false);
	}
	/*private int calculateCompareNumber(){

	}*/
	private int calculateCompareNumber(){
		double _istEiswagen2;
		if (_istEiswagen)
			_istEiswagen2=1;
		else
			_istEiswagen2=2;
		this.compareNumber=(int) (xx+6*(yy+6*((llaenge-2)+2*(aausrichtung.ordinal()+2*_istEiswagen2))));
		return compareNumber;
		/*
		double _istEiswagen2;
		if (_istEiswagen)
			_istEiswagen2=1;
		else
			_istEiswagen2=2;
		
		this.goedelNumber=BigInteger.valueOf((long)Math.pow(2,(double)(xx+1)));
		this.goedelNumber=goedelNumber.multiply(BigInteger.valueOf((long)Math.pow(3,(double)(yy+1))));
		this.goedelNumber=goedelNumber.multiply(BigInteger.valueOf((long)Math.pow(5,(double)(llaenge))));
		this.goedelNumber=goedelNumber.multiply(BigInteger.valueOf((long)Math.pow(7,(double)(aausrichtung.ordinal()))));
		this.goedelNumber=goedelNumber.multiply(BigInteger.valueOf((long)Math.pow(11,(double)(_istEiswagen2))));
		return this.goedelNumber;
		*/
	}	
	
	public int getCompareNumber() {
		// nächste zeile wieder entfernen!
		//calculateCompareNumber();
	    return this.compareNumber;
	}

	@Override
	public int compareTo(Auto auto) {
        // Eiswagen Koord und Laenge und Ausrichtung
		//System.out.println("co1 "+this.Eigenschaften());
		//System.out.println("co2 "+auto.Eigenschaften());
        //if (this._istEiswagen==auto._istEiswagen && this.x()==auto.x()&& this.y()==auto.y() && this.laenge()==auto.laenge() && auto.aausrichtung.equals(this.aausrichtung))
		//int thisGoedel=goedelForCompare(_istEiswagen,getX(),getY(),laenge(),aausrichtung);
		//int thoseGoedel=goedelForCompare(auto._istEiswagen,auto.getX(),auto.getY(),auto.laenge(),auto.aausrichtung);
		//System.out.println(thisGoedel+" = "+thoseGoedel);
	    //if (this.getGoedelNumber()-auto.getGoedelNumber()==0)
	     //   System.out.println("2 autos gleich");
		return this.getCompareNumber()-auto.getCompareNumber();
		/*
		if (thisGoedel<thoseGoedel)
			return -1;
		else if (thisGoedel>thoseGoedel)
			return 1;
		else
			return 0;
		*/
		/*if (  this.x() == auto.x()) {
        	System.out.println("y1 "+this.y());
        	System.out.println("y2 "+auto.y());
            return 0;
        }*/
        //System.out.println("y11 "+this.y());
    	//System.out.println("y22 "+auto.y());
        // TODO Auto-generated method stub
    	//
   }
	
	/*
	@Override
	public boolean equals(Object auto) {
        if (this._istEiswagen==((Auto) auto)._istEiswagen && this.x()==((Auto)auto).x( )&& this.y()==((Auto)auto).y() && this.laenge()==((Auto)auto).laenge() && ((Auto)auto).aausrichtung==this.aausrichtung) 
        	return true;
		 else
		    return false;
	}
	*/
	/*
	public String Eigenschaften() {
		return (_istEiswagen?"eiswagen!":"")+ " x "+xx+ " y "+yy+ " l "+llaenge+" ausricht "+aausrichtung;
	}
 */

}