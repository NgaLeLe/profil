package com.logique.business;

public class CheckEmail implements ICheckEmail {
	private String email;

	public CheckEmail(String pEmail) {
		this.email = pEmail;
	}

	@Override
	public boolean isValide() {
		String iden = this.email.substring(0, this.email.indexOf('@'));
		String mail = this.email.substring(this.email.indexOf('@') + 1);
		if (!iden.isEmpty()) {
			if (mail.contains(".") && mail.indexOf(".") == mail.lastIndexOf(".") ) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
