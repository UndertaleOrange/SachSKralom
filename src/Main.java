import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[][] plocha = new String[10][10];
        plocha[0][0] = "0";
        boolean position = false;
        ArrayList<String> plocha2 = new ArrayList<String>();
        start(plocha,plocha2);
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while(position == false) {
            System.out.println("X Súradnica kráľa: ");
            x = sc.nextInt();
            System.out.println("Y Súradnica kráľa: ");
            y = sc.nextInt();
            if (x > 0 && x <= 8 && y > 0 && y <= 8) {
                position = true;
            } else {
                System.out.println("Zadal si nesprávne súradnice");
                position = false;
            }
        }
        refresh(plocha,plocha2,x,y);

    }
    static void start(String[][] plocha, ArrayList<String> plocha2){
        for(int i = 0; i <= 8; i++){
            for(int a = 0; a <= 8; a++){
                plocha[i][a] = "0";
            }
        }
        for(int i = 1; i <= 8; i++){
            for(int a = 1; a <= 8; a++){
                plocha2.add(plocha[i][a]);
            }
            System.out.println(plocha2);
            plocha2.clear();
        }


    }
    static void refresh(String[][] plocha, ArrayList<String> plocha2, int x, int y){
        ArrayList<String> policka = new ArrayList<String>();
        for(int i = 0; i <= 8; i++){
            for(int a = 0; a <= 8; a++){
                if(i == x && a == y){
                plocha[i][a] = "K";
                } else {
                    if((i == x-1 && x-1 > 0 && x-1 <= 8 || i == x || i == x+1 && x+1 > 0 && x+1 <= 8) && (a == y-1 && y-1 > 0 && y-1 <= 8 || a == y || a == y+1 && y+1 > 0 && y+1 <= 8)) {
                        plocha[i][a] = "█";
                        String policko =  Integer.toString(a) + "," +  Integer.toString(i);
                        policka.add(policko);
                    }else{
                        plocha[i][a] = "0";
                    }
                }
            }
        }
        for(int i = 1; i <= 8; i++){
            for(int a = 1; a <= 8; a++){
                plocha2.add(plocha[i][a]);
            }
            System.out.println(plocha2);
            plocha2.clear();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Tvoja aktualna pozícia: X = " + x + ", Y = " + y);
        System.out.println("Miesta na ktoré sa môžeš pohnúť: ");
        for(int i=0;i<policka.size();i++){
            System.out.print(policka.get(i) + " // ");
        }
        System.out.println("");
        System.out.println("Napíš súradnicu X, na ktorú sa pohneš: ");
        int newx = sc.nextInt();
        System.out.println("Napíš súradnicu Y, na ktorú sa pohneš: ");
        int newy = sc.nextInt();

        if((newx == x-1 || newx == x || newx == x+1) && (newy == y-1 || newy == y || newy == y+1) && !(newx == x && newy == y) && (newx > 0 && newx <= 8 && newy > 0 && newy <= 8)) {
            x = newx;
            y = newy;
                refresh(plocha, plocha2, x, y);

        }else{
            System.out.println("Kráľ sa tam nemôže pohnúť");
                refresh(plocha, plocha2, x, y);
        }
    }
    static void position(){
        Scanner sc = new Scanner(System.in);
        System.out.println("X Súradnica kráľa: ");
        int x = sc.nextInt();
        System.out.println("Y Súradnica kráľa: ");
        int y = sc.nextInt();
        if(x > 0 && x <= 8 && y > 0 && y <= 8){

        }else{
            System.out.println("Zadal si nesprávne súradnice");
            position();
        }
    }
}
