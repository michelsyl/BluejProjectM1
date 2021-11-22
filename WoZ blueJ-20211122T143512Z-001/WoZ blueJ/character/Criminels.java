package character;

public class Criminels extends Character {

    public Enigma enigma;
    public static int counter = 0;
    private int coins = 4;
    /**
     * Constructeur
     * @param name
     */
    public Criminels(String name,int posx,int posy){
        super(name,posx,posy);

    }

    /**
     *
     * @param enigma
     */
    public void createEnigma(Enigma enigma){
        this.enigma=enigma;
        counter++;
    }

    /**
     *
     */
    public void setCoins(){
        this.coins=this.coins-2;
    }
    /**
     *
     */
    public void giveEnigma(){
        System.out.println(enigma.toString());
    }

    /**
     *
     * @param player
     */
    public void attaque(Player player){
        player.loseLifePoints();

    }

    /**
     *
     * @param player
     */
    public void giveCoins(Player player){
        player.setCoins(this.coins);
    }
}
