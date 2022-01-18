import org.json.JSONArray;
import org.json.JSONObject;

public class project01_B {
    public static void main(String[] args) {
        // JSON - Java(org.json)
        JSONObject student = new JSONObject();
        student.put("name", "Jone");    // key : value
        student.put("phone", "010-1111-1111");
        student.put("address", "서울");

       JSONArray students = new JSONArray();
       students.put(student);

        student = new JSONObject();
        student.put("name", "Mark");    // key : value
        student.put("phone", "010-2222-2222");
        student.put("address", "부산");

        students.put(student);

        System.out.println(students.toString(2));

        JSONObject obj = new JSONObject();
        obj.put("students", students);
        System.out.println(obj.toString(2));
    }
}
