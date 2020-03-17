import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String json0 = "{\n" +
                "  \"action\": \"fibonacci\",\n" +
                "  \"data\": {\n" +
                "    \"val\": 12\n" +
                "  }\n" +
                "}";

        String json1 = "{\n" +
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
        if (action.equals("fibonacci")) {

        }
        else if (action.equals("fibonacci")) {

        }

    }

}
