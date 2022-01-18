import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class project01_C {
    public static void main(String[] args) {
        String src = "info.json";
        InputStream is = project01_C.class.getResourceAsStream(src);    // 해당 클래스가 생성된 곳에서 파일을 얻어옴.
        if (is == null) {
            throw new NullPointerException("Cannot find resource file");
        }
        JSONTokener tokener = new JSONTokener(is);  // 문자열 형태의 데이터가 JSON 형태로 변환
        JSONObject object = new JSONObject(tokener);    // JSON 형태의 데이터를 JSONObject 형태로 변환
        JSONArray students = object.getJSONArray("student");

        for (int i = 0; i < students.length(); i++) {
            JSONObject student = (JSONObject) students.get(i);
//            System.out.println(student.get("name"));
//            System.out.println(student.get("phone"));
//            System.out.println(student.get("address"));
            System.out.println(student.toString(2));

        }
    }
}
