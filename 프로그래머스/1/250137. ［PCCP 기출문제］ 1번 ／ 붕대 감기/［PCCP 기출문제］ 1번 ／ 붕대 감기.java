class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int attacksIdx = 0;
        int run = 0;
        int bandageCnt = 0;
        while (true) {
            run++;
            bandageCnt++;
            if (health <= 0 || attacksIdx == attacks.length) {
                if (health <= 0) health = -1;
                break;
            }
            if (attacks[attacksIdx][0] == run) {
                health -= attacks[attacksIdx][1];
                attacksIdx++;
                bandageCnt = 0;
                continue;
            }
            if (bandageCnt % bandage[0] == 0) {
                health += bandage[2];
                if (health > maxHealth) health = maxHealth;
                bandageCnt = 0;
            }
            health += bandage[1];
            if (health > maxHealth) health = maxHealth;
        }
        return health;
    }
}