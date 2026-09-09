package data;

import java.util.LinkedList;
import java.util.List;

public class PromoCodeData implements IPromoCodeData {

	private List<String> promocodes;
	
	public PromoCodeData(){
		this.promocodes = new LinkedList<String>();
	}
	
	@Override
	public boolean savePromoCode(String code) {
		return this.promocodes.add(code);
	}

	@Override
	public boolean isPromoCode(String code) {
		return this.promocodes.contains(code);
	}

}
