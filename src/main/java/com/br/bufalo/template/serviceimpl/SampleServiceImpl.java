package com.br.bufalo.template.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.bufalo.template.dto.SampleDto;
import com.br.bufalo.template.error.CustomException;
import com.br.bufalo.template.model.Sample;
import com.br.bufalo.template.repository.SampleRepository;
import com.br.bufalo.template.service.SampleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SampleServiceImpl implements SampleService {

    private final SampleRepository repository;

    @Autowired
    public SampleServiceImpl(SampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sample findSample(Long id) {
        log.debug("Getting sample by Id");
        return this.repository.getSampleById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Sample not found"));
    }

    @Override
    public List<Sample> findSamples() {
        log.debug("Getting all samples");
        return this.repository.findAll();
    }

    @Override
    public Sample createSample(SampleDto dto) {
        log.debug("Creating Sample");
        Sample sample = dto.toEntity();
        return this.repository.save(sample);
    }
}
