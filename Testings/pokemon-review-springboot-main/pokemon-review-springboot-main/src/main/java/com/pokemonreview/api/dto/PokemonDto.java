package com.pokemonreview.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PokemonDto {
    private int id;
    private String name;
    private String type;
}
