
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DepthFilter implements Filter {
   private double min;
   private double max;
   
   public DepthFilter (double minDept, double maxDept){
     min = minDept;
     max = maxDept;
       
    }
    
   public boolean satisfies (QuakeEntry qe){
     return qe.getDepth() > min && qe.getDepth() <max;  
       
    }
    
    public String getName(){
     return "DepthFilter";   
      }
}
