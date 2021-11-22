package character;

import java.awt.*;

public class Character {

    //attributs:
    protected String name;
    protected int xPosition;
    protected int yPosition;


    protected int rayon=10;

    /**
     * Constructeur
     * @param name
     */
    public Character(String name, int posx, int posy){
        this.xPosition=posx;
        this.yPosition=posy;
        this.name=name;
    }

    // getter :

    /**
     *
     * @return rayon
     */
    public int getRayon(){
        return rayon;
    }
    /**
     *
     * @return xPosition
     */
    public int getxPosition() {
        return xPosition;
    }
    /**
     *
     * @return yPosition
     */
    public int getyPosition() {
        return yPosition;
    }
   /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    // setter :
   /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param i
     */
    public void setyPosition(int i){
        this.yPosition=i;
    }

    /**
     *
     * @param i
     */
    public void setxPosition(int i){
        this.xPosition=i;
    }


    public void tracer(Graphics g, Color color){

        //le rond
        g.setColor(color);
        g.fillOval(this.xPosition-this.rayon,this.yPosition-this.rayon,2*this.rayon,2*this.rayon);

        //le contour du rond
        g.setColor(Color.BLACK);
        g.drawOval(this.xPosition-this.rayon,this.yPosition-this.rayon,2*this.rayon,2*this.rayon);

    }


}