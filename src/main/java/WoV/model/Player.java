package WoV.model;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private String id;
    private String name;
    private String race;
    private String playerClass;
    private int level;
    private int health;
    private int mana;
    private int experience;
    private List<Quest> activeQuests;
    private List<String> inventory;
    private int strength;
    private int agility;
    private int intelligence;
}