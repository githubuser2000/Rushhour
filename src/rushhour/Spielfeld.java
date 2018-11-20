package rushhour;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.*;

public class Spielfeld {
	//private int _groesse;
	//private int[] _zielposition;
	//spiel.Rushhourspiel ;
	//spiel.Spielfeldfenster _unnamed_Spielfeldfenster_;
	//public Auto[][] Autofeld= new Auto[6][6];
    private byte EiswagenY;
	private  static AutoList Autos_;
	public static byte spielfeldgroesse;
	//public  AutoList Autos_Sicherung; // der bereits verschobenen Autos
	//public  AutoList LAutos; // noch nicht verschobene Autos
	
	public static void setAutos(AutoList autos) {
		Autos_=autos;
	}
	public static AutoList getAutos() {
		return Autos_;
	}
	public byte getEiswagenY() {
	    return EiswagenY;
	}
	public  Spielfeld(byte auto2er,byte auto3er,byte spielzuege,byte spielfeldgroesse) {
	    this.spielfeldgroesse=spielfeldgroesse;
		zufall(auto2er,auto3er,spielzuege);
	}
	private  boolean AutoIsOK(AutoList Autos_,Auto auto) {
	    if (Autos_.uebereinander(auto)) {
	        System.out.println("a");
	        return false;}
	    
	    if (auto.getY()==this.EiswagenY&&auto.ausrichtung()==hochkantORLaengs.laengs){
	        System.out.println("b");
	        return false;}
	    
	    byte m;
	    for (byte x=0;x<spielfeldgroesse-2;x++) {
	        m=(byte)0;
	        for (byte y=0;y<spielfeldgroesse;y++) {
	            Auto auto2=Spielfeld.AutoFeld(Autos_, x, y);
	            if (auto2!=null)
	                if (auto2.ausrichtung()==hochkantORLaengs.hochkant) 
	                    m++;	                
	            if (auto.getX()==x&&((auto.getY()+2==y&&auto.laenge()==3)||auto.getY()+1==y||auto.getY()==y)&&auto.ausrichtung()==hochkantORLaengs.hochkant)
	                m++;
	        }
	        if (m==spielfeldgroesse){
	            System.out.println("c");
	            return false;}
	    }
	    
	    for (byte y=0;y<spielfeldgroesse;y++) {        
            m=(byte)0;
            for (byte x=0;x<spielfeldgroesse;x++) {
                Auto auto2=AutoFeld(Autos_, x, y);
                if (auto2!=null) {
                    if (auto2.ausrichtung()==hochkantORLaengs.laengs) {
                        m++;
                        System.out.println("am="+m);
                    }
                }
                if (auto.getY()==y&&((auto.getX()+2==x&&auto.laenge()==3)||auto.getX()+1==x||auto.getX()==x)&&auto.ausrichtung()==hochkantORLaengs.laengs) {
                    m++;
                    System.out.println("bm="+m);
                }
            }
            if (m==spielfeldgroesse){
                System.out.println("d");
                Spielfeld.AutoFeld2(Autos_);
                return false;}
	    }
	    
	    switch(spielfeldgroesse) {
	    case 3:                
	        if (auto.ausrichtung()==hochkantORLaengs.hochkant&&auto.laenge()==3)
	            return false;
	        break;
	    case 4:                
	        if (auto.ausrichtung()==hochkantORLaengs.hochkant&&auto.laenge()==3)
	            return false;
	        break;
	    case 5:
	        if (auto.ausrichtung()==hochkantORLaengs.hochkant&&auto.laenge()==3){
	            System.out.println("e");
	            return false;}
	        break;
	    case 6: break;
	    }

	    System.out.println("true");
	    return true;
	}
	/*
	private boolean versperrt(AutoList Autos_) {
	    int m,n;
	    boolean flag,flag2;
	    for (byte x=0;x<Spielfeld.spielfeldgroesse-2;x++) {
	        m=0;
	        n=0;
	        flag=false;
	        flag2=false;
	        for (byte y=0;y<Spielfeld.spielfeldgroesse;y++) {
	            Auto auto=AutoFeld(Autos_,x,y);
	            if (auto!=null) {
	                if (auto.ausrichtung()==hochkantORLaengs.hochkant) {
	                    m++;
	                    if (auto.laenge()==3&&y<3) {
	                        flag=true;  
	                    }
	                    if (auto.laenge()==2&&y>2&&flag) {
	                    
	                        flag2=true;  
	                    }
	                }                
	            }
	        }
	        if (m>=Spielfeld.spielfeldgroesse||flag2||n==3)
	            return true;
	    }
	        
	    return false;
	}*/
	
