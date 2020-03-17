import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String json0 = "{\n" +
                "  \"action\": \"fibonacci\",\n" +
                "  \"data\": {\n" +
                "    \"index\": 6\n" +
                "  }\n" +
                "}";
        String json1 = "{\n" +
                "  \"action\": \"splitText\",\n" +
                "  \"data\": {\n" +
                "    \"text\": \"salam,che,khabar,bla,bla,bla\",\n" +
                "    \"splitBy\": \",\"\n" +
                "  }\n" +
                "}";
        String json155 = "{\n" +
                "  \"action\": \"studentInfo\",\n" +
                "  \"data\": {\n" +
                "    \"studentByGPA\": [\n" +
                "      {\n" +
                "        \"name\": \"hossein\",\n" +
                "        \"GPA\": 12\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"reza\",\n" +
                "        \"GPA\": 18.5\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";


        JsonObject JSON = new JsonObject(json1);

        JSON.getInput(System.in);

        JSON.processInput();

//        System.out.print("here : ");
//        JsonObject tmp = (JsonObject) JSON.getObject("data").getArrayList("studentByGPA").get(0);
//        System.out.println( tmp.getInt("GPA") );

        connectWithKheradExercises(JSON, System.out);


    }

    private static void connectWithKheradExercises(JsonObject json, PrintStream out) {
        String action = json.getString("action");
        JsonObject data = json.getObject("data");

        if (action.equals("fibonacci")) {
            int n = data.getInt("index");
            out.println(Fibo.calculateFib(n));
        }
        else if (action.equals("splitText")) {
            String text = data.getString("text");
            String splitBy = data.getString("splitBy");
            printWords( ExtractWords.extractWordsBySplit(text,splitBy) , out );
        }
        else if (action.equals("passwordGenerator")) {

        }
        else if (action.equals("sortNumber")) {

//            out.println(MergeSort.mergeSort(list));
        }
        else if (action.equals("studentInfo")) {

        }

    }

    static void printWords(ArrayList<String> words,PrintStream out){
        for(String word:words){
            out.println(word);
        }
    }

}
