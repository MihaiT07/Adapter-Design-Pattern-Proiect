package A2026_J15.AdaptedClasses;

import A2026_J15.Exceptii.ExceptieHexa;
import A2026_J15.Exceptii.ExceptieOctal;
import A2026_J15.Exceptii.ExceptieScriereBiti;

public class CalculBaze {
    
    public String convertesteBaza(String numar, String bazaSursa, String bazaDestinatie) 
            throws ExceptieScriereBiti, ExceptieOctal, ExceptieHexa {
        
        valideazaNumar(numar, bazaSursa);
        
        int valoareDecimala = convertesteLaBaza10(numar, bazaSursa);
        String rezultat = convertesteDinBaza10(valoareDecimala, bazaDestinatie);
        
        return rezultat;
    }

    public String[] getBazeDisponibile() {
        return new String[]{"Binar", "Octal", "Baza10", "Hexazecimal"};
    }
    
    private void valideazaNumar(String numar, String baza) 
            throws ExceptieScriereBiti, ExceptieOctal, ExceptieHexa {
        
        switch (baza) {
            case "Binar":
                if (!esteBinar(Long.valueOf(numar))) {
                    throw new ExceptieScriereBiti();
                }
                break;
            case "Octal":
                if (!esteOctal(Integer.valueOf(numar))) {
                    throw new ExceptieOctal();
                }
                break;
            case "Hexazecimal":
                if (!esteHexazecimal(numar)) {
                    throw new ExceptieHexa();
                }
                break;
        }
    }
    
    private int convertesteLaBaza10(String numar, String baza) {
        switch (baza) {
            case "Binar":
                return Integer.parseInt(numar, 2);
            case "Octal":
                return Integer.parseInt(numar, 8);
            case "Baza10":
                return Integer.valueOf(numar);
            case "Hexazecimal":
                return Integer.parseInt(numar, 16);
            default:
                return 0;
        }
    }
    
    private String convertesteDinBaza10(int decimal, String baza) {
        switch (baza) {
            case "Binar":
                return Integer.toBinaryString(decimal);
            case "Octal":
                return Integer.toOctalString(decimal);
            case "Baza10":
                return String.valueOf(decimal);
            case "Hexazecimal":
                return Integer.toHexString(decimal).toUpperCase();
            default:
                return "";
        }
    }
    
    private boolean esteBinar(long input) {
        while (input > 0) {
            long cifra = input % 10;
            if (cifra != 0 && cifra != 1) {
                return false;
            }
            input /= 10;
        }
        return true;
    }
    
    private boolean esteOctal(int input) {
        while (input > 0) {
            int cifra = input % 10;
            if (cifra > 7) {
                return false;
            }
            input /= 10;
        }
        return true;
    }
    
    private boolean esteHexazecimal(String input) {
        try {
            Integer.parseInt(input, 16);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}