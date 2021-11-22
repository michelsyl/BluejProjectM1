package character;

import java.util.ArrayList;

public class Boss extends Character{

    public ArrayList<Enigma> enigma;
    public static int counter = 0;

    /**
     * Constructeur
     * @param name
     */
    public Boss(String name){

        super(name,550,250);
        enigma=new ArrayList<>();
        enigma.add(new Enigma("banane","Quel fruit est jaune?"));
        enigma.add(new Enigma("tomate","Quel fruit est peut etre aussi un legume?"));
        enigma.add(new Enigma("kiwi","Quel fruit est vert à l'interieur?"));
    }
    /**
     *
     */
    public void giveEnigma(){
        System.out.println(enigma.get(counter).toString());
        counter++;
    }
}