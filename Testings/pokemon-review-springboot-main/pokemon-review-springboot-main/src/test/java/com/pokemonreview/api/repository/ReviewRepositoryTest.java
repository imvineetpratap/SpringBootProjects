package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ReviewRepositoryTest {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewRepositoryTest(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Test
    public void ReviewRepository_SaveAll_ReturnSaveReview(){
       Review review  = Review.builder()
               .title("title")
               .content("content")
               .stars(5)
               .build();
       Review savePokemonReview = reviewRepository.save(review);
        Assertions.assertNotNull(savePokemonReview);
        Assertions.assertTrue(savePokemonReview.getId()>0);
    }
    @Test
    public void ReviewRepository_GetAll_ReturnMoreThanOneReviews(){
        Review review  = Review.builder()
                .title("title")
                .content("content")
                .stars(5)
                .build();
        Review review2  = Review.builder()
                .title("title")
                .content("content")
                .stars(5)
                .build();
        reviewRepository.save(review);
        reviewRepository.save(review2);
        List<Review> reviews = reviewRepository.findAll();

        Assertions.assertNotNull(reviews);
        Assertions.assertTrue(reviews.size()>=2);
    }
    @Test
    public void ReviewRepository_FindById_ReturnSaveReview(){
        Review review  = Review.builder()
                .title("title")
                .content("content")
                .stars(5)
                .build();
        Review savePokemonReview = reviewRepository.save(review);
        Assertions.assertNotNull(savePokemonReview);
        Assertions.assertEquals(savePokemonReview.getId(), review.getId());
    }
    @Test
    public void ReviewRepository_UpdateReview_ReturnReview(){
        Review review  = Review.builder()
                .title("title")
                .content("content")
                .stars(5)
                .build();
        Review savePokemonReview = reviewRepository.save(review);
        review.setTitle("New title");
        review.setContent("Raichu");

        Review updatedPokemonReview =reviewRepository.save(review);
        Assertions.assertNotNull(updatedPokemonReview);
        Assertions.assertEquals(savePokemonReview.getId(), updatedPokemonReview.getId());
        Assertions.assertEquals(updatedPokemonReview.getContent(),"Raichu");
    }


    @Test
    public void ReviewRepository_DeleteReview_ReturnReviewIsEmpty(){
        Review review  = Review.builder()
                .title("title")
                .content("content")
                .stars(5)
                .build();
        reviewRepository.save(review);
        reviewRepository.deleteById(review.getId());
        Optional<Review> reviewReturn=reviewRepository.findById(review.getId());
        Assertions.assertFalse(reviewReturn.isPresent());
        Assertions.assertFalse(reviewRepository.existsById(review.getId()));
    }
}
