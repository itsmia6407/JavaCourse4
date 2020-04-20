import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        /*Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } */
        
       /* Filter mf = new MagnitudeFilter(4.0,5.0);
        Filter df = new DepthFilter(-35000.0,-12000.0);
        for(QuakeEntry qe : list){
            if(mf.satisfies(qe) && df.satisfies(qe)){
                
                    System.out.println(qe);
                }
    }*/
    
      //  Location Japan = new Location(35.42,139.43);
       
       
        
       /* Filter f3 = new DistanceFilter(tokyo,10000000);
        Filter f4 = new PhraseFilter("end","Japan");
        
        ArrayList<QuakeEntry> test2 = filter(list,f3 );
       test2 = filter(test2, f4);
        
        for (QuakeEntry qe: test2) { 
            System.out.println(qe);
        }*/
         
        
      /*  Filter f = new DistanceFilter(Japan,  10000000.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        Filter f5 = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> m5  = filter(m7, f5);*/
        
       /* Location Tokyo  = new Location(35.42, 139.43);
        
        Filter f = new DistanceFilter(Tokyo,  10000000.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        Filter f5 = new PhraseFilter("end", "Japan");
       ArrayList<QuakeEntry> m5  = filter(m7, f5);
        System.out.println(m5.size());*/
        
        /*Filter f = new MagnitudeFilter(4,5);
        ArrayList<QuakeEntry> m7 = filter(list,f);
        Filter f1 = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> m5 = filter(m7,f1);
        System.out.println(m5.size());*/
        
       /* Location denver = new Location(39.7392, -104.9903);
        Filter f = new DistanceFilter(denver, 1000000);
        ArrayList<QuakeEntry> m7 = filter(list,f);
        Filter f1 = new PhraseFilter("end","a");
         ArrayList<QuakeEntry> m5 = filter(m7,f1);
        System.out.println(m5.size());*/
        
        Filter f = new MagnitudeFilter(3.5,4.5);
        ArrayList<QuakeEntry> m7 = filter(list,f);
        Filter f1 = new DepthFilter(-55000.0,-20000.0);
        ArrayList<QuakeEntry> m5 = filter(m7,f1);
        System.out.println(m5.size());
      //  for (QuakeEntry qe: m5) { 
     //       System.out.println(qe);
       // } 
        
}

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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

    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        /*MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0,2));
        maf.addFilter(new DepthFilter(-100000.0, -10000.0));
        maf.addFilter(new PhraseFilter("any","a"));*/
        
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1,4));
        maf.addFilter(new DepthFilter(-180000.0, -30000.0));
        maf.addFilter(new PhraseFilter("any","o"));
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        System.out.println(quakes.size());
        //for(QuakeEntry qe : quakes){
          //  System.out.println(qe);
       //}
       //System.out.println("Filters used are :"+maf.getName());
    }
    
    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        /*MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter( new MagnitudeFilter(0,3));
        
        Location Tusla = new Location(36.1314, -95.9372);
        maf.addFilter( new DistanceFilter(Tusla,  10000000.0));
        maf.addFilter( new PhraseFilter("any", "Ca"));*/
        
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter( new MagnitudeFilter(0,5));
        
        Location Billund = new Location(55.7308, 9.1153);
        maf.addFilter( new DistanceFilter(Billund,  3000000.0));
        maf.addFilter( new PhraseFilter("any", "e"));
        
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        System.out.println(quakes.size());
        //for(QuakeEntry qe : quakes){
         //   System.out.println(qe);
        //}
    }
    
    public void quakesOfDepth(){
      EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
  
        Filter f = new DepthFilter(-12000.0, -10000.0);
        ArrayList<QuakeEntry> m7 = filter(list,f);
        System.out.println(m7.size());
        
        Filter f1 = new DepthFilter(-4000.0, -2000.0);
        ArrayList<QuakeEntry> m8 = filter(list,f1);
        System.out.println(m8.size());
        
    }
    
    
    public void quakesByPhrase(){
      EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
  
        Filter f = new PhraseFilter("start", "Quarry Blast");
        ArrayList<QuakeEntry> m7 = filter(list,f);
        System.out.println(m7.size());
        
        Filter f1 = new PhraseFilter("end", "Alaska");
        ArrayList<QuakeEntry> m8 = filter(list,f1);
        System.out.println(m8.size());
        
        Filter f2 = new PhraseFilter("any", "Can");
        ArrayList<QuakeEntry> m9 = filter(list,f2);
        System.out.println(m9.size());
}

}
