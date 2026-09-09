package data;

public interface IPromoCodeData {

	/**
	 * Speichert einen neuen Promocode in die Liste
	 * @param code - Promocode
	 * @return Meldung ob erfolgreich
	 */
	boolean savePromoCode(String code);
	
	/**
	 * gibt true zurück, wenn der Parameter in der Datenhaltung ist
	 * @param code - Promocode
	 * @return true wenn in Liste
	 */
	boolean isPromoCode(String code);
	
}
