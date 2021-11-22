import character.Criminels;
import character.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ConsoleDeJeu extends JPanel   {
    /* ConsoleDeJeu hérite de la classe JPanel,
     Donc, tous les objets de la classe ConsoleDeJeu possèdent
     les attributs et les méthodes de la classe JPanel
     plus les attributs et méthodes définis ici*/
    public Player player;
    // Attributs : La zone de jeu et la barre des boutons
    private final ZoneDeJeu maZoneDeJeu ;
    private final JMenuBar maBarreDeBoutons ;
    private final JMenuBar maBarrePseudo ;
    // Constantes
    // les mobiles se déplacent tous les 50ms
    private final int PERIODE_DE_RAFFRAICHISSEMENT = 50 ;

    // Constructeur
    public ConsoleDeJeu() {
        String name="";

        this.player=new Player(name);
        this.setBackground(Color.BLACK);
        // Mettre en place un découpage en zones (nord, sud, est ouest, centre)
        this.setLayout(new BorderLayout());
        this.setFocusable(true);

        // Créer la barre des boutons et les boutons
        this.maBarreDeBoutons = creerBarreDeBoutons() ;
        this.maBarrePseudo=creerBarrePseudo();

        // Placer la barre des boutons au sud
        this.add(this.maBarreDeBoutons, BorderLayout.SOUTH);

        // Placer la barre du pseudo au nord
        this.add(this.maBarrePseudo, BorderLayout.NORTH);
        // Détecte les événements liés à la souris et associe des actions à ces événements
        ajouterLesGestionnairesDEvenementSouris() ;

        // Détecte les événements liés au clavier et associe des actions à ces événements
        ajouterLesGestionnairesDEvenementClavier() ;


        // Créer le maZoneDeJeu de jeu
        maZoneDeJeu = new ZoneDeJeu(player) ;

        // Ajouter le maZoneDeJeu dans la game Boy, au centre
        this.add(maZoneDeJeu, BorderLayout.CENTER);

        // Ajouter des mobiles dans maZoneDeJeu


        // Démarrer le jeu
        this.lancerLeJeu() ;
    }

    private void lancerLeJeu(){
        /* Création d'un thread
            permet de gérer plusieurs éléments séparément :
                - le déplacement des gluons
                - la gestion des événements lié à la souris ou au clavier
        */
        Thread threadDuJeu = new Thread()
        {
            @Override
            public void run(){
                /*********************************************/
                /**** Ceci est la boucle principale du jeu ***/
                /*********************************************/
                Boolean fin;
                do{
                    //  System.out.println("Un tour de boucle principale");
                    // Ici, placer les instructions affectant les characters
                    fin=GameOver();


                    repaint() ;// Trace tous les éléments
                    try{ // Temporisation
                        Thread.sleep(PERIODE_DE_RAFFRAICHISSEMENT);
                    } catch(InterruptedException ex){
                        // A exécuter si une interruption intervient durant le sleep
                    }
                }while(!fin);
                // On peut choisir d'arrêter le jeu en plaçant une condition ici
            }
        } ;// Fin de la création du thread
        threadDuJeu.start();// Lancement du thread
    }


    private  JMenuBar creerBarreDeBoutons(){
        // Création des menus
        JMenuBar leMenu = new JMenuBar() ;
        // Création des boutons
        JLabel text = new JLabel("  Inventory  " );
        JButton bouton1 = new JButton("Life Potion "+player.getNbPotionLife()) ;
        JLabel textVide = new JLabel("    ");
        JButton bouton2 = new JButton("Joker "+player.getnbJoker()) ;

        // Ajout des boutons
        leMenu.add(text) ;
        leMenu.add(bouton1) ;
        leMenu.add(textVide) ;
        leMenu.add(bouton2) ;

        bouton1.addActionListener((ActionEvent arg0) -> {
            System.out.println("Inventory effectuée");

        });
        bouton2.addActionListener((ActionEvent arg0) -> {
            System.out.println("Inventory effectuée");

        });

        return leMenu ;
    }
    private  JMenuBar creerBarrePseudo(){
        // Création des menus
        JMenuBar leMenu = new JMenuBar() ;
        // Création des boutons
        JButton bouton1 = new JButton("Ok") ;
        //creation zone de texte
        JTextField text1 = new JTextField();
        JLabel text2 = new JLabel();
        JLabel text3 = new JLabel("Enter a nickname");
        //ajout zone de texte
        leMenu.add(text3);
        leMenu.add(text1);
        leMenu.add(text2);
        // Ajout des boutons
        leMenu.add(bouton1) ;

        bouton1.addActionListener((ActionEvent arg0) -> {
            player.setName(text1.getText());

            leMenu.remove(text1);
            leMenu.remove(text3);
            leMenu.remove(bouton1);

            text2.setText("Hello "+player.getName()+" we are going to play a game");
            JLabel text4 = new JLabel("  //   Life : "+player.getNblife());
            leMenu.add(text4);

            System.out.println("Pseudo enregistré");

        });

        return leMenu ;
    }

    // fonction obligatoire meme si on l'utilise aps
    private void ajouterLesGestionnairesDEvenementSouris() {
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
            }
        });
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
            }
        });
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
            }
        });
    }

    public void ajouterLesGestionnairesDEvenementClavier(){

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //boutons z et fleche du haut
                if(e.getKeyCode()==38||e.getKeyCode()==90) {
                    maZoneDeJeu.up();
                }//boutons q et fleche de gauche
                if(e.getKeyCode()==37||e.getKeyCode()==81) {
                    maZoneDeJeu.left();
                }//boutons s et fleche du bas
                if(e.getKeyCode()==40||e.getKeyCode()==83) {
                    maZoneDeJeu.down();
                }//boutons d et fleche de droite
                if(e.getKeyCode()==39||e.getKeyCode()==68) {
                    maZoneDeJeu.right();
                }//bouton i
                if(e.getKeyCode()==73) {
                    System.out.println("inventory: " + e.getKeyChar() + " " + e.getKeyCode());
                }
                System.out.println("test: " + e.getKeyChar() + " " + e.getKeyCode());

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }public boolean GameOver(){
        if (this.player.getNblife()==0){
            return true;
        }
        return false;
    }


}