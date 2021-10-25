package rpgcreature;

import java.util.Random;

/**
 * ゴーレムクラス
 */
public class Golem extends Monster{
    private final static int CRITICAL_HIT_RATE = 5;

    /**
     * ゴーレムクラスのコンストラクタ
     */
    public Golem(){
        super("ゴーレム",100);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();

        if(r.nextInt(100) < CRITICAL_HIT_RATE){
            int damage = 30;
            opponent.damaged(damage);
            System.out.printf("%sのクリティカルヒット！\n",getName());
        }else{
            int damage = r.nextInt(6) + 5;
            System.out.printf("%sの攻撃！\n",getName());
            
            opponent.damaged(damage);
            
            displayMessage(opponent,damage);
        }
        
    }
    
}