/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Util.ConnectToDB;

/**
 *
 * @author kimjohnconcha
 */
public class EmployeeService {
    private ConnectToDB connectToDB;
    
    public EmployeeService() {
        connectToDB = new ConnectToDB();
    }
}
