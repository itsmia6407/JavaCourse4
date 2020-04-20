import java.util.*;
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LargestQuakes {
public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        System.out.println("index of largest " + indexOfLargest(list));
        
        for(QuakeEntry qe : getLargest(list,20)){
            System.out.println(qe);
        }
}

public int indexOfLargest(ArrayList<QuakeEntry> data){
    int idx = 0;
    double magMax = 0.0;
    for(QuakeEntry qe : data){
           if (qe.getMagnitude() > magMax){
               magMax = qe.getMagnitude();
               idx = data.indexOf(qe);
            } 
         }
         return idx;
          }
          
public ArrayList<QuakeEntry> getLargest(ArrayList <QuakeEntry> quakeData, int howMany){
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(int i = 1; i <= howMany; i++){
                int ind = indexOfLargest(quakeData);
               answer.add(quakeData.get(ind));
               quakeData.remove(ind);
            }
        return answer;
         }
         
}
