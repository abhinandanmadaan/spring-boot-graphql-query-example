package com.techprimers.graphql.springbootgrapqlexample.resource;

import com.techprimers.graphql.springbootgrapqlexample.service.GraphQLService;
import graphql.ExecutionResult;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/books")
@RestController
public class BookResource {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping
//    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
//        ExecutionResult execute = graphQLService.getGraphQL().execute(query);

    public ResponseEntity<Object> getAllBooks(@RequestBody Map<String, Object> request) {
//    	System.out.println(((String) request.get("query")));
        ExecutionResult execute = graphQLService.getGraphQL().execute((String) request.get("query"));
        
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
