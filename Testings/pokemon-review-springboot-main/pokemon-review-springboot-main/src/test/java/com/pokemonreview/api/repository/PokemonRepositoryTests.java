package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PokemonRepositoryTests {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void PokemonRepository_SaveAll_ReturnSaved() {
        //Arrange
        Pokemon pokemon= Pokemon.builder()
                .name("Pikachu")
                .type("Electric")
                .build();
        //Act
        Pokemon savedPokemon= pokemonRepository.save(pokemon);
        System.out.println(savedPokemon);
        //Assert
        Assertions.assertNotNull(savedPokemon);
        assertTrue(savedPokemon.getId() > 0);
    }

    @Test
    public void PokemonRepository_GetAll_ReturnMoreThaOnePokemon(){
        //Arrange
        Pokemon pokemon1= Pokemon.builder().name("Pikachu").type("Electric").build();
        Pokemon pokemon2= Pokemon.builder().name("Pikachu").type("Electric").build();
        //Act
        pokemonRepository.save(pokemon1);
        pokemonRepository.save(pokemon2);
        List<Pokemon> pokemonList= pokemonRepository.findAll();
    System.out.println("size of list:"+pokemonList.size());
        //Assert
        Assertions.assertNotNull(pokemonList);
        assertTrue(pokemonList.size() >= 2);
    }

    @Test
    public void PokemonRepository_FindById_ReturnPokemon(){
        //Arrange
        Pokemon pokemon= Pokemon.builder().name("Pikachu").type("Electric").build();
        //Act
       pokemonRepository.save(pokemon);
       Pokemon pokemonList= pokemonRepository.findById(pokemon.getId()).get();
        //Assert
        Assertions.assertNotNull(pokemonList);
        assertTrue(pokemonList.getName().equals("Pikachu"));
    }
    @Test
    public void PokemonRepository_FindByType_ReturnPokemonNotNull(){
        //Arrange
        Pokemon pokemon= Pokemon.builder().name("Pikachu").type("Electric").build();
        //Act
        pokemonRepository.save(pokemon);
        Optional<Pokemon> pokemonList= pokemonRepository.findByType(pokemon.getType());
        //Assert
        Assertions.assertNotNull(pokemonList);
    }


    @Test
    public void PokemonRepository_UpdatePokemon_ReturnPokemonNotNull(){
        //Arrange
        Pokemon pokemon= Pokemon.builder().name("Pikachu").type("Electric").build();
        //Act
        pokemonRepository.save(pokemon);


        Pokemon pokemonsaved= pokemonRepository.findById(pokemon.getId()).get();
       pokemonsaved.setType("electric");
       pokemonsaved.setName("Raichu");
       Pokemon updatedPokemon= pokemonRepository.save(pokemonsaved);
        //Assert
       Assertions.assertNotNull(updatedPokemon.getName());
        assertEquals("Raichu", updatedPokemon.getName());
        assertEquals("electric", updatedPokemon.getType());
    }

    @Test
    public void PokemonRepository_DeleteById_ReturnPokemonNotNull(){
        //Arrange
        Pokemon pokemon= Pokemon.builder().name("Pikachu").type("Electric").build();
        //Act
        pokemonRepository.save(pokemon);
        pokemonRepository.deleteById(pokemon.getId());
        Optional<Pokemon> pokemonList= pokemonRepository.findById(pokemon.getId());
        //Assert
        assertTrue(pokemonList.isEmpty());
    }

}
