package com.br.bufalo.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.bufalo.template.dto.SampleDto;
import com.br.bufalo.template.model.Sample;
import com.br.bufalo.template.service.SampleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleController {

    private final SampleService service;

    @Autowired
    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    SampleDto findSample(@PathVariable Long id) {
        Sample sample = this.service.findSample(id);
        return sample.toDto();
    }

    @GetMapping("/{id}")
    List<SampleDto> findSamples() {
        List<Sample> entities = this.service.findSamples();
        return entities.stream().map(Sample::toDto).toList();
    }

    @PostMapping("/create")
    SampleDto createSample(@RequestBody @Valid SampleDto sampleDto) {
        Sample sample = this.service.createSample(sampleDto);
        return sample.toDto();
    }
}
