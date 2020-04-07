package com.peoplesoft.employee.repository;

import com.peoplesoft.employee.models.EmployeeDocs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<EmployeeDocs,Integer>{

    /*@Query("{\"bool\": {\"must\": [{\"match\": {\"doc.name\": \"?0\"}}]}}")
    List<EmployeeDocs> findByEmployeeName(String name);*/
}