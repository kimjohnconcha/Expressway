/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEmployeeCRUD;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author kimjohnconcha
 */
@Entity
@Table(name = "employee", catalog = "expresswaydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employee_1.findAll", query = "SELECT e FROM Employee_1 e")
    , @NamedQuery(name = "Employee_1.findByEmployeeId", query = "SELECT e FROM Employee_1 e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee_1.findByEmployeeCode", query = "SELECT e FROM Employee_1 e WHERE e.employeeCode = :employeeCode")
    , @NamedQuery(name = "Employee_1.findByLastName", query = "SELECT e FROM Employee_1 e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee_1.findByFirstName", query = "SELECT e FROM Employee_1 e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee_1.findByMiddleName", query = "SELECT e FROM Employee_1 e WHERE e.middleName = :middleName")
    , @NamedQuery(name = "Employee_1.findByPositionId", query = "SELECT e FROM Employee_1 e WHERE e.positionId = :positionId")})
public class Employee_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "position_id")
    private int positionId;

    public Employee_1() {
    }

    public Employee_1(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee_1(Integer employeeId, String employeeCode, String lastName, String firstName, String middleName, int positionId) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.positionId = positionId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        Integer oldEmployeeId = this.employeeId;
        this.employeeId = employeeId;
        changeSupport.firePropertyChange("employeeId", oldEmployeeId, employeeId);
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        String oldEmployeeCode = this.employeeCode;
        this.employeeCode = employeeCode;
        changeSupport.firePropertyChange("employeeCode", oldEmployeeCode, employeeCode);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        String oldMiddleName = this.middleName;
        this.middleName = middleName;
        changeSupport.firePropertyChange("middleName", oldMiddleName, middleName);
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        int oldPositionId = this.positionId;
        this.positionId = positionId;
        changeSupport.firePropertyChange("positionId", oldPositionId, positionId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee_1)) {
            return false;
        }
        Employee_1 other = (Employee_1) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestEmployeeCRUD.Employee_1[ employeeId=" + employeeId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
