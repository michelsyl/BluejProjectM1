import javax.swing.JFrame;

public class Fenetre extends JFrame{
    // Hérite de la classe JFrame
    // Donc, les objets de la classe Fenetre possèdent les attributs et les méthodes
    // de la classe JFrame

    // Attribut : la fenêtre d'affichage contient une console de jeu 
    private ConsoleDeJeu maConsole ;

    // Constructeur
    public Fenetre(String titre){
        super(titre) ; // Constructeur de la classe mère (JFrame)

        // Création d'une console de jeu
        maConsole = new ConsoleDeJeu() ;
        // Ajout de la Game Boy dans la partie "contenu" de la fenetre
        this.setContentPane(maConsole);

        // Appel à la méthode setDefaultCloseOperation, définie dans la classe JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        // Permet de compacter la fenêtre : sa taille sera ajustée à son contenu
        this.pack();
    }
}
