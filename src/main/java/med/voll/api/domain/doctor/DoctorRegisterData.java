package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRegisterData(

        @NotBlank(message = "Name is mandatory!")
        String name,
        @Email
        String email,
        @NotBlank(message = "Phone is mandatory!")
        String phone,
        @NotBlank(message = "CRM is mandatory!") @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull(message = "Specialty is mandatory!")
        Specialty specialty,
        @NotNull(message = "Address is mandatory!") @Valid
        AddressData address) {
}
