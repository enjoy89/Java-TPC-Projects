import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.inf.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class project01_A {
    public static void main(String[] args) {

        BookDTO bookDTO = new BookDTO("Java", 21000, "에이콘", 300);
        Gson g = new Gson();    // 구글에서 제공하는 API
        String json = g.toJson(bookDTO); // Object(BookDTO) -> JSON(String)
        System.out.println(json);

        BookDTO bookDTO1 = g.fromJson(json, BookDTO.class); // JSON(Stirng) -> Object(BookDTO)
        System.out.println(bookDTO1.toString());

        // Object(List<BookDTO>) -> JSON(String): [{  }, {  }....]
        List<BookDTO> list = new ArrayList<>();
        list.add(new BookDTO("Java1", 23000, "에이콘1", 400));
        list.add(new BookDTO("Java2", 27000, "에이콘2", 500));
        list.add(new BookDTO("Java3", 30000, "에이콘3", 600));

        String listJson = g.toJson(list);
        System.out.println(listJson);

        // JSON(String) -> Object(List<BookDTO>)
        // String 형태의 (JSON) 데이터로부터 List 형태의 BookDTO 객체를 가져와야함
        // Java의 reflect(역추적해서 만들어냄)을 이용하여 Type 정보를 가져올 수 있음
        List<BookDTO> bookDTO2 = g.fromJson(listJson, new TypeToken<List<BookDTO>>() {
        }.getType());
        for (BookDTO bo : bookDTO2) {
            System.out.println(bo);
        }
    }
}
