package com.tennisdux.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Player {
	

	
	private int scoregame;
	private int gameswin;
        private int probability;
	private int setswins;
        private boolean serve;
	private boolean winner;

	private String name;
	private List<Integer> sets = new ArrayList<Integer>();

    public int getScoregame() {
        return scoregame;
    }

    public void setScoregame(int scoregame) {
        this.scoregame = scoregame;
    }

    public int getGameswin() {
        return gameswin;
    }

    public void setGameswin(int gameswin) {
        this.gameswin = gameswin;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getSetswins() {
        return setswins;
    }

    public void setSetswins(int setswins) {
        this.setswins = setswins;
    }

    public boolean isServe() {
        return serve;
    }

    public void setServe(boolean serve) {
        this.serve = serve;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
	
	

	public void setSets(Integer puntos) {
		if(puntos == -1) {
			sets = new ArrayList<Integer>();
		}
		else {
			sets.add(puntos);
		}
	}

	public List<Integer> getSets() {
		return sets;
	}

    @Override
    public String toString() {
        return "Player{" + "scoregame=" + scoregame + ", gameswin=" + gameswin + ", probability=" + probability + ", setswins=" + setswins + ", serve=" + serve + ", winner=" + winner + ", name=" + name + ", sets=" + sets + '}';
    }

	
}
