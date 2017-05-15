package Service;

import EM.EmployeeEM;
import EM.PositionEM;
import Model.Employee;
import Model.Position;
import Util.ConnectToDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (con != null)
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
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
            System.out.println("Error " + ex.getMessage());
        } finally {
            if(con != null)
            {
                try {
                    con.close();
                } catch(Exception ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            
            return model;
        }
    }
    
    
    public ComboBoxModel getPositionComboModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            ArrayList<Position> positions = new PositionEM(con).get();
            
            model.addElement("SELECT Position");
            for (Position position : positions) {
                model.addElement(position);
            }
        } catch (Exception ex) {
             System.out.println("Error " + ex.getMessage());
        } finally {
            if (con != null)
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                     System.out.println("Error " + ex.getMessage());
                }
            }
            
            return model;
        }
    }
    
    public boolean createEmployee(String code, String last, String mid, String first, Position position) {
        boolean flag = false;
       
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            
            Employee employee = new Employee();
            employee.setEmployeeCode(code);
            employee.setLastname(last);
            employee.setFirstname(first);
            employee.setMiddlename(mid);
            employee.setPosition(position);
            
            int result = new EmployeeEM(con).persist(employee);
            if (result != 0)
            {
                flag = true;
            }
            
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            
            return flag;
        }

    }
    
    public boolean delete(String employeeCode) {
         boolean flag = false;
         
         Connection con = null;
         try {
             con = connectToDB.getConnection();
             
             int result = new EmployeeEM(con).delete(employeeCode);
             if(result != 0)
             {
                 flag = true;
             }
         } catch(Exception ex) {
             System.out.println("Error " + ex.getMessage());
         } finally {
             if (con != null){
                 try {
                     con.close();
                 } catch (Exception ex) {
                     System.out.println("Error " + ex.getMessage());
                 }
             }
             
             return flag;
         }
    }
    
    
    
    public Employee getEmployee(String employeeCode) {
        Employee employee = new Employee();
        
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            employee = new EmployeeEM(con).getEmployee(employeeCode);
            
        }catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if(con != null)
            {
                try {
                    con.close();
                } catch (Exception ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            return employee;
        }
        
    }
    
    
    public boolean updateEmployee(String newCode, String last, String mid, String first, Position position, String oldCode) {
        boolean flag = false;
        
        Connection con = null;
        try {
            con = connectToDB.getConnection();
            
            Employee employee = new Employee();
            employee.setEmployeeCode(newCode);
            employee.setLastname(last);
            employee.setFirstname(first);
            employee.setMiddlename(mid);
            employee.setPosition(position);
            
            int result = new EmployeeEM(con).update(employee, oldCode);
            if (result != 0)
            {
                flag = true;
            }
        } catch(Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch(Exception ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
            
            return flag;
        }
    }
    
}
