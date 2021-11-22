import java.awt.Color;
import java.awt.Graphics;

public class Mobile {

    // Attributs
    private int x;
    private int y;
    private int rayon = 3;
    private int categorie ;
    private int dx, dy ; // Déplacement
    private int velocite ;

    // Constantes
    private final static int TAILLE_MAX = 50, TAILLE_MIN = 10,
            X_MIN = 0, X_MAX=300-TAILLE_MAX,
            Y_MIN = 0, Y_MAX=300-TAILLE_MAX,
            DX_MIN = -1, DX_MAX=1,
            DY_MIN = -1, DY_MAX=1,
            VELOCITE_MIN = 1, VELOCITE_MAX = 10 ;

    // Pour affecter une couleur d'affichage à chaque catégorie
    private final static Color[] COULEURS_DES_CATEGORIES ={Color.GREEN, Color.RED, Color.BLUE} ;


    public Mobile(int posX, int posY  , int dx, int dy ,int laCategorie){
        this.x = posX ;
        this.y = posY ;

        this.categorie = laCategorie ;
        this.dx = dx ;
        this.dy = dy ;
        this.velocite = VELOCITE_MIN ;
    }

    // Assesseurs
    public void setX(int xPos)  { this.x = xPos; }
    public int getX()           { return this.x;      }

    public void setY(int yPos)  { this.y = yPos; }
    public int getY()           { return this.y;      }

    public int getTaille()      { return this.rayon;   }
    public int getCategorie()   { return this.categorie ; }

    public void tracer(Graphics g, boolean focus){
        g.setColor(couleurDeCategorie());
        g.fillOval(this.x-this.rayon,this.y-this.rayon,2*this.rayon,2*this.rayon);
        // Contour particulier pour le mobile sélectionné
        if(focus){
            g.setColor(Color.BLACK);
            g.drawOval(this.x-this.rayon,this.y-this.rayon,2*this.rayon,2*this.rayon);
        }
    }

    public void deplacer(){
        this.y += this.dy*this.velocite ;
    }


    // Préparation à l'affichage
    @Override
    public String toString()
    {
        return (Object)this.getClass() + " de catégorie "+this.categorie
                +", en position (" +this.x+", "+this.y+")" ;
    }

    public void modifierDeplacementY() {
        if(this.dy>=0) this.dy = DY_MIN;  else this.dy = DY_MAX;
    }

    public void modifierDeplacementX() {
        if(this.dx>=0) this.dx = DX_MIN;  else this.dx = DX_MAX;
    }

    public void accelerer(){ this.velocite++ ; }


    // Autres méthodes privées

    // Associe une couleur à la catégorie du Mobile
    private Color couleurDeCategorie(){
        if(this.categorie<COULEURS_DES_CATEGORIES.length)
            return COULEURS_DES_CATEGORIES[this.categorie] ;
        else    return COULEURS_DES_CATEGORIES[0] ;
    }

    // Choix aléatoire entre deux valeurs
    private static int lUnOuLautre(int un, int autre){
        if (Math.random()>0.5) return un ;
        else return autre ;
    }

    // Choix aléatoire dans un ensemble
    private static int alea(int min, int max){
        return (int)(min+(max-min+1)*Math.random()) ;
    }

} // Fin de la classe

