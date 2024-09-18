package med.voll.api.domain.patient;

public record PatientListingData(Long id, String name, String email, String cpf) {

    public PatientListingData(Patient patients) {
        this(patients.getId(), patients.getName(), patients.getEmail(), patients.getCpf());
    }
}


