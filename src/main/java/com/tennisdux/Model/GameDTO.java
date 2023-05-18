package com.tennisdux.Model;

import java.io.Serializable;

public class GameDTO implements Serializable {
	private String nameTorneo;
	private String namePlayer1;
	private String namePlayer2;
	private String probabilityP1;
	private String probabilityP2;
	private String cantidadSet;

    public String getNameTorneo() {
        return nameTorneo;
    }

    public void setNameTorneo(String nameTorneo) {
        this.nameTorneo = nameTorneo;
    }

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public void setNamePlayer1(String namePlayer1) {
        this.namePlayer1 = namePlayer1;
    }

    public String getNamePlayer2() {
        return namePlayer2;
    }

    public void setNamePlayer2(String namePlayer2) {
        this.namePlayer2 = namePlayer2;
    }

    public String getProbabilityP1() {
        return probabilityP1;
    }

    public void setProbabilityP1(String probabilityP1) {
        this.probabilityP1 = probabilityP1;
    }

    public String getProbabilityP2() {
        return probabilityP2;
    }

    public void setProbabilityP2(String probabilityP2) {
        this.probabilityP2 = probabilityP2;
    }

    
    
	
	public String getCantidadSet() {
		return cantidadSet;
	}
	public void setCantidadSet(String cantidadSet) {
		this.cantidadSet = cantidadSet;
	}

    @Override
    public String toString() {
        return "GameDTO{" + "nameTorneo=" + nameTorneo + ", namePlayer1=" + namePlayer1 + ", namePlayer2=" + namePlayer2 + ", probabilityP1=" + probabilityP1 + ", probabilityP2=" + probabilityP2 + ", cantidadSet=" + cantidadSet + '}';
    }

    
	

	
	
}
