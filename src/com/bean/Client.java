package com.bean;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private int age;
	private String password;

	public Client(int idClient, String nom, String prenom, int age, String password) {
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.password = password;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
