package com.application.myapp.service;

import com.application.myapp.entity.SubmitFormEntity;
import com.application.myapp.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRepositoryService {

    @Autowired
    FormRepository formRepository;

     public SubmitFormEntity saveData(SubmitFormEntity submitForm){
           formRepository.save(submitForm);
           return submitForm;
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
