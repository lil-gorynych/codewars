class Warrior {
    public int level;
    public int experience;
    public String rank;

    final String[] ranks = new String[]{
            "Pushover", "Novice", "Fighter", "Warrior", "Veteran",
            "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest"};


    public Warrior() {
        this.level = 1;
        this.experience = 100;
        this.rank = this.ranks[0];
    }

    public String battle (int level) {
        //Exceptions
        if (level < 1 || 100 < level) { return "Invalid level"; }


        int diff = this.level - level;
        //if lower or equal
        if (diff == 0) { changeExperience(10); return "A good fight";}
        if (diff == 1) { changeExperience(5 ); return "A good fight";}
        if (diff >= 2) { changeExperience(0 ); return "Easy fight"; }
        //if higher
        if ()


    }

    private void changeExperience (int xp) {
        this.experience += xp;
        updateLevel();
    }
    private void updateLevel() {
        if (this.experience / 100 != this.level) {
            if (this.experience / 100 <= 100) {
                this.level = this.experience / 100;
            } else {
                this.level = 100;
            }
        }
        updateRank();
    }
    private void updateRank() {
        this.rank = ranks[this.level / 10];
    }
    private int getIntRank (int level) {
        return this.level / 10;
    }


}