import com.sun.istack.internal.NotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JsonObject {
    HashMap<String,JsonValue> objects;
    private static String json;

    public JsonValue getValue(String key){
        return objects.get(key);
    }

    private static void getInput(Scanner in){
//        while(in.hasNextLine()){
//            json += in.nextLine(); //TODO uncomment
//        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);

        json = sb.toString();

//        System.out.println("json = " + json);
    }

    private static void processInput(){
        String[] input = json.split(",");
        System.out.println(input[0].split("\"")[0]);
    }

    public static void main(String[] args){
        json = "{\n" +
                "  \"action\": \"splitText\",\n" +
                "  \"data\": {\n" +
                "    \"text\": \"salam,che,khabar,bla,bla,bla\",\n" +
                "    \"splitBy\": \",\"\n" +
                "  }\n" +
                "}";

        getInput(new Scanner(System.in));

        processInput();




    }


}

class JsonValue{

}

class JsonString extends JsonValue{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class JsonBool extends JsonValue {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

class JsonInteger extends JsonValue {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class JsonFloat extends JsonValue {
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

class JsonArray extends JsonValue {
    ArrayList<JsonObject> value;

    public ArrayList<JsonObject> getValue() {
        return value;
    }

    public void setValue(ArrayList<JsonObject> value) {
        this.value = value;
    }
}

