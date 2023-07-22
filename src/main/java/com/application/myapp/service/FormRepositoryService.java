package com.application.myapp.service;

import com.application.myapp.dto.FormRequest;
import com.application.myapp.entity.SubmitFormEntity;
import com.application.myapp.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRepositoryService {

    @Autowired
    FormRepository formRepository;

     public ResponseEntity<SubmitFormEntity> saveData(FormRequest submitForm){
         SubmitFormEntity entity = SubmitFormEntity.build(0L,submitForm.getName(),submitForm.getAddress(),submitForm.getPhoneNumber(),submitForm.getAge());
           formRepository.save(entity);
         return ResponseEntity.ok(entity);
     }

     public List<SubmitFormEntity> getData(){
        return formRepository.findAll();
     }


     public List<SubmitFormEntity> getDataByField(String field){
         return  formRepository.findAll(Sort.by(Sort.Direction.ASC,field));
     }

     public Page<SubmitFormEntity> getDataByPagination(int offset, int pagesize){
         return  formRepository.findAll(PageRequest.of(offset,pagesize));
     }

     public Page<SubmitFormEntity> getDataByPaginationAndSorting(int offset, int pagesize,String field){
         return formRepository.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(field)));
     }



}
