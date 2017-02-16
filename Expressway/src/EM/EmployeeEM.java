/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EM;

import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kimjohnconcha
 */
public class EmployeeEM {
    private Connection con;
    public EmployeeEM(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Employee> get() {
        String query = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Employee> employee = new ArrayList<>();
        
        // Some Magic here
        
        
        return employee;
    }
    
    public ArrayList<Employee> get(String criterion) {
        String query = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Employee> employee = new ArrayList<>();
        
        // Some Magic here
        
        return employee;
    }
    
    public int persist(Employee employee) {
       String query = ""; 
       
        PreparedStatement ps = null;
        int row = 0;
        
        // Some magic here
        
        return row;
    }
    
    public int delete(String employeeCode) {
        String query = "";
        PreparedStatement ps = null;
        int row = 0;
        
        // Some magic here
        
        return row;
    }
    
    public Employee getEmployee(String employeeCode) {
        String query = "";
        PreparedStatement ps = null;
        int row = 0;
        Employee employee = new Employee();
        
        // Some magic here
        
        return employee;
    }
    
    public int update(Employee employee, String oldCode) {
        String query = "";
        PreparedStatement ps = null;
        int row = 0;
        
        // Some magic here
        
        return row;
    }
    
    
}
