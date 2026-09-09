package data;

public class PromoCodeDataStub implements IPromoCodeData {

	@Override
	public boolean savePromoCode(String code) {
		return true;
	}

	@Override
	public boolean isPromoCode(String code) {
		return false;
	}

}
