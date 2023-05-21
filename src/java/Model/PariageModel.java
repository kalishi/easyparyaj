/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.MatcheDao;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdue
 */
public class PariageModel {
    private String Code_Pariage;
    private Date Date_Pariage;
    private String Scrore_pevu;
    private Double Montant_mise;
    private Double Solde_fiche;
    private String Id_C;
    private String Id_R;
//    private String Nom;
//    private String Prenom;

    public PariageModel() {
    }

    public PariageModel(Date Date_Pariage, String Scrore_pevu, Double Montant_mise, String Id_R,String Id_C ) {
        this.Date_Pariage = Date_Pariage;
        this.Scrore_pevu = Scrore_pevu;
        this.Montant_mise = Montant_mise;
        this.Id_R = Id_R;   
        this.Id_C = Id_C;

//        this.Nom = Nom;
//        this.Prenom = Prenom;
    }

    public String getCode_Pariage() {
        return Code_Pariage;
    }

    public Date getDate_Pariage() {
        return Date_Pariage;
    }

    public String getScrore_pevu() {
        return Scrore_pevu;
    }

    public Double getMontant_mise() {
        return Montant_mise;
    }

    public String getId_C() {
        return Id_C;
    }

    public String getId_R() {
        return Id_R;
    }

//    public String getNom() {
//        return Nom;
//    }
//
//    public String getPrenom() {
//        return Prenom;
//    }

    public void setCode_Pariage(String Code_Pariage) {
        this.Code_Pariage = Code_Pariage;
    }

    public void setDate_Pariage(Date Date_Pariage) {
        this.Date_Pariage = Date_Pariage;
    }

    public void setScrore_pevu(String Scrore_pevu) {
        this.Scrore_pevu = Scrore_pevu;
    }

    public void setMontant_mise(Double Montant_mise) {
        this.Montant_mise = Montant_mise;
    }


    public void setId_C(String Id_C) {
        this.Id_C = Id_C;
    }

    public void setId_R(String Id_R) {
        this.Id_R = Id_R;
    }
    

   

     public double getCoteMatch(){
        try {
            Matche m = new MatcheDao().rechercher(this.Id_R);
            return m.getCote();
        } catch (SQLException ex) {
            Logger.getLogger(PariageModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PariageModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
     }
     
    public double getSolde_fiche() {
       return getCoteMatch()*Montant_mise;
    }
//    public void setNom(String Nom) {
//        this.Nom = Nom;
//    }
//
//    public void setPrenom(String Prenom) {
//        this.Prenom = Prenom;
//    }

    
    
   

}