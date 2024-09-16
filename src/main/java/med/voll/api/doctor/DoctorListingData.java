package med.voll.api.doctor;

public record DoctorListingData(
        String name,
        String email,
        String phone,
        String crm,
        Specialty specialty) {

    public DoctorListingData(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty());
    }

}
