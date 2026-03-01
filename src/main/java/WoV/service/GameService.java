package WoV.service;

import WoV.model.Monster;
import WoV.model.Player;
import WoV.model.Quest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameService {

    private final Map<String, Player> players = new HashMap<>();
    private final Map<String, Monster> monsters = new HashMap<>();
    private final Map<String, Quest> quests = new HashMap<>();

    public Player createPlayer(String name, String race, String playerClass) {
        Player player = new Player();
        player.setId(UUID.randomUUID().toString());
        player.setName(name);
        player.setRace(race);
        player.setPlayerClass(playerClass);
        player.setLevel(1);
        player.setHealth(100);
        player.setMana(100);
        player.setExperience(0);
        player.setInventory(new ArrayList<>());
        players.put(player.getId(), player);
        return player;
    }

    public Player getPlayer(String id) {
        return players.get(id);
    }

    public String attackMonster(String playerId, String monsterId) {
        Player player = players.get(playerId);
        Monster monster = monsters.get(monsterId);

        if (player == null) return "Player not found";
        if (monster == null) return "Monster not found";

        int damage = 10 + player.getStrength();
        monster.setHealth(monster.getHealth() - damage);

        if (monster.getHealth() <= 0) {
            player.getInventory().add(monster.getLoot());
            return "Monster defeated. Loot: " + monster.getLoot();
        }
        return "Monster attacked, Remaining HP: " + monster.getHealth();
    }

    public void assignQuest(String playerId, Quest quest) {
        Player player = players.get(playerId);
        if (player != null) {
            player.getActiveQuests().add(quest);
        }
    }

    public void addMonster(Monster monster) {
        monsters.put(monster.getId(), monster);
    }

    public void addQuest(Quest quest) {
        quests.put(quest.getId(), quest);
    }
}