package WoV.model;

import lombok.Data;

@Data
public class Monster {
    private String id;
    private String name;
    private String type;
    private int level;
    private int health;
    private int attackPower;
    private int defense;
    private boolean boss;
    private String loot;
}