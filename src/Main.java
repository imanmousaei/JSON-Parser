import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String json1 = "{\n" +
                "  \"action\": \"splitText\",\n" +
                "  \"data\": {\n" +
                "    \"text\": \"salam,che,khabar,bla,bla,bla\",\n" +
                "    \"splitBy\": \",\"\n" +
                "  }\n" +
                "}" +
                "{\n" +
                "  \"action\": \"fibonacci\",\n" +
                "  \"data\": {\n" +
                "    \"index\": 25\n" +
                "  }\n" +
                "}" +
                "{\n" +
                "  \"action\": \"passwordGenerator\",\n" +
                "  \"data\": {\n" +
                "    \"length\": 52,\n" +
                "    \"useNumber\": true,\n" +
                "    \"useAlphabet\": false\n" +
                "  }\n" +
                "}" +
                " {\n" +
                "  \"action\": \"sortNumber\",\n" +
                "  \"data\": {\n" +
                "    \"numbers\": [12,0.2,1,3,1,5,3,2,4,6,-1,0.0003]\n" +
                "  }\n" +
                "}" +
                "{\n" +
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

        String json2 = "{\n" +
                "  \"action\": \"passwordGenerator\",\n" +
                "    \"length\": 0.052,\n" +
                "    \"useNumber\": -65437.858,\n" +
                "    \"useAlphabet\": false,\n" +
                "  \"action\": \"passwordGenerator\",\n" +
                "    \"length\": 52,\n" +
                "    \"useNumber\": 67.858,\n" +
                "    \"useAlphabet\": TRUE,\n" +
                "\"numbers\": [12,0.2,1,3,1,5,3,2,4,6,-1,0.0003]\n" +
                "}";

        String json3 = "{\n" +
                "  \"action\": \"passwordGenerator\",\n" +
                "  \"data\": {\n" +
                "    \"length\": 52,\n" +
                "    \"useNumber\": true,\n" +
                "    \"useAlphabet\": false\n" +
                "}";

        JsonObject JSON = new JsonObject(json3);

        JSON.getInput(System.in);

        JSON.processInput();

        System.out.print("here : ");

        System.out.println( JSON.getObject("data").getBool("useAlphabet")  );
    }
}
