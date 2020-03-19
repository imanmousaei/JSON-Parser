import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String json0 = "{\n" +
                "  \"action\": \"fibonacci\",\n" +
                "  \"data\": {\n" +
                "    \"index\": 6\n" +
                "  }\n" +
                "}";
        String json1 = "{\n" +
                "  \"action\": \"splitText\",\n" +
                "  \"data\": {\n" +
                "    \"text\": \"salam,che,khabar,bla,bla,bla\",\n" +
                "    \"splitBy\": \",\"\n" +
                "  }\n" +
                "}";

        String json2 = "{\n" +
                "  \"action\": \"passwordGenerator\",\n" +
                "  \"data\": {\n" +
                "    \"length\": 52,\n" +
                "    \"useNumber\": true,\n" +
                "    \"useAlphabet\": false\n" +
                "  }\n" +
                "}";

        String json3 = "{\n" +
                "  \"action\": \"sortNumber\",\n" +
                "  \"data\": {\n" +
                "    \"numbers\": [12,0.2,1,3,1,5,3,2,4,6,-1,0.0003]\n" +
                "  }\n" +
                "}";

        String json4 = "{\n" +
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

        String json5 = "{\n" +
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
                "      },\n" +
                "      {\n" +
                "        \"name\": \"alireza\",\n" +
                "        \"GPA\": 18.5\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"ali\",\n" +
                "        \"GPA\": 18.5\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        String json155 = "{\n" +
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


        JsonObject JSON = new JsonObject(json3);

        JSON.getInput(System.in);

        JSON.processInput();

//        System.out.print("here : ");
//        JsonObject tmp = (JsonObject) JSON.getObject("data").getArrayList("studentByGPA").get(0);
//        System.out.println( tmp.getInt("GPA") );

        connectWithKheradExercises(JSON, System.out);


    }

    private static void connectWithKheradExercises(JsonObject json, PrintStream out) {
        String action = json.getString("action");
        JsonObject data = json.getObject("data");

        if (action.equals("fibonacci")) {
            int n = (int) data.getDouble("index");
            out.println(Fibo.calculateFib(n));
        }
        else if (action.equals("splitText")) {
            String text = data.getString("text");
            String splitBy = data.getString("splitBy");
            printWords(ExtractWords.extractWordsBySplit(text, splitBy), out);
        }
        else if (action.equals("passwordGenerator")) {
            int length = (int) data.getDouble("length");
            boolean useNumber = data.getBool("useNumber");
            boolean useAlphabet = data.getBool("useAlphabet");
            out.println(Password.generatePassword(length, useNumber, useAlphabet));
        }
        else if (action.equals("sortNumber")) {
            ArrayList<Double> numbers = getDoubleArrayList(data);
            numbers = MergeSort.mergeSort(numbers);
            for (double num : numbers) {
                System.out.print(num + " ");
            }
        }
        else if (action.equals("studentInfo")) {
            ArrayList<Student> students = getStudentArrayList(data);
            students = MergeSort.mergeSort(students);
            for (Student st : students) {
                st.print();
            }
        }

    }

    private static ArrayList<Double> getDoubleArrayList(JsonObject data) {
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<JsonValue<?>> values = data.getArrayList("numbers");
        for (JsonValue<?> val : values) {
            JsonDouble tmp = (JsonDouble) val;
            numbers.add(tmp.getValue());
        }
        return numbers;
    }

    private static ArrayList<Student> getStudentArrayList(JsonObject data) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<JsonValue<?>> values = data.getArrayList("studentByGPA");
        for (JsonValue<?> val : values) {
            JsonObject object = (JsonObject) val;
            String name = object.getString("name");
            double GPA = object.getDouble("GPA");
            students.add(new Student(name, GPA));
        }
        return students;
    }

    static void printWords(ArrayList<String> words, PrintStream out) {
        for (String word : words) {
            out.println(word);
        }
    }

}
