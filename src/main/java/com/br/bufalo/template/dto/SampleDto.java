package com.br.bufalo.template.dto;

import com.br.bufalo.template.model.Sample;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {

    @Positive(message = "Id can't be negative")
    private Long id;

    @NotNull(message = "Name can't be null")
    private String name;

    public Sample toEntity() {
        return Sample.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

}
