package logic;

public class PromoCodeLogicStub implements IPromoCodeLogic {

	@Override
	public String getNewPromoCode() {
		return "THERE-IS-NO-GOLD-FOR-YOU";
	}

	@Override
	public String generatePromoCode() {
		return null;
	}

	@Override
	public boolean savePromoCode(String code) {
		return false;
	}

}
