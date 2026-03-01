package WoV.controller;

import WoV.model.Player;
import WoV.model.Quest;
import WoV.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/player")
    public Player createPlayer(@RequestParam String name,
                               @RequestParam String race,
                               @RequestParam String playerClass) {
        return gameService.createPlayer(name, race, playerClass);
    }

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable String id) {
        return gameService.getPlayer(id);
    }

    @PostMapping("/attack")
    public String attackMonster(@RequestParam String playerId, @RequestParam String monsterId) {
        return gameService.attackMonster(playerId, monsterId);
    }

    @PostMapping("/quest")
    public String assignQuest(@RequestParam String playerId, @RequestBody Quest quest) {
        gameService.assignQuest(playerId, quest);
        return "Quest assigned";
    }




    @GetMapping("/")
    public String home() {
        return "WoV";
    }
}