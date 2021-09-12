package com.aripoo.admission_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.getById(id);
        return student;
    }

    public void addNewStudent(Student student) {
//        Optional<Student> studentEmail=studentRepository.findStudentByEmail(student.getEmail());
//        if(studentEmail.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional //SDJPA
    public void editStudent(Long studentId, String firstName, String lastName, String address, String city, String country, String phoneNumber, String major) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("student with id " + studentId + " does not exist"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (address != null && address.length() > 0 && !Objects.equals(student.getAddress(), address)) {
            student.setAddress(address);
        }

        if (city != null && city.length() > 0 && !Objects.equals(student.getCity(), city)) {
            student.setCity(city);
        }

        if (country != null && country.length() > 0 && !Objects.equals(student.getCountry(), country)) {
            student.setCountry(country);
        }

        if (phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(student.getPhoneNumber(), phoneNumber)) {
            student.setPhoneNumber(city);
        }

        if (major != null && major.length() > 0 && !Objects.equals(student.getMajor(), major)) {
            student.setMajor(major);
        }


    }
}
