package med.voll.api.doctor;

public record DoctorListData(
        String name,
        String email,
        String phone,
        String crm,
        Specialty specialty) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty());
    }

}
