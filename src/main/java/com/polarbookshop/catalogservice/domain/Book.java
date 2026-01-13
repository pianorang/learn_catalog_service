package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book (
    @NotBlank
    @Pattern(
        regexp = "^([0-9]{10}|[0-9]{13})$",
        message = "Invalid ISBN format"
    )
    String isbn,

    @NotBlank(
        message = "The book title must be defined"
    )
    String title,

    @NotBlank(
        message = "The book author must be defined"
    )
    String author,

    @NotNull(
        message = "The book price must be defined"
    )
    @Positive(
        message = "The book price must be greater than zero"
    )
    Double price
){
}
