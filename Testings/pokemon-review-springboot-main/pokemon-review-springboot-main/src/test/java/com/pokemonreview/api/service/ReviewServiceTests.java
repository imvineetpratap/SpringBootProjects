package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.ReviewDto;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.repository.ReviewRepository;
import com.pokemonreview.api.service.impl.ReviewServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTests {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private PokemonRepository pokemonRepository;
    @InjectMocks
    private ReviewServiceImpl reviewService;

    private Pokemon pokemon;
    private Review review;
    private ReviewDto reviewDto;

    @BeforeEach
    public void setUp() {
        pokemon = Pokemon.builder().name("pikachu").type("electric").build();
        review = Review.builder().title("title").content("content").stars(5).build();
        reviewDto = ReviewDto.builder().id(1).title("review title").content("test content").stars(5).build();
    }

    @Test
    public void ReviewService_CreateReview_ReturnsReviewDto() {
        when(pokemonRepository.findById(pokemon.getId())).thenReturn(Optional.of(pokemon));
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);
        ReviewDto reviewDto1 = reviewService.createReview(pokemon.getId(), reviewDto);
        System.out.println(reviewDto1.toString());
        Assertions.assertThat(reviewDto1).isNotNull();
    }

    @Test
    public void ReviewService_GetReviewsByPokemonId_ReturnReviewDto() {
        int reviewId = 1;
        when(reviewRepository.findByPokemonId(reviewId)).thenReturn(Arrays.asList(review));
        List<ReviewDto> reviewDtoList = reviewService.getReviewsByPokemonId(reviewId);
        Assertions.assertThat(reviewDtoList).isNotNull();
    }

    @Test
    public void ReviewService_GetReviewById_ReturnReviewDto() {
        int reviewId = 1;
        int pokemonId = 1;
        review.setPokemon(pokemon);
        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
        ReviewDto reviewDto1 = reviewService.getReviewById(reviewId, pokemonId);
        Assertions.assertThat(reviewDto1).isNotNull();
    }

    @Test
    public void ReviewService_UpdateReview_ReturnReviewDto() {
        int reviewId = 1;
        int pokemonId = 1;
        review.setPokemon(pokemon);
        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);
        ReviewDto reviewDto1 = reviewService.updateReview(reviewId, pokemonId, reviewDto);
        Assertions.assertThat(reviewDto1).isNotNull();
        Assertions.assertThat(review.getPokemon()).isEqualTo(pokemon);
    }

    @Test
    public void ReviewService_DeleteReview_ReturnVoid() {
        int reviewId = 1;
        int pokemonId = 1;
        pokemon.setReviews(Arrays.asList(review));
        review.setPokemon(pokemon);
        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        doNothing().when(reviewRepository).delete(review);
        assertAll(() -> reviewService.deleteReview(pokemonId, reviewId));
    }
}
