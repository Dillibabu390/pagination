package com.application.myapp.repository;

import com.application.myapp.entity.SubmitFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<SubmitFormEntity,Long> {
}
