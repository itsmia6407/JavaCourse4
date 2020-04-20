import java.util.*;
import edu.duke.*;

/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
public TitleLastAndMagnitudeComparator(){
    
}

public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        String title1 = qe1.getInfo();
        
        String title2 = qe2.getInfo(); 
        
        String lastw1 = title1.substring(title1.lastIndexOf(" ")+1);
        
        String lastw2 = title2.substring(title2.lastIndexOf(" ")+1);
        
        int comp = lastw1.compareTo(lastw2);
        
        if (comp == 0){
            
            return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
            
        }
        return comp;
    }

}
