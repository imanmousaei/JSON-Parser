import com.sun.istack.internal.Nullable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class JsonObject {
    HashMap< String , JsonValue <?>  > objects;
    public static String json; // TODO privateshoon kon
    private int index = 0;

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

    private String getInsideKey(){
        index++;
        int beginIndex = index , endIndex;
        while(index<json.length()-1 && json.charAt(index) != '\"' ){
            index++;
        }

        endIndex = index;
        index += 2; // " and :

        return json.substring(beginIndex,endIndex);
    }

    private JsonValue<?> getInsideValue(){
        if(index >= json.length()){
            return new JsonNull(null);
        }
        else if(json.charAt(index) == '\"'){
            int beginIndex = ++index , endIndex;
            while(json.charAt(index) != '\"'){
                index++;
            }
            endIndex = index;
            index += 2; // " ,
            return new JsonString(json.substring(beginIndex,endIndex));
        }

        else if( Character.toLowerCase( json.charAt(index) ) == 'f' ){
            index += 6; // false,
            return new JsonBool(false);
        }

        else if( Character.toLowerCase( json.charAt(index) ) == 't' ){
            index += 5; // true,
            return new JsonBool(true);
        }

        else if( Character.toLowerCase( json.charAt(index) ) == 'n' ){
            index += 5; // null,
            return new JsonNull(null);
        }

        else if(json.charAt(index) == '{'){ // object TODO

//            return new JsonObject();
            return new JsonString("object");
        }

        else if(json.charAt(index) == '['){
            ArrayList< JsonValue<?> > temp = new ArrayList<>();
            while (json.charAt(index) != ']') {
                index++;
                temp.add(getInsideValue());
                temp.get(temp.size()-1).print();
            }
            index++;
            return new JsonArray(temp);
        }

        else if(json.charAt(index) == '-' || (json.charAt(index)>='0' && json.charAt(index)<='9') ) {
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
                index ++; // ,
                return new JsonFloat( Float.parseFloat( json.substring(beginIndex, endIndex) ) );

            }
            else {
                index ++; // ,
                return new JsonInteger( Integer.parseInt( json.substring(beginIndex, endIndex) ) );
            }

        }

//        return new JsonNull(null);
        index++;
        return getInsideValue();
    }

        public void processInput(){
        while( index<json.length() ){
            String key = getInsideKey();
            System.out.print("key = " + key + " ; value = ");


            JsonValue<?> val = getInsideValue();
            val.print();



        }
    }



}

class JsonValue <T> extends JsonObject {
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

class JsonArray extends JsonValue < ArrayList< JsonValue<?> > > {
    JsonArray(ArrayList< JsonValue<?> > value) {
        super(value);
    }
}

class JsonNull extends JsonValue {
    JsonNull(@Nullable Object value) {
        super(value);
    }
}

