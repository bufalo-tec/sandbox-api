package com.br.bufalo.template.model;

import com.br.bufalo.template.dto.SampleDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sample")
@Getter
@Setter
@Builder
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_id")
    @SequenceGenerator(name = "sample_id", sequenceName = "sample_id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    public SampleDto toDto() {
        return SampleDto.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
