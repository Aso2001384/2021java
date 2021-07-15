import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("****************************");
        System.out.println("　　　 　 戦艦ゲーム         ");
        System.out.println("****************************");
        Scanner sc = new Scanner(System.in);

        int x;
        int y;

        String[][] map = new String[7][7];
        //マップ外のエリア
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                map[i][j] = "out";
            }
        }
        //マップ内のエリア
        for(int i=1; i<map.length-1; i++){
            for(int j=1; j<map[i].length-1; j++){
                map[i][j] = "none";
            }
        }
        
        Ship ship1 = new Ship(map, "戦艦1");
        Ship ship2 = new Ship(map, "戦艦2");
        Ship ship3 = new Ship(map, "戦艦3");

        boolean flg = true;
        int turn = 0;

        while(flg){
            turn++;
            System.out.printf("----------[ターン%d]----------\n", turn);
            ship1.shipStutas();
            ship2.shipStutas();
            ship3.shipStutas();

            do{
                System.out.println("爆弾のx座標を1-5から入力してください。ゲームを止める場合は99を入力してください。");
                x = sc.nextInt();
                if(x == 99){
                    System.out.println("ゲームを終了します。");
                    System.exit(0);
                }
            }while(x < 1 || x > 5);

            do{
                System.out.println("爆弾のy座標を1-5から入力してください。ゲームを止める場合は99を入力してください。");
                y = sc.nextInt();
                if(y == 99){
                    System.out.println("ゲームを終了します。");
                    System.exit(0);
                }
            }while(y < 1 || y > 5);

            ship1.hitBomb(map, x, y);
            ship2.hitBomb(map, x, y);
            ship3.hitBomb(map, x, y);

            for(int i=1; i<map.length-1; i++){
                for(int j=1; j<map[i].length-1; j++){
                    if(map[i][j].equals("none") ){
                        flg = false;
                    }else{
                        flg = true;
                        break;
                    }
                }
                if(flg){
                    break;
                }
            }
        }
        System.out.println("****************************");
        System.out.printf("   %dターンでゲームクリア！   \n", turn);
        System.out.println("****************************");
        
        sc.close();
    }
}
