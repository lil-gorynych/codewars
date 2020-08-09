import java.util.ArrayList;
import java.util.List;

class Warrior {
    private int level;
    private int experience;
    private String rank;
    private final List<String> achievements = new ArrayList<>();

    final String[] ranks = new String[]{
            "Pushover", "Novice", "Fighter", "Warrior", "Veteran",
            "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest"};


    public Warrior() {
        this.level = 1;
        this.experience = 100;
        this.rank = this.ranks[0];
    }

    public int level() {
        return this.level;
    }
    public int experience () {
        return this.experience;
    }
    public String rank() {
        return this.rank;
    }

    public List<String> achievements() {
        return this.achievements;
    }


    public String battle (int level) {
        //Exceptions
        if (level < 1 || 100 < level) { return "Invalid level"; }


        int diff = this.level - level;
        System.out.println(diff);
        //if lower or equal
        if (diff == 0) { changeExperience(10); return "A good fight";}
        if (diff == 1) { changeExperience(5 ); return "A good fight";}
        if (diff >= 2) { changeExperience(0 ); return "Easy fight"; }

        //if higher
        if (diff <= -5 && getIntRank(this.level) < getIntRank(level)) { return "You've been defeated"; }
        changeExperience(20 * diff*diff);
        return "An intense fight";
    }

    public String training (String description, int xp, int minLevel) {
        if (this.level >= minLevel) {
            this.achievements.add(description);
            changeExperience(xp);
            return description;
        }
        return "Not strong enough";
    }

    private void changeExperience (int xp) {
        this.experience += xp;
        if (this.experience > 10000) { this.experience = 10000; }
        updateLevel();
    }
    private void updateLevel() {
        if (this.experience / 100 != this.level) {
            this.level = Math.min(this.experience / 100, 100);
        }
        updateRank();
    }
    private void updateRank() {
        this.rank = ranks[this.level / 10];
    }
    private int getIntRank (int level) {
        return level / 10;
    }


}