package com.eazybytes.eazyschool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
@Data annotation is provided by Lombok library which generates getter, setter,
equals(), hashCode(), toString() methods & Constructor at compile time.
This makes our code short and clean.
* */
@Data
public class Contact {

    /*
     * @NotNull:
     * Ensures that a field is not null.
     * It doesn't check if the value is empty or blank, just that it's not null.
     * Example use case: If you have a field that must always contain a value but it can be an empty string, then you can use
     * @NotNull.
     * @NotNull
     * private String name; // Valid: "", "John", Invalid: null
     *
     * @NotEmpty:
     * Ensures that a collection, array, or string is not null and has a length greater than 0.
     * It applies to fields like lists, arrays, and strings.
     * Example use case: When you want to make sure the field is not null and contains some elements, but it can still have
     * whitespace characters.
     * @NotEmpty
     * private String name; // Valid: "John", Invalid: "", null
     *
     * @NotBlank:
     * Specifically for strings, it ensures that a string is not null, is not empty, and contains at least one non-whitespace character.
     * Example use case: When you want to ensure a string contains actual content, not just spaces.
     * @NotBlank
     * private String name; // Valid: "John", Invalid: "", "  ", null
     *
     * */

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5, message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;
}