	public void zufall(byte auto2er,byte auto3er,byte spielzuege) {		
		byte i,k,x,y;
		int p=0;
		Auto Auto;
        //Autos = new LinkedList<Auto>();
        Autos_ = new AutoList();
		/*
		for (i=0;i<6;i++)
			for (k=0;k<6;k++)
				Autofeld[i][k]=null;*/
		byte senkrecht;
	      
	        switch(spielfeldgroesse) {
	        case 3: 
	            EiswagenY=1;
	            break;
	        case 4:
	            EiswagenY=1;
	            break;
	        case 5:
	            EiswagenY=2;
	            break;
	        default:
	            EiswagenY=2;
	            break;
	    }
	    Auto=new Auto(hochkantORLaengs.laengs,(byte)2,(byte)(spielfeldgroesse-2),(byte)EiswagenY,Autos_);
	    Auto.ToEiswagen();
	    Autos_.add(Auto); 
		
		p=0;
		label2:
		for (i=0;i<auto3er;i++) {

			
			//if (hochkantORlaengs==hochkantORLaengs.laengs) {
			int ab=0;
			do {
		         hochkantORLaengs hochkantORlaengs_;
		            senkrecht=(byte)Math.round(Math.random()); // 0: auto -- 1 |
		            if (senkrecht==0) {             
		                hochkantORlaengs_=hochkantORLaengs.laengs;
		            }else {
		                hochkantORlaengs_=hochkantORLaengs.hochkant;
		            }
		        if (hochkantORlaengs_==hochkantORLaengs.laengs) {
		            x=(byte)Math.floor(Math.random()*(spielfeldgroesse-2)); // 5 werte von 0 bis 3
		            y=(byte)Math.floor(Math.random()*(spielfeldgroesse)); // 5 werte von 0 bis 4
		        } else {
		            x=(byte)Math.floor(Math.random()*(spielfeldgroesse));
		            y=(byte)Math.floor(Math.random()*(spielfeldgroesse-2)); // 5 werte von 0 bis 4
		        }  
				Auto=new Auto(hochkantORlaengs_,(byte)3,x,y,Autos_);
				ab++;
		    } while (!AutoIsOK(Autos_,Auto)&& ! (ab>3000));
				//if (y>=2) y++;
			/*} else {
				x=(byte)Math.floor(Math.random()*(Spielfeld.spielfeldgroesse-2)); // 6 werte von 0 bis 5
				y=(byte)Math.floor(Math.random()*(Spielfeld.spielfeldgroesse-2));			
			}*/
			
			/*
			if (hochkantORlaengs==hochkantORLaengs.laengs) 
			      for (k=0;k<3;k++) 
			      {					
					if (AutoFeld(Autos_,(byte)(x+k),y)!=null||y==EiswagenY) 
					{
						i--;
						p++;
						if (p==300)
							break label2;
						continue label2;
					}
				  } 
				else 
				  for (k=0;k<3;k++) 
				  {									
					if (AutoFeld(Autos_,x,(byte)(y+k))!=null||versperrt(Autos_)) {
						i--;
						p++;
						if (p==300)
							break  label2;
						continue label2;
				  }
				}
			*/
			/*
			if (senkrecht==0) for (k=0;k<3;k++) {
				Autofeld[x+k][y]=Auto;
			} else for (k=0;k<2;k++) {
				Autofeld[x][y+k]=Auto;
			}
			*/
			if (ab<3000)
			    Autos_.add(Auto);
			else
                System.out.println("3000!b");
		}
		label1:
	        for (i=0;i<auto2er;i++) 
	        {           

	            //if (hochkantORlaengs==hochkantORLaengs.laengs) {
	            int ab=0;
	            do {
	                 hochkantORLaengs hochkantORlaengs_;
	                    senkrecht=(byte)Math.round(Math.random()); // 0: auto -- 1 |
	                    if (senkrecht==0) {             
	                        hochkantORlaengs_=hochkantORLaengs.laengs;
	                    }else {
	                        hochkantORlaengs_=hochkantORLaengs.hochkant;
	                    }
	                    if (hochkantORlaengs_==hochkantORLaengs.laengs) {
	                        x=(byte)Math.floor(Math.random()*(spielfeldgroesse-1)); // 5 werte von 0 bis 3
	                        y=(byte)Math.floor(Math.random()*(spielfeldgroesse)); // 5 werte von 0 bis 4
	                    } else {
	                        x=(byte)Math.floor(Math.random()*(spielfeldgroesse));
	                        y=(byte)Math.floor(Math.random()*(spielfeldgroesse-1)); // 5 werte von 0 bis 4
	                    }	                Auto=new Auto(hochkantORlaengs_,(byte)2,x,y,Autos_);
	                ab++;
	            } while (!AutoIsOK(Autos_,Auto)&& ! (ab>3000));
	                /*
	            } else {
	                x=(byte)Math.floor(Math.random()*(Spielfeld.spielfeldgroesse-1)); // 6 werte von 0 bis 5
	                y=(byte)Math.floor(Math.random()*(Spielfeld.spielfeldgroesse-1)); // 3 werte von 0 bis 2
	                //if (y>=1) y+=2;               
	            }*/
	            
	            /*
	            if (hochkantORlaengs==hochkantORLaengs.laengs) 
	                  for (k=0;k<2;k++) 
	                  {
	                      if (AutoFeld(Autos_,(byte)(x+k),y)!=null||y==EiswagenY) 
	                        
	                    {
	                        i--;
	                        p++;
	                        if (p==300)
	                            break label1;
	                        continue label1;
	                    }
	                  } 
	                else 
	                  for (k=0;k<2;k++) 
	                  {             
	                      if (AutoFeld(Autos_,x,(byte)(y+k))!=null||versperrt(Autos_)) {
	                        i--;
	                        p++;
	                        if (p==300)
	                            break  label1;
	                        continue label1;
	                  }
	                }
	                */
	            /*
	            if (senkrecht==0) for (k=0;k<2;k++) {
	                Autofeld[x+k][y]=Auto;              
	            } else for (k=0;k<2;k++) {
	                Autofeld[x][y+k]=Auto;
	            }
	            */
	            if (ab<3000)
	                Autos_.add(Auto);
	            else
	                System.out.println("3000!a");
	        }
	        /*
	        for (i=0;i<6;i++) {
	            for (k=0;k<6;k++) {
	                if (Autofeld[k][i]!=null)
	                    System.out.print("1");
	                else
	                    System.out.print("0");
	            }
	            System.out.print("\r\n");
	        }
	        */
		//LAutos=Autos.clone();//this.CloneAutoList(Autos);
		//AutoFeld(LAutos,(byte)0,(byte)2).setVor();
		//verschiebeautos((byte)1);
		/*
		Auto=AutoFeld(LAutos, (byte)0, (byte)2);
		
		Auto.setVor();
		Auto.setVor();
		Auto.setVor();
		Auto.setVor();
		*/
		//JOptionPane.showMessageDialog(null, (Auto.setVor()));
		
	}
	/*public void verschiebeautos(byte z) {
		
		List<Tipp> TippListe= new LinkedList<Tipp>();
		List<Tipp> TippListe2= new LinkedList<Tipp>();
		//List<Auto> EineAutoListe=new LinkedList<Auto>();
		Auto Auto;
		byte i;
		for (i=2;i<6;i++) {
			
			if (AutoFeld(Autos,(byte)i,(byte)1)!=null) {
				if (AutoFeld(Autos,(byte)i,(byte)1).ausrichtung()==hochkantORLaengs.hochkant) {
					Auto=AutoFeld(Autos,(byte)i,(byte)1);
					Auto.setVor();
					Auto.setVor();
					TippListe.add(new Tipp(Auto,true));
				}
				
			}
		}
		for (i=2;i<6;i++) {
			if (AutoFeld(Autos,(byte)i,(byte)3)!=null) {
				if (AutoFeld(Autos,(byte)i,(byte)3).ausrichtung()==hochkantORLaengs.hochkant) {
					Auto=AutoFeld(Autos,(byte)i,(byte)3);
					Auto.setZurueck();
					Auto.setZurueck();
					TippListe.add(new Tipp(Auto,false));
				}
				
			}			
		}
		boolean flag;		
		byte k,l;
		for (Tipp t: TippListe) {
			flag=false;
			k=0;
			Auto=null;
			for (i=(byte)(t.getAuto().getX());i<6;i++) {
				k++;	
				Auto=AutoFeld(Autos,i,(byte)(t.getAuto().laenge()+t.getAuto().getY()));
				if (!flag&&Auto!=null) {					
					//EineAutoListe.add(this.AutoFeld(Autos, i, i));
					if (Auto.ausrichtung()==hochkantORLaengs.laengs) {						
						flag=true;
					}
				}
			}			
			if (Auto!=null&&flag)
				for (l=0;l<k;l++){
					if (Auto.FreiHinten()==Weg.Frei) 
						TippListe2.add(new Tipp(Auto,false));					
					Auto.setZurueck();
				}
			
			flag=false;
			k=0;
			Auto=null;
			for (i=(byte)(t.getAuto().getX());i>=0;i--) {
				k++;		
				Auto=this.AutoFeld(Autos, i, (byte)(t.getAuto().laenge()+t.getAuto().getY()));
				if (!flag&&Auto!=null) {	
					if (Auto.ausrichtung()==hochkantORLaengs.laengs) {						
						flag=true;
					}
				}
			}
			if (Auto!=null&&flag)
				for (l=0;l<k;l++){
					if (Auto.FreiVorn()==Weg.Frei) 
						TippListe2.add(new Tipp(Auto,true));
					Auto.setVor();
				}
			flag=false;
			k=0;
			Auto=null;
			for (i=(byte)(t.getAuto().getX());i>=0;i--) {
				k++;		
				Auto=this.AutoFeld(Autos, i, (byte)(t.getAuto().getY()-1));
				if (!flag&&Auto!=null&&t.getAuto().getY()>0) {					
					//EineAutoListe.add(this.AutoFeld(Autos, i, i));
					if (Auto.ausrichtung()==hochkantORLaengs.laengs) {
						flag=true;
					}
				}
			}
			if (Auto!=null&&flag)
				for (l=0;l<k;l++){
					if (Auto.FreiVorn()==Weg.Frei) 
						TippListe2.add(new Tipp(Auto,true));
					Auto.setVor();
				}
			flag=false;
			k=0;
			Auto=null;
			for (i=(byte)(t.getAuto().getX());i<6;i++) {
				k++;		
				Auto=this.AutoFeld(Autos, i, (byte)(t.getAuto().getY()-1));
				if (!flag&&Auto!=null&&t.getAuto().getY()>0) {					
					//EineAutoListe.add(this.AutoFeld(Autos, i, i));
					if (Auto.ausrichtung()==hochkantORLaengs.laengs) {
						flag=true;
					}
				}
			}
			if (Auto!=null&&flag)
				for (l=0;l<k;l++){
					if (Auto.FreiHinten()==Weg.Frei) 
						TippListe2.add(new Tipp(Auto,false));
					Auto.setZurueck();
				}
			
		}
		//JOptionPane.showMessageDialog(null, autoliste1.size());
		//Autos_Sicherung=Autos.clone();
		 
	}
	*/
	/*
	public void Loesungsweg()  {
		BaumKnoten Start;
		LinkedList<Auto> Autozwischenliste;
		Start=new BaumKnoten(null,null,this.CloneAutoList(Autos),null);
		List<BaumKnoten> mglk=this.finde_Moeglichkeiten_der_Autobewegung(Autos,Start);
		List<List<BaumKnoten>> Zeile;
		for (BaumKnoten k: mglk) {
			if (k.MoeglichkeitAusgefuehrtFuerUnterKnoten!=null) {
				if (k.MoeglichkeitAusgefuehrtFuerUnterKnoten.vor)
					k.MoeglichkeitAusgefuehrtFuerUnterKnoten.Auto.setVor();
				else
					k.MoeglichkeitAusgefuehrtFuerUnterKnoten.Auto.setZurueck();
			}
			Autozwischenliste=CloneAutoList(k.Autos);
			k.Unterknoten=this.finde_Moeglichkeiten_der_Autobewegung(Autozwischenliste,k);
		}
		
	}
	
	private boolean AutoImWeg(AutoList a,byte x,byte y) {
		boolean flag=true;
		for (Auto b:a) 
			if (b.istDiesesAuto(x, y))
				flag=false;
		if (flag)
			return false;
		else
			return true;
	}
	*/
	public static Auto AutoFeld(AutoList a,byte x,byte y) {		
		for (Auto b:a) 
			if (b.istDiesesAuto(x, y))
				return b;
		return null;
	}
	public static void AutoFeld2(AutoList a) {
		for (int i=0;i<6;i++) {
			for (int k=0;k<6;k++) {
				System.out.print(AutoFeld(a,(byte)k,(byte)i)==null?"-":"x");
			}
			System.out.println();
		}
	}

