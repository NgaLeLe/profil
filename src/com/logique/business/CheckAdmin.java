package com.logique.business;

public class CheckAdmin implements ICheckEmail {
	private String[] lsAdmin = { "anis@pop.fr", "imen@pop.com", "inga@yahoo.fr" };
	private String email;
	private String password;

	private boolean verifier(String pEmail, String pPassword) {
		String iden = pEmail.substring(0, pEmail.indexOf('@'));
		String mail = pEmail.substring(pEmail.indexOf('@') + 1);
		for (String string : lsAdmin) {
			String idenDB = string.substring(0, string.indexOf('@'));
			String mailDB = string.substring(string.indexOf('@') + 1);
			if (iden.contentEquals(idenDB) && mail.contentEquals(mailDB) && pPassword.contentEquals("admin")) {
				return true;
			}
		}
		return false;
	}

	public CheckAdmin(String pEmail, String pPassword) {
		this.email = pEmail;
		this.password = pPassword;
	}

	@Override
	public boolean isValide() {
		if (verifier(this.email, this.password))
			return true;
		else
			return false;
	}
public boolean isExist() {
	String iden = this.email.substring(0, this.email.indexOf('@'));
	String mail = this.email.substring(this.email.indexOf('@') + 1);
	for (String string : lsAdmin) {
		String idenDB = string.substring(0, string.indexOf('@'));
		String mailDB = string.substring(string.indexOf('@') + 1);
		if (iden.contentEquals(idenDB) && mail.contentEquals(mailDB) ) {
			return true;
		}
	}
	return false;

}
}
