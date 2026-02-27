package A2026_J15.Adapters;

import java.text.DecimalFormat;
import javax.swing.text.NumberFormatter;

import A2026_J15.AdaptedClasses.CalculCapacitate;
import A2026_J15.Interfaces.IConversie;

public class AdapterCapacitate implements IConversie {

	private CalculCapacitate calculCapacitate;

	private DecimalFormat df = new DecimalFormat("###,###.#####");
	private NumberFormatter nff = new NumberFormatter(df);

	public AdapterCapacitate() {
		this.calculCapacitate = new CalculCapacitate();
	}

	public String converti(String input, String from, String to) throws Exception {

		double valoare = Double.valueOf(input.replaceAll(",", ""));

		String rezultat = calculCapacitate.calculeazaMemorie(valoare, from, to);

		return rezultat;
	}

	public String[] getOptiuni() {
		return calculCapacitate.getUnitatiMemorie();
	}

	public Object getFormatter() {

		return nff;

	}

}