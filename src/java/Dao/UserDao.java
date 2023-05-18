/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.User;
import dbutils.DBUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DTelcy
 */
public class UserDao implements IServices<User> {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String req;

    @Override
    public ArrayList<User> lister() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int enregistrer(User user) throws SQLException, ClassNotFoundException {
         String sql = "INSERT INTO Compte (Nom, Prenom, Sexe, Adresse, Lieu_de_naissance, Date_de_naissance, " +
                "Tel, Nif_Cin, Password, username, Solde, Etat) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn = DBUtils.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getNom());
        pstmt.setString(2, user.getPrenom());
        pstmt.setString(3, user.getSexe());
        pstmt.setString(4, user.getAdresse());
        pstmt.setString(5, user.getLieuDeNaissance());
        pstmt.setString(6, user.getDateDeNaissance());
        pstmt.setString(7, user.getTelephone());
        pstmt.setString(8, user.getNifCin());
        pstmt.setString(9, user.getPassword());
        pstmt.setString(10, user.getUsername());
        pstmt.setDouble(11, user.getSolde());
        pstmt.setString(12, user.getEtat());
        int nb = pstmt.executeUpdate();
        
        return nb;
    }

    @Override
    public User rechercher(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User getUser(String username, String password_) {
        User user = null;
        try {
            // Connect to the database
            conn = DBUtils.connect();
            // Prepare the SQL statement
            String sql = "SELECT * FROM compte WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password_);

            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String code_C = rs.getString("code_C");
                String nom = rs.getString("Nom");
                String prenom = rs.getString("Prenom");
                String sexe = rs.getString("Sexe");
                String adresse = rs.getString("Adresse");
                String lieu_de_naissance = rs.getString("Lieu_de_naissance");
                String date_de_naissance = rs.getString("Date_de_naissance");
                String tel = rs.getString("Tel");
                String nif_Cin = rs.getString("Nif_Cin");
                String password = rs.getString("Password");
                double solde = rs.getDouble("Solde");
                String etat = rs.getString("Etat");
                 user = new User( nom,
                        prenom, sexe, adresse,
                        lieu_de_naissance,
                        date_de_naissance,
                        tel, nif_Cin, username,
                        password, etat
                );
                 user.setCode(code_C);
                 user.setSolde(solde);
                 return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(rs, pstmt, conn);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }

        return user;
    }

}
