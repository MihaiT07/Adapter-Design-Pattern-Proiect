package A2026_J15.AdaptedClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import A2026_J15.Exceptii.ExceptieBiti;

public class CalculCapacitate {
    
    private DecimalFormat df = new DecimalFormat("###,###.#####");
    
    public String calculeazaMemorie(double valoare, String unitateSursa, String unitateDestinatie) throws ExceptieBiti {

        if (unitateSursa.equals("b") && valoare != Math.floor(valoare)) {
            throw new ExceptieBiti();
        }
        
        int powerSursa = obtinePutere(unitateSursa);
        int powerDest = obtinePutere(unitateDestinatie);
        int diferentaPutere = powerDest - powerSursa;
        
        double rezultat = valoare / Math.pow(1024, diferentaPutere);
        
        BigDecimal bd = new BigDecimal(rezultat);
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        
        double diferenta = bd.doubleValue() - bd.intValue();
        if (diferenta == 0) {
            bd = bd.setScale(0);
        }
        
        return df.format(bd);
    }
    
    public String[] getUnitatiMemorie() {
        return new String[]{"b", "Kb", "Mb", "Gb", "Tb"};
    }
    
    private int obtinePutere(String unitate) {
        switch (unitate) {
            case "b": return 0;
            case "Kb": return 1;
            case "Mb": return 2;
            case "Gb": return 3;
            case "Tb": return 4;
            default: return 0;
        }
    }
}