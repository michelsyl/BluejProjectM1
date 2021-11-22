package character;

import Item.Item;
import java.util.ArrayList;

public class Marchand extends Character {
    protected ArrayList<Item> Items;

    /**
     * Constructeur
     * @param name
     */
    public Marchand(String name,int posx,int posy){
        super(name,posx,posy);
    }

    /**
     * @param nb est le nombre correspond à l'item acheté par le player
     * @return Items
     */
    public Item buyItem(int nb){
        Item i = Items.get(nb);
        Items.remove(nb);
        return i;
    }
}