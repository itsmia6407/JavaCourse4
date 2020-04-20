
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 1; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markovWord = new MarkovWord(6); 
       int seed = 792;
       int size = 200;
        runModel(markovWord, st, size,seed); 
       
    } 
    
    public void MarkovWord(){
    FileResource fr = new FileResource();
    String st = fr.asString(); 
      st = st.replace('\n', ' ');
      MarkovWord mw = new MarkovWord(3);
      //mw.setRandom(643);
     // runModel (mw, st, 200);
        runModel(mw,st,200,643);
        
    }
    
    public void runMarkovTwo(){
        FileResource fr = new FileResource();
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordTwo markovWord = new MarkovWordTwo();
        int seed = 832;
        int size = 120;
        runModel(markovWord, st, size,seed);
        
    }
    
    public void testHashMap(){
       //String st = "this is a test yes this is really a test yes a test this is wow";
        
       FileResource fr = new FileResource();
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        int order = 6;
        EfficientMarkovWord efm = new EfficientMarkovWord(order);
        runModel(efm, st, 10, 792);
    }
    
    public void testGetFollows(){
        String st = "this is just a test yes this is a simple test";
        MarkovWordOne markovWord = new MarkovWordOne();
        runModel(markovWord, st, 200);
        /* For example, for the String above, the word “test” is followed by “yes”,
         * the word “is” is followed by “just” and “a”. */
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
