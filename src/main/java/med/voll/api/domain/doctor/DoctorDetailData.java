package med.voll.api.domain.doctor;

public record DoctorDetailData(Long id, String name, String email, String phone, String crm, Specialty specialty, Address address ) {

    public DoctorDetailData (Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty(), doctor.getAddress());
    }
}
