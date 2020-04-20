import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
 
    
 public void testGetFollows() {
    MarkovOne mo = new MarkovOne();
    mo.setTraining("this is a test yes this is a test.");
    //mo.setTraining(st);
    ArrayList<String> r=mo.getFollows("t");
    //ArrayList<String> r=mo.getFollows("e");
    //ArrayList<String> r=mo.getFollows("es");
    //ArrayList<String> r=mo.getFollows(".");
    //ArrayList<String> r=mo.getFollows("t.");
    for (String s:r){
     System.out.print(s);
        }
    System.out.println();   
    System.out.println(" as key appears " + r.size() + " times");
}

public void testGetFollowsWithFile(){
    //change markov here also
        MarkovZero markov=new MarkovZero();
        FileResource fr=new FileResource();
        String st=fr.asString();
        st=st.replace('\n',' ');
        markov.setRandom(1024);
        markov.setTraining(st);
       // ArrayList<String> al=markov.getFollows("th");
        
        System.out.println(st);
       // System.out.println(al.size());
    }
}
