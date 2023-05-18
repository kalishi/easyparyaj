/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PaiementModel;
import dbutils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaiementDao implements IServices<PaiementModel>{
       Connection con= null;
       PreparedStatement prepar=null;
       ResultSet rst=null;
       
    @Override
    public PaiementModel rechercher(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaiementModel> lister() throws ClassNotFoundException, SQLException {
        String Code_Paiement;
        Date Date_Paiement;
        Double Montant;
        String Nom;
        String idC;
        String Prenom;
        ArrayList<PaiementModel> ar = new ArrayList<>();
        //Construction de la requette
        String req = "SELECT Paiement.Code_Paiement, Paiement.Date_Paiement, Paiement.Montant,Compte.Nom, Compte.Prenom FROM Paiement INNER JOIN Compte ON Paiement.Id_C = code_C";
        //recuperation de la connexion a la base
         con= DBUtils.connect();
         // Passage de la requette a la Prepare
         prepar= con.prepareStatement(req);
         //Executer la requette
         rst= prepar.executeQuery();
         
         //Maintenant on va parcourir la resultset 
         while(rst.next()){
             Code_Paiement= rst.getString("Code_Paiement");
             Date_Paiement= rst.getDate("Date_Paiement");
             Montant= rst.getDouble("Montant");
             Nom= rst.getString("Nom");   
//             idC= rst.getString("Id_C");
             Prenom= rst.getString("Prenom");
             PaiementModel pm= new PaiementModel(Code_Paiement,Montant,Nom,Prenom);
             pm.setDate_Paiement(Date_Paiement.toLocalDate());
//           pm.setId_Compte(idC);
             ar.add(pm);
    }
    
         DBUtils.close(rst, prepar, con);
     return ar;
}

    @Override
    public int enregistrer(PaiementModel p) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}