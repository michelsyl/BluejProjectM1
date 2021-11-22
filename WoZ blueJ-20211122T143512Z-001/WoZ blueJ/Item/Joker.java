package Item;
import character.Enigma;

public class Joker extends Item{
    public void use(Enigma enigma){
        enigma.giveClues();
    }
}