package test.debug;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RootTest {

    private Root root = new Root("hello");
    private String jsonTemplate = "{\"Root\":{\"id\":\"hello\"}}";
    private String xmlTemplate  = "<Root><id>hello</id></Root>";

    @Test
    public void json() throws JsonProcessingException {
        ObjectMapper mapper = new JsonMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String value = mapper.writeValueAsString(root);
        assertEquals(jsonTemplate,value);
        Root deserializedRoot = mapper.readValue(value, Root.class);
        assertEquals(root,deserializedRoot);
    }

    @Test
    public void xml() throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        String value = mapper.writeValueAsString(root);
        assertEquals(xmlTemplate, value);
        Root deserializedRoot = mapper.readValue(value, Root.class);
        assertEquals(root, deserializedRoot);
    }

}
