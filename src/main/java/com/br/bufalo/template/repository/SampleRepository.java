package com.br.bufalo.template.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.bufalo.template.model.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    @Query("select e from Sample e where e.id = :id")
    Optional<Sample> getSampleById(Long id);
}
