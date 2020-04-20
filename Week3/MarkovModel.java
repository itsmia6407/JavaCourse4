import java.util.*;
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel extends AbstractMarkovModel{
    private String myText;
    private Random myRandom;
    private int pass;
    
    private int numOfChar;
    private double timing;
    
    
    
    public MarkovModel(int passed) {
        myRandom = new Random();
        pass=passed;
        
        numOfChar = passed;
        timing = 0.0;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
      public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index, index+4);
        sb.append(key);
        
        for(int k=0; k < numChars-4; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }
    
    public double getTiming(){
        return timing/1000000000.0;
    }
    
    public String toString(){
        return "MarkovModel of order n("+numOfChar+").";
    }
}
