/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author abdue
 */
public class PaiementModel {
    private String idPaiement;
    private Date date_Paiement;
    private Double Montant;
    private String id_Pariage;
    private String id_Compte;
    private String Nom;
    private String Prenom;
    public PaiementModel() {
    }

    public PaiementModel(String idPaiement, Double Montant,String Nom, String Prenom) {
        this.idPaiement = idPaiement;
        this.Montant = Montant;
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public Date getDate_Paiement() {
        return date_Paiement;
    }

    public Double getMontant() {
        return Montant;
    }

    public String getId_Pariage() {
        return id_Pariage;
    }

    public String getId_Compte() {
        return id_Compte;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public void setDate_Paiement(Date date_Paiement) {
        this.date_Paiement = date_Paiement;
    }

    public void setMontant(Double Montant) {
        this.Montant = Montant;
    }

    public void setId_Pariage(String id_Pariage) {
        this.id_Pariage = id_Pariage;
    }

    public void setId_Compte(String id_Compte) {
        this.id_Compte = id_Compte;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    @Override
    public String toString() {
        return "PaiementModel{" + "idPaiement=" + idPaiement + ", date_Paiement=" + date_Paiement + ", Montant=" + Montant + ", id_Pariage=" + id_Pariage + ", id_Compte=" + id_Compte + ", Nom=" + Nom + ", Prenom=" + Prenom + '}';
    }

  
    
    
}
