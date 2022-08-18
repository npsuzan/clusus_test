package com.clusus.repository;

import com.clusus.entity.Deal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DealRepository extends CrudRepository<Deal,Long>{

}