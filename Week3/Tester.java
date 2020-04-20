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
        MarkovFour markov=new MarkovFour();
        FileResource fr=new FileResource();
        String st=fr.asString();
        st=st.replace('\n',' ');
        
        markov.setTraining(st);
        ArrayList<String> al=markov.getFollows("he");
        
        System.out.println(al);
        System.out.println(al.size());
    }
}
