package com.peoplesoft.employee.models;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Component
@Document(indexName = "staff", type="employee", shards = 1)
public class EmployeeDocs {

    @Id
    private Integer experianID;
    private JsonNode doc;

    public Integer getExperianID() {
        return experianID;
    }

    public void setExperianID(Integer experianID) {
        this.experianID = experianID;
    }

    public JsonNode getDoc() {
        return doc;
    }

    public void setDoc(JsonNode doc) {
        this.doc = doc;
    }
}
