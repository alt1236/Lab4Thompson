package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pizza;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Pizza pizza) throws Exception {
        return mapper.writeValueAsString(pizza);
    }

    public static Pizza fromJson(String json) throws Exception {
        return mapper.readValue(json, Pizza.class);
    }
}
