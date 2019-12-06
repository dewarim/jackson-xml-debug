package test.debug;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JacksonXmlRootElement(localName = "Root")
@JsonRootName("Root")
public class Root {

    @JsonProperty("id")
    String id;

    public Root(String id) {
        this.id = id;
    }

    public Root() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Root root = (Root) o;
        return Objects.equals(id, root.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
