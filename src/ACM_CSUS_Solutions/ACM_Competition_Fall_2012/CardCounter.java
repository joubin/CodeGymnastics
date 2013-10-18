package ACM_Competitions.ACM_Competition_Fall_2012;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: joubin
 * Date: 10/17/13
 * Time: 5:09 PM
 */
public class CardCounter {
    String [] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};
    private BufferedReader bufferedReader = null;
    private File file = null;
    private HashMap<String, Integer> cardsDictionary = new HashMap<String, Integer>();
    public CardCounter() throws IOException {
        for (String s: cards){
            cardsDictionary.put(s, 0);
        }

        List<String> list = new ArrayList<String>();
        String path = URLDecoder.decode(CardCounter.class.getResource("cards.in").getPath());

        File file = new File(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while (!((text = reader.readLine()).equals("E"))) {
                try{cardsDictionary.put(text, cardsDictionary.get(text)+1);}catch (NullPointerException n){cardsDictionary.put(text, 1);}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        for(String k : cards){
            System.out.println(cardsDictionary.get(k)+" "+ k);

        }

    }
}
