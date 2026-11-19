package de.promocode.logic;

public class CodeSearch {

	public static int NOT_FOUND = -1;

	/**
	 * Sucht einen Code in der Liste.
	 * 
	 * @param list        Liste der Codes im Long-Format
	 * @param searchValue Gesuchter Code
	 * @return Index des Codes, wenn er vorhanden ist, NOT_FOUND wenn er nicht
	 *         gefunden werden konnte
	 */
	public static long findPromoCode(long[] list, long searchValue) {
		
		long klein = 0;
		long groﬂ = list.length -1;
		
		while (klein <= groﬂ) {
			
			if (groﬂ < klein)
				return -1;

			long mid = (klein + groﬂ) / 2; 
			
			if (searchValue == mid) {
				return mid;  
			}
			
			if (list[(int) mid] <searchValue) {
				klein = mid - 1;
			} else {
				groﬂ = mid + 1;
			}

		}
		return NOT_FOUND;
	}
}
