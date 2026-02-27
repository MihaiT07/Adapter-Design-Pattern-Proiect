package A2026_J15.Adapters;

import A2026_J15.AdaptedClasses.CalculBaze;
import A2026_J15.Interfaces.IConversie;

public class AdapterBaze implements IConversie {

    private CalculBaze calculBaze;
    
    public AdapterBaze() {
        this.calculBaze = new CalculBaze();
    }
    
    public String converti(String input, String from, String to) throws Exception {
       
        String rezultat = calculBaze.convertesteBaza(input, from, to);
        
        return rezultat;
    }

    public String[] getOptiuni() {
        return calculBaze.getBazeDisponibile();
    }

    public Object getFormatter() {
        return null;
    }
}