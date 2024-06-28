class Solution {
    public static int currentTime;
    public static int[] attackTimes;
    public static int[] damages;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        setAttacks(attacks);
        User user = play(new User(health, health, bandage[1], bandage[2], bandage[0]));
        return user.getHp() > 0 ? user.getHp() : -1;
    }
    
    private void setAttacks(int[][] attacks){
        attackTimes = new int[attacks.length];
        damages = new int[attacks.length];
        int i = 0;
        for(int[] attack: attacks){
            attackTimes[i] = attack[0];
            damages[i++] = attack[1];
        }
    }
    
    private User play(User user){
        int idx = 0;
        int bandageTime = 0;
        int previousAttackTime = 0;
        for(currentTime = 0; currentTime<=attackTimes[attackTimes.length-1]; currentTime++){
            
            System.out.println("currentTime : "+currentTime);
            
            if(currentTime == attackTimes[idx]){
                
                System.out.println("monster attack ! : -"+damages[idx]);
                
                previousAttackTime = attackTimes[idx];
                user.setHp(user.getHp() - damages[idx++]);
                bandageTime = 0;
            } else {
                user.getHeal(user.getHpPerSec());
                bandageTime = currentTime-previousAttackTime;
                if(bandageTime == user.getBandageTime()){
                    bandageTime = 0;
                    previousAttackTime = currentTime;
                    user.getHeal(user.getBandageHeal());
                }
            }
            System.out.println("bandageTime : "+bandageTime);
            System.out.println("user hp : "+user.getHp());
            
            if(user.getHp() <= 0){
                break;
            }
        }
        return user;
    }
}

class User{
    private int maxHp;
    private int hp;
    private int hpPerSec;
    private int bandageHeal;
    private int bandageTime;

    public User(int maxHp, int hp, int hpPerSec, int bandageHeal, int bandageTime){
        this.hp = hp;
        this.maxHp = maxHp;
        this.hpPerSec = hpPerSec;
        this.bandageHeal = bandageHeal;
        this.bandageTime = bandageTime;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getBandageTime(){
        return this.bandageTime;
    }
    public int getHp(){
        return this.hp;
    }
    public int getHpPerSec(){
        return this.hpPerSec;
    }
    public int getBandageHeal(){
        return this.bandageHeal;
    }
    public void getHeal(int healAmount){
        this.hp += healAmount;
        if(this.hp > maxHp){
            this.hp = maxHp;
        }
    }
}