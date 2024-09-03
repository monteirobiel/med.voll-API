package med.voll.api.doctor;

public record DoctorRegisterData(String name,
                                 String email,
                                 String crm,
                                 Specialty specialty,
                                 AddressData address) {
}
