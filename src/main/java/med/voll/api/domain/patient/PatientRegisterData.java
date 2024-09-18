package med.voll.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.doctor.AddressData;

public record PatientRegisterData(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotNull @Valid
        AddressData address) {
}
