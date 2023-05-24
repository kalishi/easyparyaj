/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PaiementModel;
import Model.PariageModel;
import dbutils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author abdue
 */
public class PariageDao implements IServices<PariageModel> {

    Connection con = null;
    PreparedStatement prepar = null;
    ResultSet rst = null;
    String Req = "";

    @Override
    public PariageModel rechercher(String id) throws SQLException, ClassNotFoundException {
      
       // Req="Select *from Parriage where Code_P=?";
       //con=DBUtils.connect();
        //prepar=con.prepareStatement(Req);
        //rst=prepar.executeQuery();
        
        //Pariage pr
        return null;
    }

    @Override
    public ArrayList<PariageModel> lister() throws SQLException, ClassNotFoundException {
        //To change body of generated methods, choose Tools | Templates.
        Date date_parriage;
        String score_prevu;
        Double montantMise;
        Double solde_fiche;
        String Nom;
        String Prenom;

//        Req = "Select Parriage.Date_P, Parriage.Score_prevu, Parriage.Montant_mise, Parriage.Solde_fiche, Compte.Nom, Compte.Prenom FROM Parriage inner join Compte on Parriage.Code_P=Compte.code_C";
        Req = "Select *from Parriage";
        con = DBUtils.connect();
        prepar = con.prepareStatement(Req);
        rst = prepar.executeQuery();

        ArrayList<PariageModel> arModel = new ArrayList<>();
        while (rst.next()) {
            date_parriage = rst.getDate("Date_P");
            score_prevu = rst.getString("Score_prevu");
            montantMise = rst.getDouble("Montant_mise");
            solde_fiche = rst.getDouble("Solde_fiche");
            String code = rst.getString("Code_P");
            String idC = rst.getString("id_C");
            String idR = rst.getString("Id_rencontre");   
            String etat = rst.getString("etat");


//            Nom = rst.getString("Nom");
//            Prenom = rst.getString("Prenom");
            PariageModel prg = new PariageModel(date_parriage, score_prevu, montantMise, idR, idC);
            prg.setCode_Pariage(code);
            prg.setEtat(etat);
            arModel.add(prg);
        }
        DBUtils.close(rst, prepar, con);
        System.out.println("fin lister pariage dao");
        return arModel;
    }

    @Override
    public int enregistrer(PariageModel obj) throws SQLException, ClassNotFoundException {
        if (obj == null) {
            return 0;
        }
        //To change body of generated methods, choose Tools | Templates.
        Req = "INSERT INTO Parriage(Date_P,Score_prevu,Montant_mise,Solde_fiche,Id_C,Id_rencontre,etat) values(?,?,?,?,?,?,?)";
        con = DBUtils.connect();
        prepar = con.prepareStatement(Req);
        prepar.setString(1, LocalDate.now().toString());
        prepar.setString(2, obj.getScrore_pevu());
        prepar.setDouble(3, obj.getMontant_mise());
        prepar.setDouble(4, obj.getSolde_fiche());
        prepar.setString(5, obj.getId_C());
        prepar.setString(6, obj.getId_R());  
        prepar.setString(7, "N");


        int n = prepar.executeUpdate();
        DBUtils.close(rst, prepar, con);
        return n;
    }

    public ArrayList<PariageModel> listeParieUser(String id) throws SQLException, ClassNotFoundException {
//        Req="Select Select Parriage.Date_P, Parriage.Score_prevu,"
//                + " Parriage.Montant_mise, Parriage.Solde_fiche, Compte.Nom, "
//                + "Compte.Prenom FROM Compte inner join Pariage on Compte.code_C=Pariage.Code_P inner join "
//                + "rencontre on Pariage.Id_rencontre=rencontre.Code_rencontre where Score_prevu==Score_final";
        Req = "Select * from Parriage where Id_C=?";
        Date date_parriage;
        String score_prevu;
        Double montantMise;
        Double solde_fiche;
//        String Nom;
//        String Prenom;

        con = DBUtils.connect();
        prepar = con.prepareStatement(Req);
        prepar.setString(1, id);
        rst = prepar.executeQuery();

        ArrayList<PariageModel> arModel = new ArrayList<>();
        while (rst.next()) {
            date_parriage = rst.getDate("Date_P");
            score_prevu = rst.getString("Score_prevu");
            montantMise = rst.getDouble("Montant_mise");
            solde_fiche = rst.getDouble("Solde_fiche");
            String code = rst.getString("Code_P");
            String idC = rst.getString("id_C");
            String idR = rst.getString("Id_rencontre");          
            String etat= rst.getString("etat");


//            Nom = rst.getString("Nom");
//            Prenom = rst.getString("Prenom");
            PariageModel prg = new PariageModel(date_parriage, score_prevu, montantMise, idR, idC);
            prg.setCode_Pariage(code);
            prg.setEtat(etat);
            arModel.add(prg);
        }
        DBUtils.close(rst, prepar, con);
        return arModel;
    }
    
        public int update(String etat, String id) throws SQLException, ClassNotFoundException {
     
        //To change body of generated methods, choose Tools | Templates.
        Req = "update parriage set etat=? where id=?";
        con = DBUtils.connect();
        prepar = con.prepareStatement(Req);
        prepar.setString(1, etat);
        prepar.setString(2, id);
        int n = prepar.executeUpdate();
        DBUtils.close(rst, prepar, con);
        return n;
    }
}
