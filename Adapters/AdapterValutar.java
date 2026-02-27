package A2026_J15.Adapters;

import java.text.DecimalFormat;
import javax.swing.text.NumberFormatter;

import A2026_J15.AdaptedClasses.CalculValutar;
import A2026_J15.Interfaces.IConversie;

public class AdapterValutar implements IConversie {

    private CalculValutar calculValutar;
    
    private DecimalFormat df = new DecimalFormat("###,###.##");
    private NumberFormatter nff = new NumberFormatter(df);
    
    public AdapterValutar() {
        this.calculValutar = new CalculValutar();
    }

    public String converti(String input, String from, String to) throws Exception {

        double suma = Double.valueOf(input.replaceAll(",", ""));

        String rezultat = calculValutar.efectueazaSchimb(suma, from, to);
        
        return rezultat;
    }

    public String[] getOptiuni() {
        return calculValutar.getValuteDisponibile();
    }

    public Object getFormatter() {
        return nff;
    }
}