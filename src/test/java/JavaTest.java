import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;

import java.lang.reflect.Type;
import java.util.List;

public class JavaTest {
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Data data = objectMapper.readValue("{\"ids\": [1, 2, 3] }", Data.class);
        System.out.println(data.ids.size());

        List<Long> ids = objectMapper.readValue("[1, 2, 3]", new TypeReference<List<Long>>() {});
        System.out.println(ids.size());
    }

    public static class Data {
        public List<Long> getIds() {
            return ids;
        }

        public void setIds(List<Long> ids) {
            this.ids = ids;
        }

        private List<Long> ids;

    }

    @Test
    public void isTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        IsData data = new IsData(true, "true");
        System.out.println(objectMapper.writeValueAsString(data));
    }
    public static class IsData {
        public IsData(boolean isBool, String isStr) {
            this.isBool = isBool;
            this.isStr = isStr;
        }
        private boolean isBool;
        private String isStr;

        public boolean getIsBool() {
            return isBool;
        }
        public String getIsStr() {
            return isStr;
        }
    }
}
