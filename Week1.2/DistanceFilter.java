
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DistanceFilter implements Filter {
    private Location givenLocation;
    private double maxDistance; 
    
    public DistanceFilter(Location loc, double distance) { 
        givenLocation = loc;
        maxDistance = distance;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getLocation().distanceTo(givenLocation) < maxDistance); 
    } 
    
    public String getName(){
        return "DistanceFilter";
    }
}

