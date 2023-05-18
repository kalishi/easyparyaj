/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DTelcy
 */
public class UserDao implements IServices<User> {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String req ;
    

    @Override
    public ArrayList<User> lister() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int enregistrer() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    INSERT INTO `compte` (`code_C`, `Nom`, `Prenom`, `Sexe`, `Adresse`, `Lieu_de_naissance`, `Date_de_naissance`, `Tel`, `Nif_Cin`, `Password`, `Solde`, `Etat`) VALUES (NULL, 'pp', 'pp', 'M', 'lilo', 'lopo', '2023-05-17', '8989', '9898', '$2y$10$0pzBowRwzPb/M0pxrTAZw.c3EZgUycpnLHBqkVga0fHFQo81A1OEC', '90', 'A');

    @Override
    public User rechercher(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
