package start;

import gui.PromocodeGUI;
import gui.PromocodeTUI;
import logic.IPromoCodeLogic;
import logic.PromoCodeLogic;
import data.IPromoCodeData;
import data.PromoCodeData;

public class PromoCodeStart {

	public static void main(String[] args) {
		IPromoCodeData data = new PromoCodeData();
		IPromoCodeLogic logic = new PromoCodeLogic(data);

		new PromocodeTUI(logic);
		new PromocodeGUI(logic);
	
	}

}
