package io.buildforsdgcohort2.ecargo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.buildforsdgcohort2.ecargo.model.base.BaseDto;
import io.buildforsdgcohort2.ecargo.model.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto  extends BaseDto {

    @JsonProperty("review")
    private String review;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("user")
    private UserDto user;

    @JsonProperty("driver")
    private UserDto driver;

    public static ReviewDto toDto(Review review) {
        return new ReviewDto(review.getReview(), review.getRating(), UserDto.toUserDto(review.getUser()),
                UserDto.toUserDto(review.getDriver()));
    }

    public static List<ReviewDto> toDto(List<Review> reviews) {
        List<ReviewDto> reviewsDto = new ArrayList<>();

        for (Review review : reviews) {
            reviewsDto.add(ReviewDto.toDto(review));
        }

        return reviewsDto;
    }

}
