package WoV.model;

import lombok.Data;

import java.util.List;

@Data
public class Quest {
    private String id;
    private String title;
    private String description;
    private int requiredLevel;
    private int rewardXP;
    private List<String> rewardItems;
    private boolean completed;
    private String objective;
}