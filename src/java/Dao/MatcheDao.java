/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Matche;
import dbutils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author DTelcy
 */
public class MatcheDao implements IServices<Matche> {

    Connection con = null;
    PreparedStatement prepar = null;
    ResultSet rst = null;
    String req = null;

    @Override
    public Matche rechercher(String id_to_search) throws SQLException, ClassNotFoundException {
       con = DBUtils.connect();
        req = "Select * from rencontre where Code_rencontre="+id_to_search;
        prepar = con.prepareStatement(req);
        rst = prepar.executeQuery(req);
        Matche matche = null;
        if (rst.next()){
            String id = rst.getString("Code_rencontre");
            String type = rst.getString("Type_rencontre");
            String pays = rst.getString("Pays");
            String equipeR = rst.getString("Equipe_receveuse");
            String equipeV = rst.getString("Equipe_visiteuse");
            Date date = rst.getDate("Date_rencontre");
            Time heure = rst.getTime("heure_rencontre");
            float cote = rst.getFloat("Cote");
            String scoreFinal = rst.getString("Score_final");
            String etat = rst.getString("Etat_rencontre");
             matche = new Matche(type, pays, date, equipeR, equipeV, heure, cote, scoreFinal, etat);
            matche.setId(id);
        }
        return  matche;
        
    }

    @Override
    public ArrayList<Matche> lister() throws SQLException, ClassNotFoundException {
        con = DBUtils.connect();
        req = "Select * from rencontre";
        prepar = con.prepareStatement(req);
        rst = prepar.executeQuery(req);

        ArrayList<Matche> arr = new ArrayList<>();
        while (rst.next()) {
            String id = rst.getString("Code_rencontre");
            String type = rst.getString("Type_rencontre");
            String pays = rst.getString("Pays");
            String equipeR = rst.getString("Equipe_receveuse");
            String equipeV = rst.getString("Equipe_visiteuse");
            Date date = rst.getDate("Date_rencontre");
            Time heure = rst.getTime("heure_rencontre");
            float cote = rst.getFloat("Cote");
            String scoreFinal = rst.getString("Score_final");
            String etat = rst.getString("Etat_rencontre");
            Matche matche = new Matche(type, pays, date, equipeR, equipeV, heure, cote, scoreFinal, etat);
            matche.setId(id);
            arr.add(matche);
        }
        DBUtils.close(rst, prepar, con);
        return arr;
    }

    @Override
    public int enregistrer(Matche object) throws SQLException, ClassNotFoundException {
        con = DBUtils.connect();
        req = "insert into rencontre (Type_rencontre,Pays,Equipe_receveuse,Equipe_visiteuse,Date_rencontre,heure_rencontre,Cote,Score_final,Etat_rencontre) values(?,?,?,?,?,?,?,?,?)";
        prepar = con.prepareStatement(req);
        prepar.setString(1, object.getType());
        prepar.setString(2, object.getPays());
        prepar.setString(3, object.getEquipeR());
        prepar.setString(4, object.getEquipeV());
        prepar.setDate(5, object.getDate());
        prepar.setTime(6, object.getHeure());
        prepar.setFloat(7, object.getCote());
        prepar.setString(8, object.getScoreFinal());
        prepar.setString(9, object.getEtat());
        int nb = prepar.executeUpdate(req);
        DBUtils.close(rst, prepar, con);
        return nb;
    }

    public int modifier(String etat, String id) throws SQLException, ClassNotFoundException {
        con = DBUtils.connect();
        req = "Update rencontre set Etat_rencontre=? where id =?";
        prepar.setString(1, etat);
        prepar.setString(2, id);
        prepar = con.prepareStatement(req);
        int nb = prepar.executeUpdate();
        DBUtils.close(rst, prepar, con);
        return nb;
    }

}
