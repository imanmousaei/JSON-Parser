import com.sun.istack.internal.NotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JsonObject {
    HashMap<String,JsonValue> objects;
    public static String json; // TODO privatesh kon
    static int index;

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

    private String getInsideKey( char splitBy ){
        int beginIndex = index , endIndex;
        while(json.charAt(index) != splitBy){
            index++;
        }

        endIndex = index - 1;
        index += 2; // " and :

        return json.substring(beginIndex,endIndex);
    }

    private JsonValue getInsideValue(){
        if(json.charAt(index) == '\"'){
            int beginIndex = index++ , endIndex;
            while(json.charAt(index) != '\"'){
                index++;
            }
            endIndex = index;
            index += 2; // " and ,
            return new JsonString(json.substring(beginIndex,endIndex));
        }
    }

        public void processInput(){
        for(int i=0 ; i<json.length() ; i++){
            index = 1;
            String key = getInsideKey('\"');
            JsonValue val = getInsideValue();



        }
    }


}

abstract class JsonValue{

}

class JsonString extends JsonValue{
    private String value;

    JsonString(String value){
        this.value = value;
    }

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

