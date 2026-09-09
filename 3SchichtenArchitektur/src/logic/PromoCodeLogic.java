/**
 * 
 */
package logic;

import java.util.Random;

import data.IPromoCodeData;

/**
 * @author Tim Tenbusch
 * @version 1.0 vom 07.10.2015
 */
public class PromoCodeLogic implements IPromoCodeLogic {

	IPromoCodeData data;

	public PromoCodeLogic(IPromoCodeData data) {
		this.data = data;
	}

	@Override
	public String getNewPromoCode() {
		return tryToValidatePromoCode(insertHyphen(generatePromoCode()));
	}

	private String tryToValidatePromoCode(String code) {
		final int MAXVERSUCHE = 3;
		int versuche = 0;
		do {
			if (savePromoCode(code))
				return code;
			else
				versuche++;
		} while (versuche < MAXVERSUCHE);
		return "Leider ist ein Fehler aufgetreten :(";
	}

	@Override
	public String generatePromoCode() {
		Random rand = new Random();
		String code = "";
		for (int i = 0; i < 20; i++)
			// Generiert einen Großbuchstaben
			code += (char) (rand.nextInt(24) + 65);
		return code;
	}

	/**
	 * fügt Bindestriche alle 5 Buchstaben ein
	 */
	public String insertHyphen(String code) {
		StringBuffer newCode = new StringBuffer();
		for (int i = 0; (i + 4) < code.length(); i += 5) {
			newCode.append(code.substring(i, i + 5));
			newCode.append('-');
		}
		newCode.deleteCharAt(newCode.length() - 1);
		return newCode.toString();
	}

	@Override
	public boolean savePromoCode(String code) {
		// Promocode schon vorhanden
		if (data.isPromoCode(code))
			return false;
		// speichere Promocode in Datenhaltung
		return data.savePromoCode(code);
	}

}
