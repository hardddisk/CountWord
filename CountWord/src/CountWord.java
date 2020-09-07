import java.net.*;
import java.io.*;

public class CountWord{



    StringBuffer sb = new StringBuffer();

    public static void main(String []args){


        String contentFromURL=getUrlContents("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exlimit=max&explaintext&exintro&titles=Yahoo|Google&redirects=");

       // System.out.println(contentFromURL);
    }

    // this method will get the content of URL.
    private static String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a url connection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            int count=0;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                String matchingWord="Google";
                count += countOccurences( line, matchingWord) ;
                System.out.println("#########################");
                System.out.println("found the word: \""+matchingWord+"\" "+count+ " times");
                System.out.println("#########################");
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }


    static int countOccurences(String str, String matchingWord)
    {
        // split the string by spaces in a
        String splitedTextBySpace[] = str.split(" ");

        // search for pattern in a
        int count = 0;
        for (int i = 0; i < splitedTextBySpace.length; i++)
        {
            // if match found increase count
            if (matchingWord.equals(splitedTextBySpace[i])) {
                count++;
            }
        }

        return count;
    }
}
