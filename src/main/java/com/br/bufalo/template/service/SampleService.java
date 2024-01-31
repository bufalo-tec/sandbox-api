package com.br.bufalo.template.service;

import java.util.List;

import com.br.bufalo.template.dto.SampleDto;
import com.br.bufalo.template.model.Sample;

public interface SampleService {

    Sample findSample(Long id);

    List<Sample> findSamples();

    Sample createSample(SampleDto sampleDto);
}
