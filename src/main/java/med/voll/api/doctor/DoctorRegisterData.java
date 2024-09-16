package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorRegisterData(

        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull @Valid
        AddressData address) {
}
