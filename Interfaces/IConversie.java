package A2026_J15.Interfaces;

public interface IConversie {
    
    String converti(String input, String from, String to) throws Exception;

    String[] getOptiuni();

    Object getFormatter();
    
}