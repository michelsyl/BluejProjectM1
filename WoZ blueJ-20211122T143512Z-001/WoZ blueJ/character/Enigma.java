package character;
import java.util.regex.*;

public class Enigma {

    protected Clues clues;


    protected String description;
    protected String answer;
    protected String question;

    protected boolean good; // cest quoi ca?

    // pour le regex :
    private static Pattern pattern;
    private static Matcher matcher;

    /**
     * Constructeur
     * @param answer
     * @param question
     */
    public Enigma (String answer, String question){
        this.answer=answer;
        this.question=question;
    }

    /**
     * Test si la reponse proposée est la bonne réponse
     * @param answer
     */
    public void giveAnswer(String answer,Criminels criminel,Player player){

        pattern = Pattern.compile(this.answer);

        //modifie le texte pour les majuscules et les accents :
        answer=regex(answer);

        matcher = pattern.matcher(answer);

        if(matcher.find()) { // cherche si la bonne réponse est dans la chaine de charactere proposée
            System.out.println("Trouvé ! vous pouvez passer à la prochaine étape");
            criminel.giveCoins(player);
        }else{
            System.out.println("erreur, vous perdez un point de vie");
            criminel.setCoins();
            criminel.attaque(player);

        }
    }

    /**
     * Modifie la réponse donnée afin de ne pas avoir d'erreurs sur des majuscules ou des accents.
     * @param answer
     * @return answer
     */
    public String regex(String answer){

        // enlève les majuscules:
        answer = answer.toLowerCase();

        // enlève les accents sur le a :
        answer = answer.replaceAll("â", "a");
        answer = answer.replaceAll("à", "a");

        // enlève les accents sur le e :
        answer = answer.replaceAll("é", "e");
        answer = answer.replaceAll("è", "e");
        answer = answer.replaceAll("ê", "e");
        answer = answer.replaceAll("ë", "e");

        // enlève les accents sur le i :
        answer = answer.replaceAll("î", "i");
        answer = answer.replaceAll("ï", "i");

        // enlève les accents sur le o :
        answer = answer.replaceAll("ô", "o");

        // enlève les accents sur le u :
        answer = answer.replaceAll("ü", "u");
        answer = answer.replaceAll("û", "u");

        return answer;

    }
    public String toString(){
        return "Voici la question : "+question;
    }

    /**
     *
     * @return Clues
     */
    public Clues giveClues(){
        return clues;
    }
}