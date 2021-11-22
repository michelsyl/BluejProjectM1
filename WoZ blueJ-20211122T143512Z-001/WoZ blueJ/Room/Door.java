package Room;

import java.awt.*;

public class Door {

    public String position;
    public boolean lock;
    public static int counter=1;
    /**
     * Constructeur
     */
    public Door(boolean lock, String position){
        this.position=position;
        this.lock=lock;
    }

    /**
     * tracer la porte dans la zone de jeu
     * @param g
     */
    public void draw(Graphics g){
        Color color=Color.GRAY;

    }
}