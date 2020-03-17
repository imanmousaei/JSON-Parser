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


        JsonObject JSON = new JsonObject(json0);

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

        }
        else if (action.equals("passwordGenerator")) {

        }
        else if (action.equals("sortNumber")) {

        }
        else if (action.equals("studentInfo")) {

        }

    }

}
