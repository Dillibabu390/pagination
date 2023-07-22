package com.application.myapp.controller;
import com.application.myapp.entity.SubmitFormEntity;
import com.application.myapp.service.FormRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    FormRepositoryService formRepositoryService;




    @GetMapping(value = "/get")
    public ResponseEntity<List<SubmitFormEntity>> getForm() {
        List<SubmitFormEntity> data = formRepositoryService.getData();

        if (data.isEmpty()) {
            // If the list is empty, return 204 No Content status
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // If data is found, return the list with 200 OK status
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/get/{field}")
    public ResponseEntity<List<SubmitFormEntity>> getFormByField(@PathVariable String field) {

        List<SubmitFormEntity> data = formRepositoryService.getDataByField(field);
        if (data.isEmpty()) {
            // If the list is empty, return 204 No Content status
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // If data is found, return the list with 200 OK status
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get/{offset}/{pagesize}")
    public ResponseEntity<Page<SubmitFormEntity>> getFormByField(@PathVariable int offset,@PathVariable int pagesize) {

        Page<SubmitFormEntity> data = formRepositoryService.getDataByPagination(offset,pagesize);
        if (data.isEmpty()) {
            // If the list is empty, return 204 No Content status
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // If data is found, return the list with 200 OK status
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
    }


    @PostMapping(value = "/post")
    public ResponseEntity<SubmitFormEntity> postForm(@RequestBody SubmitFormEntity submitForm) {
        try {
            if (submitForm == null) {
                // If the request body is null, return a bad request status code (400).
                return ResponseEntity.badRequest().build();
            }
            // Save the entity to the repository.

           SubmitFormEntity data =  formRepositoryService.saveData(submitForm);

            // Return the saved entity with a success status code (200 OK).
            return ResponseEntity.ok(data);


        } catch (Exception e) {
            // If an exception occurs during processing, return an internal server error status code (500).
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
