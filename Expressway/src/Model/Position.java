/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kimjohnconcha
 */
public class Position {

    /**
     * @return the positionID
     */
    public int getPositionID() {
        return positionID;
    }

    /**
     * @param positionID the positionID to set
     */
    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    /**
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * @param positionCode the positionCode to set
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    /**
     * @return the PositionName
     */
    public String getPositionName() {
        return PositionName;
    }

    /**
     * @param PositionName the PositionName to set
     */
    public void setPositionName(String PositionName) {
        this.PositionName = PositionName;
    }
    
    private int positionID;
    private String positionCode;
    private String PositionName;
}
