package logic;

public interface IPromoCodeLogic {

	/**
	 * erstellt und speichert einen neuen Promotioncode
	 * @return ein einzigartiger und gespeicherter Promocode
	 */
	String getNewPromoCode();
	
	/**
	 * erstellt einen neuen Promocode
	 * @return Promocode
	 */
	String generatePromoCode();
	
	/**
	 * speichert den neuen Promocode in der Datenhaltung, solange er nicht schon vorhanden ist
	 * und versucht es so lange neu, bis es geklappt hat
	 * @param code Promocode
	 * @return true wenn erfolgreich erstellt und gespeichert
	 */
	boolean savePromoCode(String code);
	
}
