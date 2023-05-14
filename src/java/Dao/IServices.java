/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abdue
 */

  public interface IServices<T> {
      
    T rechercher(String id) throws ClassNotFoundException, SQLException;

    ArrayList<T> lister() throws ClassNotFoundException, SQLException;

}
