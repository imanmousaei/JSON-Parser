import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        JsonObject JSON = new JsonObject();
        JSON.json = "{\n" +
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

        JSON.getInput(new Scanner(System.in));

        JSON.processInput();




    }
}
