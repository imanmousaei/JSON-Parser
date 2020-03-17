import com.sun.istack.internal.Nullable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class JsonValue <T> {
    protected T value;

    JsonValue(){}

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
        System.out.print(value);
    }
}

public class JsonObject extends JsonValue< HashMap< String,JsonValue<?> > > {
//    HashMap< String , JsonValue <?> > jsonObjects = new HashMap<>();
    public String json; // TODO privateshoon kon
    private int index = 0;

    JsonObject(String json) {
        this.json = json;
        value = new HashMap<>();
        System.out.println("my jason = " + json);
    }

    JsonObject(){
        value = new HashMap<>();
    }

    public JsonValue <?> getValue(String key){
        return value.get(key);
    }

    public void getInput(InputStream inputStream){
//        Scanner scan = new Scanner(inputStream);
//        while(scan.hasNextLine()){
//            json += scan.nextLine(); //TODO uncomment
//        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(0);
//        sb.deleteCharAt(sb.length()-1);

        json = sb.toString();
        json = json.trim();
        json = json.replaceAll("\\s+","");

        System.out.println("json = " + json);
    }

    private String getInsideString(){
        while (json.charAt(index) != '\"'){
            index++;
        }
        index++;
        int beginIndex = index , endIndex;
        while(index<json.length()-1 && json.charAt(index) != '\"' ){
            index++;
        }

        endIndex = index;
        index += 2; // " and :

        return json.substring(beginIndex,endIndex);
    }

    private String getInsideObject(){
        while (json.charAt(index) != '{'){
            index++;
        }
        index++;
        int cnt = 1,beginIndex = index , endIndex;
        while(index<json.length()-1){
             if(json.charAt(index) == '}'){
                 cnt--;
             }
             else if(json.charAt(index) == '{'){
                 cnt++;
             }

             if(cnt == 0){
                 break;
             }

             index++;

        }

        endIndex = index;
        index += 2; // " and :

        return json.substring(beginIndex,endIndex);
    }

    private JsonValue<?> getInsideValue(){
        if(index >= json.length()){
            return new JsonNull(null);
//            return new JsonString("#it's n , index = " + index);
        }
        else if(json.charAt(index) == '\"'){
            return new JsonString(getInsideString());
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
//            return new JsonString("#it's n , index = " + index);
        }

        else if(json.charAt(index) == '{'){
            JsonObject object = new JsonObject( getInsideObject() );
            object.processInput();

            return object;
        }

        else if(json.charAt(index) == '['){
            ArrayList< JsonValue<?> > temp = new ArrayList<>();
            index++;
            while (index<json.length()-1 && json.charAt(index) != ']') {
                temp.add(getInsideValue());
            }
            index++;
            return new JsonArray(temp);
        }

        else if(json.charAt(index) == '-' || (json.charAt(index)>='0' && json.charAt(index)<='9') ) {
            int beginIndex = index , endIndex;

            if(json.charAt(index) == '-'){
                index++;
            }

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

        index++;
        return getInsideValue();
    }

    public void processInput(){
        while( index<json.length() && json.charAt(index) != '}' ){
            String key = getInsideString();
            System.out.print("key = " + key + " ; value = {");


            JsonValue<?> val = getInsideValue();
            val.print();

            System.out.println("}");

            this.value.put(key,val);

        }

        index++;
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
    public void print(){
//        System.out.print("{");
        for(int i=0 ; i<value.size() ; i++) {
            System.out.print(value.get(i).value + " ");
        }
//        System.out.println("}");
    }
}

class JsonNull extends JsonValue {
    JsonNull(@Nullable Object value) {
        super(value);
    }
}

