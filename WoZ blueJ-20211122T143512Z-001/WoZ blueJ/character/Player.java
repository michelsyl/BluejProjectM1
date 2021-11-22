package character;

import Item.Item;
import java.util.ArrayList;

public class Player extends Character {

    // attributs :
    protected int nblife = 3;

    private final int MAX_LIFE = 3;
    private final int MIN_LIFE = 0;
    private ArrayList<Item> Joker;
    private ArrayList<Item> PotionLife;
    public int coins;

    /**
     * Constructeur
     * @param name
     */
    public Player(String name){

        super(name,150,300);
        Joker= new ArrayList<Item>();
        PotionLife = new ArrayList<Item>();
    }

    // getteur :
    /**
     *
     * @return nblife
     */
    public int getNblife() {
        return nblife;
    }

    /**
     *
     * @return int
     */
    public int getNbPotionLife(){
        if (PotionLife.size()!=0) {
            return PotionLife.size();
        }else{
            return 0;
        }
    }

    /**
     *
     * @return int
     */
    public int getnbJoker(){
        if (Joker.size()!=0) {
            return Joker.size();
        }else{
            return 0;
        }
    }

    /**
     *
     */
    public void addItem(){

    }
    /**
     *
     */
    public void useItem(){

    }
    /**
     *
     */
    public void moveUp(){
        if((yPosition-2>50+rayon)&&
                (yPosition-2>250+rayon ||xPosition>200)&&
                (yPosition-2>150+rayon || (xPosition>300 && xPosition<500))&&
                (yPosition-2>350+rayon||(xPosition<400||xPosition>500)||yPosition-2<250+rayon)){
            yPosition=yPosition-2;
        }
    }

    /**
     *
     */
    public void moveDown(){
        if((yPosition+2<550-rayon)&&
                (yPosition+2<350-rayon|| xPosition>300)&&
                (yPosition+2<250-rayon|| xPosition>500 || xPosition<400 || yPosition+2>350-rayon)&&
                (yPosition+2<450-rayon|| xPosition<400)){
            yPosition=yPosition+2;
        }

    }

    /**
     *
     */
    public void moveLeft(){

        if((xPosition-2>100+rayon)&&
                (xPosition-2>200+rayon || (yPosition>250 && yPosition<350 ))&&
                (xPosition-2>300+rayon || (yPosition>150&& yPosition<350))&&
                (xPosition-2>500+rayon||yPosition>350|| yPosition<250||xPosition-2<400+rayon)){
            xPosition=xPosition-2;
        }
    }

    /**
     *
     */
    public void moveRight(){
        if (( xPosition+2<600-rayon)&&
                (xPosition+2<400-rayon || (yPosition>350 || yPosition<250 )&&yPosition<450||xPosition+2>500-rayon) &&
                (xPosition+2<500-rayon || yPosition>150)){
            xPosition=xPosition+2;
        }

    }

    /**
     *
     */
    public void loseLifePoints(){
        nblife--;
    }

    /**
     *
     * @param coins
     */
    public void setCoins(int coins){
        this.coins+=coins;

    }


}