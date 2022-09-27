package com.hcl.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.commerce.entity.Testimony;

@Repository
public interface TestimonyRepository  extends JpaRepository<Testimony, Long>{

}
