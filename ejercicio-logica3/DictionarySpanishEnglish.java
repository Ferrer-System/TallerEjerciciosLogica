
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DictionarySpanishEnglish {
    public static void main(String[] args) {

        // Scanner para leer respuesta
        Scanner sc = new Scanner(System.in);

        int correctAnswers = 0;
        int incorrectAnswers = 0;

        // Create a dictionary with Spanish words and their English translations
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hola", "hello");
        dictionary.put("adiós", "goodbye");
        dictionary.put("gracias", "thank you");
        dictionary.put("por favor", "please");
        dictionary.put("amigo", "friend");
        dictionary.put("familia", "family");
        dictionary.put("comida", "food");
        dictionary.put("agua", "water");
        dictionary.put("casa", "house");
        dictionary.put("perro", "dog");
        dictionary.put("gato", "cat");
        dictionary.put("libro", "book");
        dictionary.put("escuela", "school");
        dictionary.put("trabajo", "work");
        dictionary.put("ciudad", "city");
        dictionary.put("música", "music");
        dictionary.put("película", "movie");
        dictionary.put("deporte", "sport");
        dictionary.put("familia", "family");
        dictionary.put("amor", "love"); 

        // convertir las claves a lista
        List<String> words = new ArrayList<>(dictionary.keySet());

        //Mezcar palabras aleatoriamente
        Collections.shuffle(words);

        // Tomar 5 palabras aleatorias
        for (int i = 0; i < 5; i++) {
            String spanishWord = words.get(i);
            String englishTranslation = dictionary.get(spanishWord);

            System.out.println("¿Cuál es la traducción al inglés de '" + spanishWord + "'?");
            String userAnswer = sc.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(englishTranslation)) {
                System.out.println("¡Correcto!");
                correctAnswers++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + englishTranslation);
                incorrectAnswers++;
            }
        }

        System.out.println("Resultados:");
        System.out.println("Respuestas correctas: " + correctAnswers);
        System.out.println("Respuestas incorrectas: " + incorrectAnswers);

        sc.close();

    }
       
}