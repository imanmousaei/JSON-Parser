import com.sun.istack.internal.Nullable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JsonObject {
    HashMap< String , JsonValue <?>  > objects;
    public static String json; // TODO privatesh kon
    private int index = 1;

    public JsonValue <?> getValue(String key){
        return objects.get(key);
    }

    public void getInput(InputStream inputStream){
//        Scanner scan = new Scanner(inputStream);
//        while(scan.hasNextLine()){
//            json += scan.nextLine(); //TODO uncomment
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
        while(index<json.length()-1 && json.charAt(index) != splitBy){
            index++;
        }

        endIndex = index - 1;
        index += 2; // " and :

        return json.substring(beginIndex,endIndex);
    }

    private JsonValue<?> getInsideValue(){
        if(json.charAt(index) == '\"'){
            int beginIndex = index++ , endIndex;
            while(json.charAt(index) != '\"'){
                index++;
            }
            endIndex = index;
            index += 2; // " and ,
            return new JsonString(json.substring(beginIndex,endIndex));
        }

        else if( Character.toLowerCase( json.charAt(index) ) == 'f' ){
            index += 6; // false,
        }

        else if( Character.toLowerCase( json.charAt(index) ) == 't' ){
            index += 5; // true,
        }

        else if(json.charAt(index) == '{'){
            // objecte
        }

        else if(json.charAt(index) == '['){
            // array
        }

        else{
            int beginIndex = index , endIndex;
            while(json.charAt(index)>='0' && json.charAt(index)<='9'){
                index++;
            }
            endIndex = index;

            if(json.charAt(index)=='.'){
                index++;
                while(json.charAt(index)>='0' && json.charAt(index)<='9'){
                    index++;
                }
                endIndex = index;
                return new JsonFloat( Float.parseFloat( json.substring(beginIndex, endIndex) ) );

            }
            else {
                return new JsonInteger( Integer.parseInt( json.substring(beginIndex, endIndex) ) );
            }

        }

        return new JsonNull(null);

    }

        public void processInput(){
        for(int i=0 ; i<json.length() ; i++){
            String key = getInsideKey('\"');
            JsonValue<?> val = getInsideValue();

            System.out.print("key = " + key + ";value = ");
            val.print();



        }
    }



}

class JsonValue <T> {
    private T value;
    JsonValue(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }
}

class JsonString extends JsonValue <String> {
    JsonString(String value) {
        super(value);
    }
}

class JsonBool extends JsonValue <Boolean> {
    JsonBool(boolean value) {
        super(value);
    }
}

class JsonInteger extends JsonValue <Integer> {
    JsonInteger(int value) {
        super(value);
    }
}

class JsonFloat extends JsonValue <Float> {
    JsonFloat(float value) {
        super(value);
    }
}

class JsonArray extends JsonValue < ArrayList<JsonObject> > {
    JsonArray(ArrayList<JsonObject> value) {
        super(value);
    }
}

class JsonNull extends JsonValue {
    JsonNull(@Nullable Object value) {
        super(value);
    }
}

