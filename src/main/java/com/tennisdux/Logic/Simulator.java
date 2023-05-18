package com.tennisdux.Logic;

import java.util.Random;


import javax.swing.Timer;

import java.util.stream.Collectors;
import com.tennisdux.Model.Player;
import com.tennisdux.Model.Game;

public class Simulator {

    private static final int PUNTOS_DEUCE = 40;
    private static final int JUEGOS_PARA_GANAR = 6;
    private static final int PUNTOS_PARA_GANAR = 40;

    private static final int TIEMPO_DELAY = 500;

    
    private int juegosRestantes;
    private Game game;
    private Random random;
    private Timer timer;
    private boolean gameterminado;

    public Simulator(Game game) {
        this.game = game;
        game.getPlayeres().get(0).setSetswins(0);
        game.getPlayeres().get(1).setSetswins(0);
        game.getPlayeres().get(0).setSets(-1);
        game.getPlayeres().get(1).setSets(-1);
        juegosRestantes = JUEGOS_PARA_GANAR;
        gameterminado = false;
        random = new Random();
    }

    public boolean getgameTerminado() {
        return gameterminado;
    }

    public void simulation() {
        PlayerSaque(true);

        timer = new Timer(TIEMPO_DELAY, null);

        timer.addActionListener(e -> {
            ScoreGenerate();
            System.out.println(game);
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void PlayerSaque(boolean primeraVez) {
        if (primeraVez) {
            int SaqueIndex = random.nextInt(2);

            game.getPlayeres()
                    .get(SaqueIndex)
                    .setServe(true);

            game.getPlayeres()
                    .get(1 - SaqueIndex)
                    .setServe(false);
        } else {
            Player ultimoSaque = game.getPlayeres()
                    .stream()
                    .filter(Player::isServe)
                    .collect(Collectors.toList())
                    .get(0);

            Player nuevoSaque = game.getPlayeres()
                    .get(1 - game.getPlayeres()
                            .indexOf(ultimoSaque));

            ultimoSaque.setServe(false);
            nuevoSaque.setServe(true);
        }
    }

    private void ScoreGenerate() {
        Player Player1 = game.getPlayeres()
                .get((random.nextDouble()
                        <= (double) game.getPlayeres()
                                .get(0)
                                .getProbability() / 100) ? 0 : 1);

        int puntosPlayer;

        if (game.isDeuce()) {
            puntosPlayer = Player1.getScoregame() + 1;
        } else {
            puntosPlayer = Player1.getScoregame() + 15;
            if (puntosPlayer == 45) {
                puntosPlayer = 40;
            }
        }

       Player1.setScoregame(puntosPlayer);

        Player Player2 = game.getPlayeres()
                .get(1 - game.getPlayeres()
                        .indexOf(Player1));

        if (checkEmpate(Player1.getScoregame(), Player2.getScoregame(), PUNTOS_DEUCE)) {
            game.setDeuce(true);
        }

        if (game.isDeuce() && Player1.getScoregame() == Player2.getScoregame()+ 2) {
            game.setDeuce(false);
            PlayerGanadorJuego(Player1, Player2);
            return;
        }

        if (!game.isDeuce() && Player1.getScoregame()> PUNTOS_PARA_GANAR) {
            PlayerGanadorJuego(Player1, Player2);
            return;
        }
    }

    private void PlayerGanadorJuego(Player Player1, Player Player2) {
        Player1.setScoregame(0);
        Player2.setScoregame(0);

        int juegosGanados = Player1.getGameswin()+ 1;

        Player1.setGameswin(juegosGanados);

        if (checkEmpate(Player1.getGameswin(), Player2.getGameswin(), JUEGOS_PARA_GANAR - 1)) {
            game.setTie5(true);

            juegosRestantes = JUEGOS_PARA_GANAR + 1;
        }

        if (checkEmpate(Player1.getGameswin(), Player2.getGameswin(), JUEGOS_PARA_GANAR)) {
            game.setTie5(false);
            game.setTie6(true);

            juegosRestantes = JUEGOS_PARA_GANAR + 7;
        }

        if (game.isTieBreak() && Player1.getScoregame() == Player2.getScoregame() + 2) {
            PlayerWinSet(Player1, Player2);
            return;
        }

        if (Player1.getGameswin()== juegosRestantes) {
            if (checkEmpate(Player1.getGameswin(), Player2.getGameswin(), juegosRestantes)) {
                game.setTieBreak(true);
            }

            PlayerWinSet(Player1, Player2);
            return;
        }
    }

    private void PlayerWinSet(Player Player1, Player Player2) {
        Player1.setSets(Player1.getGameswin());
        Player2.setSets(Player2.getGameswin());
        Player1.setGameswin(0);
        Player2.setGameswin(0);

        int setsGanados = Player1.getSetswins() + 1;

        Player1.setSetswins(setsGanados);

        if (gameTerminado(Player1, Player2)) {
            timer.stop();

            if (game.getCantidadSets() != Player1.getSetswins() + Player2.getSetswins()) {
                game.setCantidadSets(Player1.getSetswins());
            }

            Player1.setWinner(true);

            gameterminado = true;

            return;
        }

        if (game.isTie5() || game.isTie6()) {
            game.setTie5(false);
            game.setTie6(false);
            game.setTieBreak(false);

            juegosRestantes = JUEGOS_PARA_GANAR;
        }

        PlayerSaque(false);
    }

    private boolean gameTerminado(Player Player1, Player Player2) {
        return Player1.getSetswins() + Player2.getSetswins()== game.getCantidadSets()
                || (Player1.getSetswins()> game.getCantidadSets() / 2
                && game.getCantidadSets() - Player1.getSetswins()
                < game.getCantidadSets() - Player2.getSetswins());
    }

    private boolean checkEmpate(int puntosPlayer1, int puntosPlayer2, int puntosReferencia) {
        return puntosPlayer1 == puntosReferencia && puntosPlayer1 == puntosPlayer2;
    }

}
