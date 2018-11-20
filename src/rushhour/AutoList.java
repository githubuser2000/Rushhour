package rushhour;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class AutoList extends ArrayList<Auto> implements  Cloneable, Comparable<AutoList>    {
    private BigInteger compareNumber=BigInteger.valueOf(1);
    private boolean hasChangedCompareNumber=false;
    private boolean oldBacktracked=false;
    public static int vielfaeltigkeiten=0;
    private byte eiswagenNr;
    private Auto eiswagen;
    
    public void setOldBacktracked(boolean oldBacktracked) {
    	this.oldBacktracked=oldBacktracked;
    }
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean getoldBacktracked() {
		return oldBacktracked;
	}
    /*
	List<Auto> autos;
    public AutoSet() {
        // TODO Auto-generated constructor stub
        this.autos = new ArrayList<Auto>();
    }
    public List<Auto> getList() {
    	return autos;
    }
*/
    @Override
    public boolean add(Auto arg0) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        if (arg0.istEiswagen()) {
            this.eiswagenNr=(byte) this.size();
            this.eiswagen=arg0;
        }
        return super.add(arg0);
    }
    

    @Override
    public void add(int arg0, Auto arg1) {
        // TODO Auto-generated method stub
        //hasChangedCompareNumber=true;
        //super.add(arg0,arg1);
    }

    @Override
    public boolean addAll(Collection<? extends Auto> arg0) {
        // TODO Auto-generated method stub
        //hasChangedCompareNumber=true;
        //return super.addAll(arg0);
        return false;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends Auto> arg1) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.addAll(arg0,arg1);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        super.clear();
        
    }
/*
    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return autos.contains(arg0);
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return autos.containsAll(arg0);
    }

    @Override
    public Auto get(int arg0) {
        // TODO Auto-generated method stub
        return autos.get(arg0);
    }

    @Override
    public int indexOf(Object arg0) {
        // TODO Auto-generated method stub
        return autos.indexOf(arg0);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return autos.isEmpty();
    }

    @Override
    public Iterator<Auto> iterator() {
        // TODO Auto-generated method stub
        return autos.iterator();
    }

    @Override
    public int lastIndexOf(Object arg0) {
        // TODO Auto-generated method stub
        return autos.lastIndexOf(arg0);
    }

    @Override
    public ListIterator<Auto> listIterator() {
        // TODO Auto-generated method stub
        return autos.listIterator();
    }

    @Override
    public ListIterator<Auto> listIterator(int arg0) {
        // TODO Auto-generated method stub
        return autos.listIterator(arg0);
    }
*/
    @Override
    public boolean remove(Object arg0) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.remove(arg0);
    }

    @Override
    public Auto remove(int arg0) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.remove(arg0);
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.removeAll(arg0);
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.retainAll(arg0);
    }

    @Override
    public Auto set(int arg0, Auto arg1) {
        // TODO Auto-generated method stub
        hasChangedCompareNumber=true;
        return super.set(arg0, arg1);
    }
