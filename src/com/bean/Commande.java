package com.bean;

public class Commande {
	private int idCommande;
	private int idClient;
	private String produit;
	private int nombre;
	private int prix;
	private String date;
	public Commande(int idCommande, int idClient, String produit, int nombre, int prix, String date) {
		super();
		this.idCommande = idCommande;
		this.idClient = idClient;
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
