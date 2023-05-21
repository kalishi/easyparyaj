/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.MatcheDao;
import java.lang.invoke.MethodHandles;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author DTelcy
 */
public class Matche {

    private String id;
    private String type;
    private Date date;
    private String pays;
    private String equipeR;
    private String equipeV;
    private Time heure;
    private float cote;
    private String scoreFinal;
    private String etat;

    public Matche() {
    }

    public Matche(String type, String pays,Date date, String equipeR, String equipeV, Time heure, float cote, String scoreFinal, String etat) {
        this.type = type;
        this.pays = pays;
        this.equipeR = equipeR;
        this.equipeV = equipeV;
        this.heure = heure;
        this.cote = cote;
        this.scoreFinal = scoreFinal;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEquipeR() {
        return equipeR;
    }

    public void setEquipeR(String equipeR) {
        this.equipeR = equipeR;
    }

    public String getEquipeV() {
        return equipeV;
    }

    public void setEquipeV(String equipeV) {
        this.equipeV = equipeV;
    }


    public float getCote() {
        return cote;
    }

    public void setCote(float cote) {
        this.cote = cote;
    }

    public String getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(String scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    public int modifier(String etat2){
        MatcheDao dao = new MatcheDao();
        try{
            return dao.modifier(etat2, this.id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
    
    public static  boolean isValidScoreFormat(String score) {
    // Vérifier si la chaîne de score est dans le format attendu (exemple avec "2-0")
    // et ne contient pas de nombres négatifs
    String regex = "^\\d+-\\d+$"; // Format "nombre-nombre"
    if (!score.matches(regex)) {
        return false;
    }

    String[] parts = score.split("-");
    int score1 = Integer.parseInt(parts[0]);
    int score2 = Integer.parseInt(parts[1]);
    
    if (score1 < 0 || score2 < 0) {
        return false;
    }

    return true;
}
    

}
