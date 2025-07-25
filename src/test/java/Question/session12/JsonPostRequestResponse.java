package Question.session12;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPostRequestResponse {
      /* {
        "name": "morpheus",
            "job": "leader",
            "id": "888",
            "createdAt": "2025-07-25T14:17:00.826Z"
    }*/
    public String name;
    public String job;
    public String id;
    public String createdAt;
}
