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
        String query = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Position> position = new ArrayList<>();
        
        // Some Magic here
        
        return position;
    }
}
