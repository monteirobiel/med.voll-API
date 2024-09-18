package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        AddressData address) {
}
