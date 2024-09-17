package med.voll.api.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.doctor.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData address
) {
}
