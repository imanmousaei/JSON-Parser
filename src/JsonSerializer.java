import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {
    private String json = "{\n";
    private int tabs = 1;

    public JsonSerializer(JsonObject jsonObject) {
        serialize(jsonObject);
        json += "}";
    }

    public String getJson() {
        return json;
    }

    private void serialize(JsonValue<?> jsonValue) {
        HashMap<String, JsonValue<?>> map = ((JsonObject) jsonValue).getValue();
        int i = 0;
        for (Map.Entry<String, JsonValue<?>> entry : map.entrySet()) {
            indent();
            json += "\"" + entry.getKey() + "\" : ";
            serializeClasses(entry.getValue());

            if (i < map.size() - 1) {
                json += " , \n";
            }
            else {
                json += " \n";
            }


            i++;
        }
    }

    private void serializeClasses(JsonValue<?> jsonValue) {
        if (jsonValue.getClass() == JsonObject.class) {
            json += "{\n";
            tabs++;
            serialize(jsonValue);
            tabs--;
            indent();
            json += "}";
        }
        else if (jsonValue.getClass() == JsonString.class) {
            json += "\"" + jsonValue.getValue() + "\"";
        }
        else if (jsonValue.getClass() == JsonArray.class) {
            ArrayList<JsonValue<?>> list = ((JsonArray) jsonValue).getValue();
            json += "[ ";
            tabs++;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getClass() == JsonObject.class) {
                    serialize(list.get(i));
                }
                else {
                    serializeClasses(list.get(i));
                }
                if (i < list.size() - 1) {
                    json += " , ";
                }
            }

            tabs--;
            json += "\n";
            indent();
            json += "] \n";
        }
        else {
            json += jsonValue.getValue();
        }
    }

    private void indent() {
        for (int i = 0; i < tabs; i++) {
            json += "\t";
        }
    }


}

