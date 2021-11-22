import character.Enigma;

import javax.swing.*;

public class main { //zone de test
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                creerEtAfficherLaFenetre();
            }
        });
    }

    private static void creerEtAfficherLaFenetre() {
        JFrame maFenetre = new Fenetre("WoZ") ;
    }



}