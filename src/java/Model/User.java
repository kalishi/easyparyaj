/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author DTelcy
 */
public class User {
    private String code;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private String lieuDeNaissance;
    private String dateDeNaissance;
    private String telephone;
    private String nifCin;
    private String username;
    private String password;
    private double solde;
    private String etat;
    private Boolean isAdmin;

    public User() {
    }

    public User(String nom, String prenom, String sexe,
            String adresse, String lieuDeNaissance, 
            String dateDeNaissance, String telephone,
            String nifCin, String username,
            String password, String etat
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.lieuDeNaissance = lieuDeNaissance;
        this.dateDeNaissance = dateDeNaissance;
        this.telephone = telephone;
        this.nifCin = nifCin;
        this.username = username;
        this.password = password;
        this.solde = 0.0;
        this.etat = etat;
        this.isAdmin = false;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNifCin() {
        return nifCin;
    }

    public void setNifCin(String nifCin) {
        this.nifCin = nifCin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Boolean isAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" + "code=" + code + ", isAdmin=" + isAdmin + '}';
    }
    
    private static String generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return Base64.getEncoder().encodeToString(salt);
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(Base64.getDecoder().decode(salt));
    byte[] hashedPassword = md.digest(password.getBytes());
    return Base64.getEncoder().encodeToString(hashedPassword);
}

    
    public void hashedPassword () throws NoSuchAlgorithmException{
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
    }
    
    
}
