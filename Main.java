import java.util.Random;
import java.util.Scanner;

class ShuffleArray {
    public static void shuffleArray(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            String a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}

public class Main {
    public static void desteBastirici(String[] array){
        for (int i = 0; i < 4; i++) {
            if (array[i] != null){
                System.out.println(array[i]);
            }
        }
    }
    public static boolean secilenVarMI(String[] liste,String kelime){

        return false;
    }
    public static boolean checkNull(String[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null){
                return true;
            }
        }
        return false;
    }
    public static String kelimeBulucu(String kelime){
        char[] chars = kelime.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).equals(" ")){
                return result.toString();
            }
            result.append(String.valueOf(chars[i]).toLowerCase());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] userDeck = new String[4];
        String[] enemyDeck = new String[4];
        String[] deck = new String[52];
        String[] table= new String[52];
        // Initialize the deck with the suits and ranks
        for (int i = 0; i < deck.length; i++) {
            deck[i] = ranks[i % 13] + " of " + suits[i / 13];
        }
        ShuffleArray.shuffleArray(deck);
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
        int index = 0;
        for (int i = 0; i < 4; i++) {
            table[i] = deck[index];
            index++;
        }
        int tableIndex=0;
        while (checkNull(deck)){

            for (int i = 0; i < 4; i++) {
                userDeck[i] = deck[index];
                index++;
                enemyDeck[i] = deck[index];
                index++;
            }
            while (checkNull(enemyDeck)){
                desteBastirici(userDeck);
                System.out.println("Hangi KARTI oynucan?");
                String kart = scanner.nextLine();
                for (int i = 0; i < userDeck.length; i++) {
                    if (userDeck[i] == null)continue;
                    if (kelimeBulucu(userDeck[i]).equals(kart) || kart.toLowerCase().equals(userDeck[i])){
                        table[tableIndex] = kart;
                        tableIndex++;
                        userDeck[i] = null;
                    }
                }
            }
        }
    }
}