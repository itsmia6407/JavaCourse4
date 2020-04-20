
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	private int indexOf(String[] words, String target, int start){
	   for(int k= start; k<words.length; k++){ 
	    if(words[k].equals(target)){
	        return k;
	       }
	   } 
	   return -1;
	   }
	   
	public void testIndexOf(){
	   String[] st ={"this", "is", "just", "a", "test" ,"yes", "this",
	       "is", "a", "simple", "test"}; 
	   System.out.println(indexOf(st,"this",0)); 
	   System.out.println(indexOf(st,"this",3)); 
	   System.out.println(indexOf(st,"frog",0));
	   System.out.println(indexOf(st,"frog",5));
	   System.out.println(indexOf(st,"simple",2));
	   System.out.println(indexOf(st,"test",5));
	   }
	   
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		System.out.println("key is "+key);
		System.out.println(" follow by # " + getFollows(key));
		
		return sb.toString().trim();
	}
	
	private ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
	 /*   int pos = 0;
	    while (pos<key.length()){
	        int start = indexOf(myText,key,pos);
	        if(start == -1){
	            break;}
	        String next = myText [ start + 1];
	        follows.add(next);
	        pos = start+key.length();
	   
    }*/
    int start = 0;
        for (int k=0; k<myText.length-1; k++){
            int index = indexOf(myText, key, start);
            if (index == -1 || index >= myText.length-1) {
                return follows;
            }
            follows.add(myText[index+1]);
            start = index + 1;
        }
   return follows;
  }
  
  
}