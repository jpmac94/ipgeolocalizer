package com.interview.ipgeolocalizer.repository;

import com.interview.ipgeolocalizer.model.Cotization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizationRepository extends CrudRepository<Cotization,String> {
}
