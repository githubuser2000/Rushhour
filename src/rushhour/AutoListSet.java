package rushhour;

import java.awt.List;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


public class AutoListSet extends TreeSet<AutoList> implements  Cloneable, Comparable<AutoListSet>{

    /**
     * 
     */
    private static final long serialVersionUID = -7159561016720913066L;
    public AutoListSet() {
        super();
        
        // TODO Auto-generated constructor stub    	
    }
    public AutoListSet clone() {
        AutoListSet neu=new AutoListSet();
        
        for (AutoList list : this) {
            neu.add(list.clone());
        }
        return neu;
    }
    /*
    private long goedelCalculate() {
        int i=0;
        long goedelnumber=1;
        for (AutoList list : this) {            
            goedelnumber*=(long)Math.round(Math.pow(list.getGoedelNumber(), AutoList.primes[i]));
            i++;
        }
        return goedelnumber;
    }*/
    
    private BigInteger GetcompareNumberAndCalculate() {

    	 
        final BigInteger diffnumber=BigInteger.valueOf(288).pow(15);
        BigInteger compareNumber_=BigInteger.valueOf(1);
        //System.out.println();
        AutoListSet autolistset=this.clone();
        /*
        System.out.println(ar+(diffnumber*(b+diffnumber*(c+(diffnumber*d)))));
        
        BigInteger zwischenwert=BigInteger.valueOf(1);
        */
        Set<BigInteger> compareNumbersAutoListSet = new TreeSet();	        
        for (AutoList autolist : autolistset) {
        	compareNumbersAutoListSet.add(autolist.getCompareNumber());
            //goedelnumber_=goedelnumber_.multiply(auto.getCompareNumber().pow(this.primes[i]));
            //goedelnumber_=goedelnumber_.multiply(list.getGoedelNumber().pow(list.primes[i]));
            
        }
        int i=0;
        for (BigInteger number : compareNumbersAutoListSet) {
        	compareNumber_=compareNumber_.add(number.multiply(diffnumber.pow(i)));
            //goedelnumber_=goedelnumber_.multiply(auto.getCompareNumber().pow(this.primes[i]));
            //goedelnumber_=goedelnumber_.multiply(list.getGoedelNumber().pow(list.primes[i]));
            i++;
        }
        
        //System.out.println("Gödel AutoS BIGINT: "+goedelnumber_);	        
        return  compareNumber_;
        //this.goedelnumber = Math.round(Math.random()*100000000);
 //   }
}
    @Override
    public int compareTo(AutoListSet o) {
        // TODO Auto-generated method stub   
        //System.out.println(a-b);
        return  GetcompareNumberAndCalculate().compareTo(((AutoListSet) o).GetcompareNumberAndCalculate()); 
    }
    
    @Override
    public boolean equals(Object o) {
        //System.out.println("eq");
        if (compareTo((AutoListSet)o)!=0)
            return false;
        else
            return true;
        
    }

}
