/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EM;

import Model.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kimjohnconcha
 */
public class PositionEM {
    private Connection con;
    public PositionEM(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Position> get()
    {
        String query = "SELECT * from position";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Position> positions = new ArrayList<>();
        
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                do 
                {
                    Position position = new Position();
                    position.setPositionID(rs.getInt("position_id"));
                    position.setPositionCode(rs.getString("position_code"));
                    position.setPositionName(rs.getString("position_name"));
                    
                    positions.add(position);
                
                } while(rs.next());
            }
            
        } catch(SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally { 
            if(ps != null)
            {
                try {
                    ps.close();
                } catch(SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            if(rs != null)
            {
               try {
                    rs.close();
                } catch(SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
                } 
            }
            return positions;
        }

    }
}
