public abstract class Mitglied {

	private String name;
	private String telefonnummer;
	private boolean jahresbeitrag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public boolean isJahresbeitrag() {
		return jahresbeitrag;
	}

	public void setJahresbeitrag(boolean jahresbeitrag) {
		this.jahresbeitrag = jahresbeitrag;
	}
}
