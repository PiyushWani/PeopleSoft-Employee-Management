package com.peoplesoft.employee.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.peoplesoft.employee.models.EmployeeDocs;
import com.peoplesoft.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.fuzzyQuery;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    EmployeeDocs empDocs;

    public EmployeeDocs save(JsonNode payload){
        Integer id = Integer.parseInt(payload.get("id").toString());
        empDocs.setExperianID(id);
        empDocs.setDoc(payload);
        return empRepo.save(empDocs);
    }

    public JsonNode findById(Integer experianId) {
        return empRepo.findById(experianId).get().getDoc();
    }

    public Iterable<EmployeeDocs> findViaEmployeeName(String name) {

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                // .withQuery(matchAllQuery())
                // .withQuery(QueryBuilders.matchQuery("doc.first-name", name))
                // .withQuery(QueryBuilders.multiMatchQuery(name, "doc.first-name", "doc.last-name"))
                .withQuery(fuzzyQuery("doc.first-name", name))
                .withIndices("staff")
                .withTypes("employee")
                .build();
        return empRepo.search(searchQuery);
    }
}
