/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import EM.EmployeeEM;
import Model.Employee;
import Util.ConnectToDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kimjohnconcha
 */
public class EmployeeService {
    private ConnectToDB connectToDB;
    
    public EmployeeService() {
        connectToDB = new ConnectToDB();
    }
    
    public DefaultTableModel getEmployeeTableModel() {
        Object[] headers = {"Code", "Name", "Position"};
        DefaultTableModel model = new DefaultTableModel(null, headers);
        
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            ArrayList<Employee> employees = new EmployeeEM(con).get();
            
            for(Employee employee : employees) {
                Object[] row = new Object[3];
                row[0] = employee.getEmployeeCode();
                row[1] = employee.toString();
                row[2] = employee.getPosition().toString();
                
                model.addRow(row);
            }
        } catch(Exception ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null)
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return model;
        }
    }
    
    
    public DefaultTableModel getEmployeeTableModel(String criterion) {
        Object[] headers = {"Code", "Name", "Position"};
        DefaultTableModel model = new DefaultTableModel(null, headers);
        
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            ArrayList<Employee> employees = new EmployeeEM(con).get(criterion);
            
            for(Employee employee : employees) {
                Object[] row = new Object[3];
                row[0] = employee.getEmployeeCode();
                row[1] = employee.toString();
                row[2] = employee.getPosition().toString();
                
                model.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null)
            {
                try {
                    con.close();
                } catch(Exception ex) {
                    Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return model;
        }
    }
}
