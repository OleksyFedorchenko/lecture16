package com.example.lecture16.repository;

import com.example.lecture16.documents.Pep;
import com.example.lecture16.dto.PopularNamesAggregation;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PepRepository extends MongoRepository<Pep, String> {
    @Query(value = "{first_name_en:'?0'}",
            fields = "{'first_name_en' : 1,'last_name_en':1, 'full_name_en' : 1}")
    List<Pep> findPepByFirst_name_enOrderByFirst_name_en(String first_name_en);

    @Query(value = "{last_name_en:'?0'}",
            fields = "{'first_name_en' : 1,'last_name_en':1, 'full_name_en' : 1}")
    List<Pep> findPepByLast_name_enOrderByLast_name_en(String last_name_en);

    @Aggregation(pipeline = {
            "{'$match':{'is_pep': true}}",
            "{'$group':{'_id': '$first_name_en', 'count': {'$sum':1}}}",
            "{'$match':{'count': {'$gt': 1}}}",
            "{'$sort': {'count': -1}}",
            "{'$project':{'first_name_en': '$_id','count':1,'_id': 0}}",
            "{'$limit': 10}"
    })
    List<PopularNamesAggregation> getPopularNames();
}
