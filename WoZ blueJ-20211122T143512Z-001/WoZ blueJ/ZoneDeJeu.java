import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Room.Room;
import character.Boss;
import character.Criminels;
import character.Marchand;
import character.Player;

public class ZoneDeJeu extends JPanel{

    // Attributs
    // Les mobiles présents dans la zone de jeu
    public  Player player ;
    private  ArrayList<Criminels> criminels;
    private  ArrayList<Marchand> marchands;
    private  Boss boss;
    private  ArrayList<Room> Rooms;

    public int []posxSalle={150,250,250,350,350,350,350,350,450,450,450,550,550};
    public int []posySalle={300,300,200,100,200,300,400,500,100,200,400,400,250};
    // Constantes de dimension
    private final int LARGEUR = 1000 , HAUTEUR = 800 ;

    /**
     * Constructeur
     */
    public ZoneDeJeu(Player player) {
        this.player=player;
        createCriminel();
        createMarchand();
        createBoss();
        createRoomAndDoor();
        this.setSize(LARGEUR, HAUTEUR);
    }

    /**
     * creation criminels
     */
    public void createCriminel(){
        this.criminels=new ArrayList<>();
        int []posxCriminels={250,350,350,450,550,250,350,450,450};
        int []posyCriminels={300,300,500,400,400,200,100,100,200};

        for(int i =0; i<8;i++){
            String name= "criminel "+i;
            criminels.add(new Criminels(name,posxCriminels[i],posyCriminels[i]));
        }
    }

    /**
     * creation marchands
     */
    public void createMarchand(){
        marchands=new ArrayList<>();
        int []posxMarchand={480,480};
        int[] posyMarchand={430,70};

        for (int i=0;i<2;i++){
            String name="marchand "+i;
            marchands.add(new Marchand(name,posxMarchand[i],posyMarchand[i]));
        }
    }

    /**
     * creation boss
     */
    public void createBoss(){
        this.boss=new Boss("boss");
    }

    /**
     * creation salles et portes
     */
    public void createRoomAndDoor (){
        String roomName;
        //creation salle
        Rooms=new ArrayList<>();


        //creation des portes
        int []nbDoor={1,2,1,1,4,3,3,1,1,3,2,2,1};


        for (int i=1;i<=13;i++){
            if(i==13){
                roomName = "Boss";
            }else {
                roomName = "Room " + i;
            }
            Rooms.add(new Room(roomName, nbDoor[i-1], posxSalle[i-1], posySalle[i-1]));
        }
    }


    /**
     * function to move up
     */
    public void up(){
            if(!collision("up")){
                player.moveUp();
            }

    }

    /**
     * function to move down
     */
    public void down(){
        if(!collision("down")){
            player.moveDown();
        }

    }

    /**
     * function to move left
     */
    public void left(){
        if(!collision("left")){
            player.moveLeft();
        }

    }

    /**
     * function to move right
     */
    public void right(){
        if(!collision("right")){
            player.moveRight();
        }

    }

    // Permet de donner les dimensions de départ, 
    //redéfinition (override) de la méthode getPreferredSize de JPanel
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LARGEUR,HAUTEUR);
    }

    // Définit comment seront tracés les composants graphiques de l'aire de jeu
    @Override
    public void paintComponent(Graphics gr) {
            addFontRoom(gr);
            //dessine le joueur
            this.player.tracer(gr, Color.PINK);
            //dessine le boss
            this.boss.tracer(gr, Color.RED);
            //dessine les criminels
            for(int i=0; i<criminels.size();i++){
                this.criminels.get(i).tracer(gr,Color.BLUE);
            }
            //dessine les marchands
            for (int i=0;i<marchands.size();i++) {
                this.marchands.get(i).tracer(gr, Color.GREEN);
            }
            for (int i=0;i< Rooms.size();i++){

                this.Rooms.get(i).draw(gr);

            }

    }

    /**
     *
     * @param g
     */
    public void addFontRoom(Graphics g){
        BufferedImage img=null;
        try {
            img = ImageIO.read(new File("src//donjon.jpg"));
        } catch (IOException e) {
            System.out.println(" ca marche pas"+ e);
        }
        for (int i=0;i<posxSalle.length;i++) {
            if (i==posxSalle.length-1){
                g.drawImage(img, (int) posxSalle[i] - 50, (int) posySalle[i] - 100, 100, 100, null);
                g.drawImage(img, (int) posxSalle[i] - 50, (int) posySalle[i] , 100, 100, null);
            }else{
                g.drawImage(img, (int) posxSalle[i] - 50, (int) posySalle[i] - 50, 100, 100, null);
            }

        }
    }
    private boolean collision(String sens){
        for (Criminels c:criminels) {
            if (sens == "down") {
                return ((player.getyPosition() + player.getRayon()) == c.getyPosition()-c.getRayon())&&((player.getxPosition()) == c.getxPosition());
            }
            if (sens == "up") {
                return ((player.getyPosition() - player.getRayon()) == c.getyPosition()+c.getRayon())&&((player.getxPosition()) == c.getxPosition());
            }
            if (sens == "left") {
                return ((player.getxPosition() - player.getRayon()) == c.getxPosition()+c.getRayon())&&((player.getyPosition()) == c.getyPosition());
            }if(sens=="right"){
                return ((player.getxPosition()+player.getRayon())==c.getxPosition()-c.getRayon())&&((player.getyPosition()) == c.getyPosition());
            }
        }
        return false;
    }
}