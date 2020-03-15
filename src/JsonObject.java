import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JsonObject {
    HashMap<String,JsonValue> object;
    private static String json;

    void getInput(Scanner in){
        while(in.hasNextLine()){
            json += in.nextLine();
        }
    }

    public static void main(String[] args){
        json = "{\n" +
                "  \"action\": \"splitText\",\n" +
                "  \"data\": {\n" +
                "    \"text\": \"salam,che,khabar,bla,bla,bla\",\n" +
                "    \"splitBy\": \",\"\n" +
                "  }\n" +
                "}";



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

