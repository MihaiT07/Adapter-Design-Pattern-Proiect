package A2026_J15.AdaptedClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CalculValutar {
    
    private DecimalFormat df = new DecimalFormat("###,###.##");

    private static final Map<String, Double> CURS_VALUTAR = new HashMap<>();
    
    static {
        CURS_VALUTAR.put("Lei", 1.0);
        CURS_VALUTAR.put("Euro", 5.09);
        CURS_VALUTAR.put("Dolari", 4.35);
        CURS_VALUTAR.put("Lire Sterline", 5.87);
        CURS_VALUTAR.put("Franci Elvetieni", 5.48);
    }
    
    public String efectueazaSchimb(double suma, String valutaSursa, String valutaDestinatie) {
        
        if (valutaSursa.equals(valutaDestinatie)) {
            return df.format(suma);
        }

        double sumaInLei = suma * CURS_VALUTAR.get(valutaSursa);

        double rezultat = sumaInLei / CURS_VALUTAR.get(valutaDestinatie);
        
        BigDecimal bd = new BigDecimal(rezultat);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        
        double diferenta = bd.doubleValue() - bd.intValue();
        if (diferenta == 0) {
            bd = bd.setScale(0);
        }
        
        return df.format(bd);
    }

    public String[] getValuteDisponibile() {
        return new String[]{"Lei", "Euro", "Dolari", "Lire Sterline", "Franci Elvetieni"};
    }
}