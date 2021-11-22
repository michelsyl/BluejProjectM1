package Room;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Room {

    private ArrayList posxwall;
    private ArrayList posywall;
    private int longu;
    private ArrayList horizontal;

    private String name;
    public ArrayList<Door> Doors;
    private int nbDoor;
    protected static Map<String, String> map;
    private static boolean test=true;

    /**
     * Constructeur
     * @param name
     */
    public Room(String name,int nbDoor, int posxSalle, int posySalle){
        if(test) {
            map = new HashMap<String, String>();
            map.put("1", "left");

            map.put("3", "right");

            map.put("5", "up");
            map.put("5", "left");
            map.put("5", "right");

            map.put("6", "up");
            map.put("6", "down");

            map.put("7", "down");
            map.put("7", "left");

            map.put("10", "left");
            map.put("10", "down");

            map.put("11", "left");

            map.put("13", "left");
            test=false;
        }

        horizontal=new ArrayList<>();
        posxwall=new ArrayList<>();
        posywall=new ArrayList<>();

        this.name=name;
        this.nbDoor=nbDoor;

        horizontal.add(true);
        horizontal.add(true);
        horizontal.add(false);
        horizontal.add(false);

        posxwall.add(posxSalle);
        posxwall.add(posxSalle);
        posxwall.add(posxSalle+50);
        posxwall.add(posxSalle-50);

        posywall.add(posySalle+50);
        posywall.add(posySalle-50);
        posywall.add(posySalle);
        posywall.add(posySalle);

    }

    /**
     *
     */
    public void createDoor(){

    }

    /**
     * tracer la salle dans la zone de jeu
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);

        //salle du boss plus grande donc on le fait a part
        if (this.name=="Boss"){
            int counter=0;
            for (int i = 0; i < 4; i++) {
                if ((boolean) horizontal.get(i)) {
                    if(counter==0) {
                        g.drawLine((int) posxwall.get(i) - 50, (int) posywall.get(i) + 50, (int) posxwall.get(i) + 50, (int) posywall.get(i) + 50);
                        counter++;
                    }else{
                        g.drawLine((int) posxwall.get(i) - 50, (int) posywall.get(i) - 50, (int) posxwall.get(i) + 50, (int) posywall.get(i) - 50);
                        counter--;
                    }
                } else {
                    g.drawLine((int) posxwall.get(i), (int) posywall.get(i) - 100, (int) posxwall.get(i), (int) posywall.get(i) + 100);
                }
            }
        }// toutes les autres salles:
        else {
            for (int i = 0; i < 4; i++) {
                if ((boolean) horizontal.get(i)) {
                    g.drawLine((int) posxwall.get(i) - 50, (int) posywall.get(i), (int) posxwall.get(i) + 50, (int) posywall.get(i));
                } else {
                    g.drawLine((int) posxwall.get(i), (int) posywall.get(i) - 50, (int) posxwall.get(i), (int) posywall.get(i) + 50);
                }

            }
        }
    }

}