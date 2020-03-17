import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String json0 = "{\n" +
                "  \"action\": \"fibonacci\",\n" +
                "  \"data\": {\n" +
                "    \"index\": 25\n" +
                "  }\n" +
                "}";



        JsonObject JSON = new JsonObject(json0);

        JSON.getInput(System.in);

        JSON.processInput();

        System.out.print("here : ");

//        JSON.getValue("numbers").print();

//        System.out.println( JSON.getString("text")  );
    }
}
