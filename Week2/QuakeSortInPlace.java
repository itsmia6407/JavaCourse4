
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
    int maxIdx = from;
    for(int i = from +1; i< quakeData.size(); i++){
        if(quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()){
            maxIdx = i;
        }
    }
    return maxIdx;
    
    }
    
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
    //modify here in.sizs() = 70
        for(int i =0; i<70 ; i++){    
    int maxIdx = getLargestDepth(in,i);
    QuakeEntry qi = in.get(i);
    QuakeEntry qMax = in.get(maxIdx);    
    in.set(i,qMax);
    in.set(maxIdx,qi);
     System.out.println("Pass #: " + i);  
    } 
  }
  
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted) {
        System.out.println("Pass #:"+ numSorted);
        for(int i=0, j=1; j<quakeData.size(); i++, j++) {
            QuakeEntry first = quakeData.get(i);
            QuakeEntry second = quakeData.get(j);
            if(second.getMagnitude() < first.getMagnitude()) {
                quakeData.set(i, second);
                quakeData.set(j, first);
            }
        }
    }
     
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
    	//onePassBubbleSort(list, list.size()-1);
    	//checkInSortedOrder(list);
    	for(int i=1; i<in.size(); i++) {
            onePassBubbleSort(in, i);
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes) {
        
        for(int i=0, j=1; j<quakes.size(); i++, j++) {
            QuakeEntry first = quakes.get(i);
            QuakeEntry second = quakes.get(j);
            if(second.getMagnitude() < first.getMagnitude()) {
               return false;
            }
        }
        return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in) {
        for(int i=1; i<in.size(); i++) {
            if(checkInSortedOrder(in)) {
                break;
            }
            onePassBubbleSort(in, i);
        }
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
        //just modify here !!! in.size() = 70
        for (int i=0; i< in.size(); i++) {
            if(checkInSortedOrder(in)) {
                break;
            }
            System.out.println("Pass #: "+ i);
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "data/earthquakeDataSampleSix2.atom";
        //String source = "data/earthQuakeDataDec6sample2.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        // sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithCheck(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
