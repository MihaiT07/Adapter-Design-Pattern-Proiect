package A2026_J15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import A2026_J15.Adapters.AdapterBaze;
import A2026_J15.Adapters.AdapterCapacitate;
import A2026_J15.Adapters.AdapterValutar;
import A2026_J15.Exceptii.ExceptieSelectieConversie;
import A2026_J15.Interfaces.IConversie;

public class Control {

    private GUI conv;
    private IConversie conversieAdapter;

    public Control(GUI calc) {
        this.conv = calc;
        evenimente();
    }

    void evenimente() {

        ActionListener a = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String opt = e.getActionCommand().toString();
                System.out.println(opt);

                switch (opt) {
                    case "Capacitate memorie": {
  
                        initializeazaConversie(new AdapterCapacitate());
                        break;
                        
                    }

                    case "Baze de numeratie": {
                    	
                        initializeazaConversie(new AdapterBaze());
                        break;
                        
                    }

                    case "Schimb valutar": {

                        initializeazaConversie(new AdapterValutar());
                        break;
                        
                    }

                    case "Start conversie": {
                        
                        if (conversieAdapter instanceof AdapterBaze) {
                            conv.getInput().setText(conv.getInput().getText().toUpperCase());
                        }
                        
                        try {
                        	
                            executaConversie();
                            
                        } catch (Exception e1) {
                        	
                            e1.printStackTrace();
                            conv.getInput().setText(e1.getMessage());
                            
                        }
                        
                        break;
                    }

                    default: {
                        throw new IllegalArgumentException("Unexpected value: " + opt);
                    }
                }
            }
        };

        conv.getmnitm1().addActionListener(a);
        conv.getmnitm2().addActionListener(a);
        conv.getmnitm3().addActionListener(a);
        conv.getBtn().addActionListener(a);
    }

    private void initializeazaConversie(IConversie adapter) {
    	
        this.conversieAdapter = adapter;
        
        conv.getselec1().removeAllItems();
        conv.getselec2().removeAllItems();

        String[] optiuni = adapter.getOptiuni();
        
        for (String opt : optiuni) {
        	
            conv.getselec1().addItem(opt);
            conv.getselec2().addItem(opt);
            
        }
        
        Object formatter = adapter.getFormatter();
        
        if (formatter != null && formatter instanceof NumberFormatter) {
        	
            conv.getInput().setFormatterFactory(new DefaultFormatterFactory((NumberFormatter) formatter));
            
        } else {
        	
            conv.getInput().setFormatterFactory(new DefaultFormatterFactory(null));
            
        }
    }

    void executaConversie() throws Exception {
        
        if (conversieAdapter == null) {
            throw new ExceptieSelectieConversie();
        }
        
        String opt1 = conv.getselec1().getSelectedItem().toString();
        String opt2 = conv.getselec2().getSelectedItem().toString();
        String input = conv.getInput().getText();
        
        System.out.println("Conversie: " + opt1 + " -> " + opt2);

        String rezultat = conversieAdapter.converti(input, opt1, opt2);
        
        conv.getRez().setText(rezultat);
    }
}