/*
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return autos.size();
    }

    @Override
    public List<Auto> subList(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return autos.subList(arg0,arg1);
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return autos.toArray();
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return autos.toArray(arg0);
    }

    @Override
    public int compareTo(AutoSet autolist) {
        // TODO Auto-generated method stub
    	int gleich=0;
    	for (int i=0;i<autos.size();i++) {
    		if (autolist.get(i).compareTo(autos.get(i))==0) {
    			gleich = -1;
    		}
    	}
        return gleich;
    }
    public AutoSet clone(AutoSet Autoliste) {
    	AutoSet neu=new AutoSet();
    	for (Auto auto : autos) {
    		Autoliste.add(auto.clone(Autoliste.getList()));
    	}
		return Autoliste;
    	
    }
*/
	@Override
	public AutoList clone() {
		AutoList neu= new AutoList();
		neu.oldBacktracked=this.oldBacktracked;
		neu.hasChangedCompareNumber=this.hasChangedCompareNumber;
		for (Auto auto : this) {
			//System.out.println("cl1 " +auto.Eigenschaften());
			//System.out.println("cl2 " +auto.clone().Eigenschaften());
			neu.add(auto.clone(neu));			
		}
		return neu;		
	}
	
	@Override	
	public boolean equals(Object o)  {
		//System.out.println("size "+this.size()+" = "+((AutoList) o).size());
		if (this.size()==((AutoList) o).size()) {
			if (this.containsAll((AutoList) o)){
				return true;
			}
		}		
		return false;
		
	}

	/*
	public static void main(String[] args) {
		AutoList a=new AutoList();
		a.add(new Auto(hochkantORLaengs.hochkant, (byte) 1,(byte) 1, (byte) 1,null,null));
		a.add(new Auto(hochkantORLaengs.hochkant, (byte)2,(byte) 2, (byte) 2,null,null));
		a.add(new Auto(hochkantORLaengs.hochkant, (byte)3,(byte) 3, (byte) 3,null,null));
		a.add(new Auto(hochkantORLaengs.hochkant, (byte)4,(byte) 4, (byte) 4,null,null));
		a.add(new Auto(hochkantORLaengs.hochkant, (byte)5,(byte) 5, (byte) 5,null,null));
		AutoList b=new AutoList();
		b.add(new Auto(hochkantORLaengs.hochkant, (byte)1,(byte) 1, (byte) 1,null,null));
		b.add(new Auto(hochkantORLaengs.hochkant, (byte)2,(byte) 2, (byte) 2,null,null));
		b.add(new Auto(hochkantORLaengs.hochkant, (byte)3,(byte) 3, (byte) 3,null,null));
		b.add(new Auto(hochkantORLaengs.hochkant, (byte)4,(byte) 4, (byte) 4,null,null));
		b.add(new Auto(hochkantORLaengs.hochkant, (byte)5,(byte) 5, (byte) 5,null,null));		
		//System.out.println("size "+b.size());
		//System.out.println();
		//b.add(new Auto(hochkantORLaengs.hochkant, (byte)1,(byte) 1, (byte) 1,null,null));
		//List<Integer> abc=new LinkedList<Integer>();
		//System.out.println(a.containsAll(a));
		//System.out.println(a.equals(b));
		

	}*/
	private void calculateCompareNumber() {
	   if (hasChangedCompareNumber) {
	        
	        final int diffnumber=288;
	        BigInteger compareNumber_=BigInteger.valueOf(1);
	        //System.out.println();
	        AutoList autoliste=this.clone();
	        /*
	        System.out.println(ar+(diffnumber*(b+diffnumber*(c+(diffnumber*d)))));
	        
	        BigInteger zwischenwert=BigInteger.valueOf(1);
	        */
	        Set<Integer> compareNumbersAuto = new TreeSet();	        
	        for (Auto auto : autoliste) {
	        	compareNumbersAuto.add(auto.getCompareNumber());
	            //goedelnumber_=goedelnumber_.multiply(auto.getCompareNumber().pow(this.primes[i]));
	            //goedelnumber_=goedelnumber_.multiply(list.getGoedelNumber().pow(list.primes[i]));
	            
	        }
	        //
	        // ACHTUNG Das SortedSet ist nötig um EinEindeutigkeiten aufzudecken!
	        //
	        int i=0;
	        for (Integer number : compareNumbersAuto) {
	        	compareNumber_=compareNumber_.add(BigInteger.valueOf(number).multiply(BigInteger.valueOf(diffnumber).pow(i)));
	            //goedelnumber_=goedelnumber_.multiply(auto.getCompareNumber().pow(this.primes[i]));
	            //goedelnumber_=goedelnumber_.multiply(list.getGoedelNumber().pow(list.primes[i]));
	            i++;
	        }
	        if (oldBacktracked)
	        	compareNumber_=compareNumber_.add(BigInteger.valueOf(1).multiply(BigInteger.valueOf(diffnumber).pow(i)));
	        i++;
	        if (hasChangedCompareNumber)
	        	compareNumber_=compareNumber_.add(BigInteger.valueOf(1).multiply(BigInteger.valueOf(diffnumber).pow(i)));
	        i++;
	        
	        //System.out.println("Gödel AutoS BIGINT: "+goedelnumber_);	        
	        this.compareNumber =  compareNumber_;
	        //this.goedelnumber = Math.round(Math.random()*100000000);
	    }
	   hasChangedCompareNumber=false;
	}
	public BigInteger getCompareNumber() {
	    calculateCompareNumber();
	    //if (this.goedelnumber==1)
	        //this.goedelCalculate();
	    //return goedelnumber;
	  
	    return this.compareNumber;
	}
	@Override
	public int compareTo(AutoList arg0) {
        // TODO Auto-generated method stub  
		//System.out.println("a "+ getGoedelNumber());
		//System.out.println("b "+ arg0.getGoedelNumber());
		return getCompareNumber().compareTo(arg0.getCompareNumber()); 
    }
/*
	public void getAutoPos() {
	    System.out.println("Autopositionen: ");
	    for (Auto auto: this ) {
	        System.out.println(auto.getX()+" "+auto.getY());
	    }
	}
*/
	public Auto getEiswagen() {
	    return this.eiswagen;
	}
	public boolean uebereinander(Auto auto1) {
	    for (byte x=0;x<Spielfeld.spielfeldgroesse;x++) {
	        for (byte y=0;y<Spielfeld.spielfeldgroesse;y++) {
	            Auto auto2 = Spielfeld.AutoFeld(this, x, y);
	            if (auto2!=null) {
	                if (auto1.getX()==x&&auto1.getY()==y) {
	                    return true;
	                }
	                if (auto1.getX()+1==x&&auto1.getY()==y&&auto1.ausrichtung()==hochkantORLaengs.laengs) {
	                    return true;
                    }
                    if (auto1.getX()==x&&auto1.getY()+1==y&&auto1.ausrichtung()==hochkantORLaengs.hochkant) {
                        return true;
                    }
                    if (auto1.getX()+2==x&&auto1.getY()==y&&auto1.ausrichtung()==hochkantORLaengs.laengs&&auto1.laenge()==3) {
                        return true;
                    }
                    if (auto1.getX()==x&&auto1.getY()+2==y&&auto1.ausrichtung()==hochkantORLaengs.hochkant&&auto1.laenge()==3) {
                        return true;
                    }
	            }
	        }
	    }
	    
	    return false;
	}
}
