package com.bean;

public class Utilisateur {
	private String nom;
	private String email;
	private String password;
	private int age;
	private String adress;

	public Utilisateur(String nom, String email, String password) {
		this.nom = nom;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(String nom, String email, String password, int age, String adress) {
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.age = age;
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
