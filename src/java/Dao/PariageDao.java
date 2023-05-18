/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.PaiementModel;
import Model.PariageModel;
import dbutils.DBUtils;
import java.sql.Connection;
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
public class PariageDao implements IServices<PariageModel>{
     Connection con=null;
     PreparedStatement prepar=null;
     ResultSet rst= null;
     String Req= "";
     
    @Override
    public PariageModel rechercher(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PariageModel> lister() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public int enregistrer(PariageModel obj) throws SQLException, ClassNotFoundException {
        //To change body of generated methods, choose Tools | Templates.
        Req= "INSERT INTO Parriage(Date_P,Score_prevu,Montan_mise,Solde_fiche,Id_C,Id_rencontre) values(?,?,?,?,?,?)";
        con = DBUtils.connect();
        prepar = con.prepareStatement(Req);
        prepar.setString(1, LocalDate.now().toString());
        prepar.setString(2, obj.getScrore_pevu());
        prepar.setDouble(3, obj.getMontant_mise());
        prepar.setDouble(4, obj.getSolde_fiche());
        prepar.setString(5, obj.getId_C());
        prepar.setString(6, obj.getId_R());
        
        int n= prepar.executeUpdate();
       DBUtils.close(rst, prepar, con);
        return n;
    }
     
}
