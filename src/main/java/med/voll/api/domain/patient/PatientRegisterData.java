package med.voll.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.doctor.AddressData;

public record PatientRegisterData(
        @NotBlank(message = "Name is mandatory!")
        String name,
        @Email
        String email,
        @NotBlank(message = "Phone is mandatory!")
        String phone,
        @NotBlank(message = "CPF is mandatory!") @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotNull(message = "Address is mandatory!") @Valid
        AddressData address) {
}
