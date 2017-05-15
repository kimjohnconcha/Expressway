package EM;

import Model.Employee;
import Model.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeEM {
    private Connection con;
    public EmployeeEM(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Employee> get() {
        String query = "SELECT * FROM employee INNER JOIN position WHERE employee.position_id=position.position_id";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = new ArrayList<>();
        
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    Employee employee = new Employee();
                    employee.setEmployeeCode(rs.getString("employee_code"));
                    employee.setLastname(rs.getString("last_name"));
                    employee.setFirstname(rs.getString("first_name"));
                    employee.setMiddlename(rs.getString("middle_name"));
                    
                    Position position = new Position();
                    position.setPositionID(rs.getInt("position_id"));
                    position.setPositionCode(rs.getString("position_code"));
                    position.setPositionName(rs.getString("position_name"));
                    
                    employee.setPosition(position);
                    employees.add(employee);
                    
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
            
            return employees;
        }
    }
    
    
    public ArrayList<Employee> get(String criterion) {
        String query = "SELECT " +
                        "* " +
                "FROM employee " +
                "INNER JOIN position ON employee.position_id=position.position_id " +
                "WHERE employee.employee_code LIKE ? " +
                "OR employee.last_name LIKE ? " +
                "OR employee.first_name LIKE ?  " +
                "OR employee.middle_name LIKE ? " +
                "OR position.position_code LIKE ? " + 
                "OR position.position_name LIKE ? ";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Employee> employees = new ArrayList<>();
        
        try {
            ps = con.prepareStatement(query);
            
            int i = 1;
            ps.setString(i++, criterion + "%");
            ps.setString(i++, "%" + criterion + "%");
            ps.setString(i++, "%" + criterion + "%");
            ps.setString(i++, "%" + criterion + "%");
            ps.setString(i++, "%" + criterion + "%");
            ps.setString(i++, "%" + criterion + "%");
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                do
                {
                    Employee employee = new Employee();
                    employee.setEmployeeCode(rs.getString("employee_code"));
                    employee.setLastname(rs.getString("last_name"));
                    employee.setFirstname(rs.getString("first_name"));
                    employee.setMiddlename(rs.getString("middle_name"));
                    
                    Position position = new Position();
                    position.setPositionID(rs.getInt("position_id"));
                    position.setPositionCode(rs.getString("position_code"));
                    position.setPositionName(rs.getString("position_name"));
                    
                    employee.setPosition(position);
                    employees.add(employee);
                    
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
            
            return employees;
        }
    }
    
    public int persist(Employee employee) {
       String query = "INSERT INTO employee " +
                      "(employee_code,last_name,first_name,middle_name,position_id) VALUES " +
                      "(?            ,?        ,?         ,?          ,?          ) "; 
       
        PreparedStatement ps = null;
        int row = 0;
        
        try {
            ps = con.prepareStatement(query);
            
            int i = 1;
            ps.setString(i++, employee.getEmployeeCode());
            ps.setString(i++, employee.getLastname());
            ps.setString(i++, employee.getFirstname());
            ps.setString(i++, employee.getMiddlename());
            ps.setInt(i++, employee.getPosition().getPositionID());
            
            row = ps.executeUpdate();

        } catch(SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            
            if(ps != null)
            {
                try{
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
         
            return row;
        }

    }
    
    public int delete(String employeeCode) {
        String query = "DELETE FROM employee WHERE employee_code = ?";
        PreparedStatement ps = null;
        int row = 0;
        
        try {
            ps = con.prepareStatement(query);
            
            int i = 1;
            ps.setString(i++, employeeCode);
            
            row = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            
            if(ps != null)
            {
                try{
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            
            return row;
        }
    }
    
    public Employee getEmployee(String employeeCode) {
        System.out.println("here get emplotee");
        String query = "SELECT " +
                "* " +
                "FROM employee " +
                "INNER JOIN position ON employee.position_id=position.position_id " +
                "WHERE employee.employee_code = ? LIMIT 1";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee employee = new Employee();
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, employeeCode);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                employee.setEmployeeID(rs.getInt("employee_id"));
                employee.setEmployeeCode(rs.getString("employee_code"));
                employee.setLastname(rs.getString("last_name"));
                employee.setFirstname(rs.getString("first_name"));
                employee.setMiddlename(rs.getString("middle_name"));

                Position position = new Position();
                position.setPositionID(rs.getInt("position_id"));
                position.setPositionCode(rs.getString("position_code"));
                position.setPositionName(rs.getString("position_name"));

                employee.setPosition(position);
            }

        } catch (SQLException ex) {
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
            
            return employee;
        }
        
        
    }
    
    public int update(Employee employee, String oldCode) {
        String query = "UPDATE employee SET employee_code = ?, " +
                "last_name = ?, " +
                "first_name = ?, " +
                "middle_name = ?, " +
                "position_id = ? " +
                "WHERE employee_code = ? ";
        
        PreparedStatement ps = null;
        
        System.out.println("Query " + query);
        
        int row = 0;
        
        try {
            ps = con.prepareStatement(query);
            
            int i = 1;
            ps.setString(i++, employee.getEmployeeCode());
            ps.setString(i++, employee.getLastname());
            ps.setString(i++, employee.getFirstname());
            ps.setString(i++, employee.getMiddlename());
            ps.setInt(i++, employee.getPosition().getPositionID());
            ps.setString(i++, oldCode);
            
//            System.out.println("q " + employee.getEmployeeCode());
//            System.out.println("q " + employee.getLastname());
//            System.out.println("q " + employee.getFirstname());
//            System.out.println("q " + employee.getMiddlename());
//            System.out.println("q " + employee.getPosition().getPositionID());
//            System.out.println("q " + oldCode);
             
            
            
            row = ps.executeUpdate();
            
        } catch (SQLException ex) {
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
            
            return row;
        }

    }
    
    
    
    
    
    
}
