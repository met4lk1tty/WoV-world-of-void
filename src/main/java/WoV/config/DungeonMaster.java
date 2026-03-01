package WoV.config;

import WoV.model.Monster;
import WoV.model.Quest;
import WoV.service.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DungeonMaster implements CommandLineRunner {

    private final GameService gameService;

    public DungeonMaster(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        Monster voidDrake = new Monster();
        voidDrake.setId(UUID.randomUUID().toString());
        voidDrake.setName("Void Drake");
        voidDrake.setType("Dragon");
        voidDrake.setLevel(12);
        voidDrake.setHealth(600);
        voidDrake.setAttackPower(80);
        voidDrake.setBoss(true);
        voidDrake.setLoot("Void Scale Armor");
        gameService.addMonster(voidDrake);

        Monster abyssalTroll = new Monster();
        abyssalTroll.setId(UUID.randomUUID().toString());
        abyssalTroll.setName("Abyssal Troll");
        abyssalTroll.setType("Troll");
        abyssalTroll.setLevel(6);
        abyssalTroll.setHealth(180);
        abyssalTroll.setAttackPower(30);
        abyssalTroll.setBoss(false);
        abyssalTroll.setLoot("Void Club");
        gameService.addMonster(abyssalTroll);

        Monster voidSpider = new Monster();
        voidSpider.setId(UUID.randomUUID().toString());
        voidSpider.setName("Void Spider");
        voidSpider.setType("Beast");
        voidSpider.setLevel(3);
        voidSpider.setHealth(100);
        voidSpider.setAttackPower(18);
        voidSpider.setBoss(false);
        voidSpider.setLoot("Venom Sac");
        gameService.addMonster(voidSpider);

        Quest quest1 = new Quest();
        quest1.setId(UUID.randomUUID().toString());
        quest1.setTitle("Exterminate the Void Spider");
        quest1.setDescription("Void Spiders have infested the dark forest. Eliminate them!");
        quest1.setRequiredLevel(2);
        quest1.setRewardXP(80);
        quest1.setRewardItems(List.of("Venom Sac", "Health Potion"));
        quest1.setObjective("Kill 5 Void Spiders");
        gameService.addQuest(quest1);

        Quest quest2 = new Quest();
        quest2.setId(UUID.randomUUID().toString());
        quest2.setTitle("Confront the Abyssal Troll");
        quest2.setDescription("The Abyssal Troll is threatening nearby villages. Stop it!");
        quest2.setRequiredLevel(5);
        quest2.setRewardXP(200);
        quest2.setRewardItems(List.of("Void Club", "Mana Potion"));
        quest2.setObjective("Kill the Abyssal Troll");
        gameService.addQuest(quest2);

        Quest quest3 = new Quest();
        quest3.setId(UUID.randomUUID().toString());
        quest3.setTitle("Face the Void Drake");
        quest3.setDescription("The Void Drake has awakened. Only the strongest heroes can defeat it.");
        quest3.setRequiredLevel(10);
        quest3.setRewardXP(600);
        quest3.setRewardItems(List.of("Void Scale Armor", "Legendary Sword"));
        quest3.setObjective("Kill the Void Drake");
        gameService.addQuest(quest3);
    }
}