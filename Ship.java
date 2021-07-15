import java.util.Random;

public class Ship {
    Random rnd = new Random();
    private int hp;
    private String name;
    private int x;
    private int y;


    public Ship(String[][] map, String sname){
        this.hp = 3;
        this.name = sname;
        moveShip(map);
    }


    public void shipStutas(){
        if(hp > 0){
            System.out.printf("%sはまだ生きている 残りHP:%d\n", name, hp);
        }else if(hp == 0){
            System.out.printf("%s:撃沈 残りHP:%d\n", name, hp);
        }
    }


    public void hitBomb(String[][] map, int X, int Y){
        if(map[X][Y].equals(name) ){
            if(hp > 1){
                System.out.printf("%s:爆弾が当たった！しかし%sはまだ沈まない！%sが移動します。\n", name, name, name);
                hp--;
                map[X][Y] = "none";
                moveShip(map);
            }else if(hp == 1){
                System.out.printf("%s:三回爆弾が当たったため%sが沈んだ！\n", name, name);
                hp--;
                map[X][Y] = "none";
            }
        }else if(map[X+1][Y].equals(name) ||
                map[X-1][Y].equals(name) ||
                map[X][Y+1].equals(name) ||
                map[X][Y-1].equals(name) ){
                    System.out.printf("%s:爆弾が近くに落ちた！\n", name);
        }else{
            if(hp == 0){
                System.out.printf("%s:撃破済み。\n", name);
            }else{
                System.out.printf("%s:爆弾は当たらなかった！\n", name);
            }
        }
    }

    public void moveShip(String[][] map){
        do{
            x = rnd.nextInt(5);
            y = rnd.nextInt(5);
            if(map[x+1][y+1].equals("none")){
                map[x+1][y+1] = name;
            }
        }while( !(map[x+1][y+1].equals(name) ) );
    }

}
