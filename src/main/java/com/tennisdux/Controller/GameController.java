package com.tennisdux.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tennisdux.Logic.Simulator;
import com.tennisdux.Model.Game;
import com.tennisdux.Model.GameDTO;
import com.tennisdux.Model.Player;

@Controller
public class GameController {
	Simulator sr;
	Game game;
	List<Player> Playeres;
	

	@GetMapping("/")
	public String home(Model modelo) {
		return "Home";
	}

	@GetMapping("/form")
	public String Gameform(Model modelo) {
		GameDTO gameDTO = new GameDTO();
		modelo.addAttribute("gameDTO", gameDTO);
		return "Form";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute GameDTO gameDTO, ModelMap model) {
            try{
		game = new Game();
		game.setNameTorneo(gameDTO.getNameTorneo());
		game.setCantidadSets(Integer.parseInt(gameDTO.getCantidadSet()));
		
		Player player1 = new Player();
		player1.setName(gameDTO.getNamePlayer1());
		player1.setProbability(Integer.parseInt(gameDTO.getProbabilityP1()));
		
		Player player2 = new Player();
		player2.setName(gameDTO.getNamePlayer2());
		player2.setProbability(100 - (player1.getProbability()));
		
		Playeres = new ArrayList<>();
		Playeres.add(player1);
		Playeres.add(player2);
		game.setPlayeres(Playeres);
            }catch(Exception e){
                model.addAttribute("error","Error le falta ingresar valores");
                return "Form";
            }
		return "redirect:/game";
	}
	
	@GetMapping("/game")
	public String startGame(ModelMap model) {
            try{
		sr = new Simulator(game);
		model.addAttribute("nameTorneo", game.getNameTorneo());
		model.addAttribute("Player1", game.getPlayeres().get(0));
		model.addAttribute("Player2", game.getPlayeres().get(1));
		model.addAttribute("finalizado", sr.getgameTerminado());
		sr.simulation();
            }catch(Exception e){
                model.addAttribute("error","Error al iniciar el juego");
                return "Game";
            }
		return "Game";
	}
	
	@RequestMapping(value="/event-count", method=RequestMethod.GET)
	public String getEventCount(Model model) {
	    model.addAttribute("Player1", game.getPlayeres().get(0));
	    model.addAttribute("Player2", game.getPlayeres().get(1));
	    model.addAttribute("finalizado", sr.getgameTerminado());
	    return "Game :: #eventCount";
	}
	
	@RequestMapping(value="/finalizado", method=RequestMethod.GET)
	public String getFinalizado(Model model) {
	    model.addAttribute("finalizado", sr.getgameTerminado());
	    return "Game :: #finished";
	}
	
	@GetMapping("/resultado")
	public String Resultado(ModelMap model) {
            try{
		model.addAttribute("game", game);
		model.addAttribute("setsJ1", game.getPlayeres().get(0).getSets());
		model.addAttribute("setsJ2", game.getPlayeres().get(1).getSets());
            }catch(Exception e){
                model.addAttribute("error","Error al obtener resultado");
            }
		return "Result";
	}
}
