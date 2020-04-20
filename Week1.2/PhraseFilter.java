
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    private String typeOfRequest;
    private String phraseToSearch; 
    
    public PhraseFilter(String type, String phrase) { 
        typeOfRequest = type;
        phraseToSearch = phrase;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return ((typeOfRequest.equals("start") && qe.getInfo().startsWith(phraseToSearch))
                || (typeOfRequest.equals("end") && qe.getInfo().endsWith(phraseToSearch)) 
                || (typeOfRequest.equals("any") && qe.getInfo().contains(phraseToSearch)));
    } 
    
    public String getName(){
        return "PhraseFilter";
    }

}
