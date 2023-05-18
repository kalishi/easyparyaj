/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author abdue
 */
public class PariageModel {
    private String Code_Pariage;
    private LocalDate Date_Pariage;
    private String Scrore_pevu;
    private Double Montant_mise;
    private Double Solde_fiche;
    private String Id_C;
    private String Id_R;

    public PariageModel() {
    }

    public PariageModel(String Code_Pariage, LocalDate Date_Pariage, String Scrore_pevu, Double Montant_mise, Double Solde_fiche, String Id_C, String Id_R) {
        this.Code_Pariage = Code_Pariage;
        this.Date_Pariage = Date_Pariage;
        this.Scrore_pevu = Scrore_pevu;
        this.Montant_mise = Montant_mise;
        this.Solde_fiche = Solde_fiche;
        this.Id_C = Id_C;
        this.Id_R = Id_R;
    }

    public String getCode_Pariage() {
        return Code_Pariage;
    }

    public LocalDate getDate_Pariage() {
        return Date_Pariage;
    }

    public String getScrore_pevu() {
        return Scrore_pevu;
    }

    public Double getMontant_mise() {
        return Montant_mise;
    }

    public Double getSolde_fiche() {
        return Solde_fiche;
    }

    public String getId_C() {
        return Id_C;
    }

    public String getId_R() {
        return Id_R;
    }

    public void setCode_Pariage(String Code_Pariage) {
        this.Code_Pariage = Code_Pariage;
    }

    public void setDate_Pariage(LocalDate Date_Pariage) {
        this.Date_Pariage = Date_Pariage;
    }

    public void setScrore_pevu(String Scrore_pevu) {
        this.Scrore_pevu = Scrore_pevu;
    }

    public void setMontant_mise(Double Montant_mise) {
        this.Montant_mise = Montant_mise;
    }

    public void setSolde_fiche(Double Solde_fiche) {
        this.Solde_fiche = Solde_fiche;
    }

    public void setId_C(String Id_C) {
        this.Id_C = Id_C;
    }

    public void setId_R(String Id_R) {
        this.Id_R = Id_R;
    }

    @Override
    public String toString() {
        return "PariageModel{" + "Code_Pariage=" + Code_Pariage + ", Date_Pariage=" + Date_Pariage + ", Scrore_pevu=" + Scrore_pevu + ", Montant_mise=" + Montant_mise + ", Solde_fiche=" + Solde_fiche + ", Id_C=" + Id_C + ", Id_R=" + Id_R + '}';
    }
    
}
