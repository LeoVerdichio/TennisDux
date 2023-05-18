package com.tennisdux.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Game {
	private boolean deuce;	
	private boolean tieBreak;
        private List<Player> Playeres;
	private int cantidadSets;
	private String nameTorneo;
	private boolean tie5;
	private boolean tie6;

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    public boolean isTieBreak() {
        return tieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        this.tieBreak = tieBreak;
    }

    public List<Player> getPlayeres() {
        return Playeres;
    }

    public void setPlayeres(List<Player> Playeres) {
        this.Playeres = Playeres;
    }

    public int getCantidadSets() {
        return cantidadSets;
    }

    public void setCantidadSets(int cantidadSets) {
        this.cantidadSets = cantidadSets;
    }

    public String getNameTorneo() {
        return nameTorneo;
    }

    public void setNameTorneo(String nameTorneo) {
        this.nameTorneo = nameTorneo;
    }

    public boolean isTie5() {
        return tie5;
    }

    public void setTie5(boolean tie5) {
        this.tie5 = tie5;
    }

    public boolean isTie6() {
        return tie6;
    }

    public void setTie6(boolean tie6) {
        this.tie6 = tie6;
    }

  
        
    
        	
	public Player getGanadorgame(){
		return Playeres.get(0).isWinner() ? Playeres.get(0) : Playeres.get(1); 
	}
	@Override
	public String toString() {
		return "game [cantidadSets=" + cantidadSets + ", nameTorneo=" + nameTorneo + ", Playeres=" + Playeres+ "]";
	}
}
