package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(

        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String uf,
        String complement,
        String number) {
}
