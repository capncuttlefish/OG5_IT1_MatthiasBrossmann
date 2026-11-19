package listengenerator;

public class BinarySearch {
	
	public static int binaereSuche(int[] suche, int gesucht) {

		return binaereSuche(suche, 0, suche.length - 1, gesucht);
	}

	public static int binaereSuche(int[] array, int klein, int groß, int gesucht) {
		if (groß < klein)
			return -1;

		int mid = (klein + groß) >>> 1; //wenn antstatt (klein + groß) >>>1 (klein + groß) / 2 benutzen würde und die summe größer ist
		//als Integer.MAX_VALUE (höchster wert den ein int haben kann) würde ein negativer wert zurückgegeben werden
		int midVal = array[mid]; //mitte des arrays

		if (gesucht == midVal) {
			return mid;  // returned mittleren index des arrays wenn gesuchte zahl mitte ist
		} else if (gesucht < midVal) {
			return binaereSuche(array, klein, mid - 1, gesucht);   //sucht kleiner wenn gesuchte zahl kleiner als mittlerer index ist
		} else {
			return binaereSuche(array, mid + 1, groß, gesucht); //sucht größer wenn gesuchte zahl kleiner als mittlerer index ist
		}

	}
}