	/*
	private List<BaumKnoten> finde_Moeglichkeiten_der_Autobewegung(LinkedList<Auto> Autos,BaumKnoten v) {
		List<BaumKnoten> moegl=new LinkedList<BaumKnoten>();
		for (Auto a:Autos) {
			if (a.FreiVorn()==Weg.Frei)
			if (AutoImWeg(Autos,a.getX(),a.getY()))
				moegl.add(new BaumKnoten(new MoeglichkeitAuto(a,true),null,Autos,v));				
			if (a.FreiHinten()==Weg.Frei)				
				moegl.add(new BaumKnoten(new MoeglichkeitAuto(a,false),null,Autos,v));
				
		}
		return moegl;
	}
	*/
	/*
	public List<Auto> CloneAutoList(List<Auto> Autos) {
		List<Auto> b=new AutoSet();
		for (Auto a:Autos) {
			b.add(a.clone());
		}
		return b;
	}*/
	/*
	public void spielfeldZurueckSetzen() {
		throw new UnsupportedOperationException();
	}

	public boolean hatGewonnen() {
		throw new UnsupportedOperationException();
	}

	public void bewegeAuto(Object aAuto, int[] aPositionNeu) {
		throw new UnsupportedOperationException();
	}

	public boolean isFreiZugaenglich(int[] aPositionVon, int[] aPositionNach) {
		throw new UnsupportedOperationException();
	}
	*/
}
