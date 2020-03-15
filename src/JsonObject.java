import com.sun.istack.internal.NotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JsonObject {
    HashMap<String,JsonValue> objects;
    public static String json; // TODO privatesh kon

    public JsonValue getValue(String key){
        return objects.get(key);
    }

    public void getInput(Scanner in){
//        while(in.hasNextLine()){
//            json += in.nextLine(); //TODO uncomment
//        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);

        json = sb.toString();
        json = json.trim();
        json = json.replaceAll("\\s+","");

        System.out.println("json = " + json);
    }

    public void processInput(){
        String[] input = json.split(",\"");

        for(int i=0 ; i<input.length ; i++){
//            String key = input[i].split("\"")[0];
//            String val = input[i].split("\"")[0];
//            System.out.println("key = " + key + " val = " + val);
            System.out.println(input[i]);
        }
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

