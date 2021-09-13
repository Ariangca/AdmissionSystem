package com.aripoo.admission_system.teacher;

import com.aripoo.admission_system.teacher.Teacher;
import com.aripoo.admission_system.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();

    }

    public Teacher getTeacherById(Long id) {
        Teacher teacher = teacherRepository.getById(id);
        return teacher;
    }

    public void addNewTeacher(Teacher teacher) {
//        Optional<Teacher> teacherEmail=teacherRepository.findTeacherByEmail(teacher.getEmail());
//        if(teacherEmail.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw new IllegalStateException("teacher with id " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }

    @Transactional //SDJPA
    public void editTeacher(Long teacherId, String firstName, String lastName,
                            String address, String city, String country,
                            String phoneNumber, Long salary) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new IllegalStateException("teacher with id " + teacherId + " does not exist"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(teacher.getFirstName(), firstName)) {
            teacher.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(teacher.getLastName(), lastName)) {
            teacher.setLastName(lastName);
        }

        if (address != null && address.length() > 0 && !Objects.equals(teacher.getAddress(), address)) {
            teacher.setAddress(address);
        }

        if (city != null && city.length() > 0 && !Objects.equals(teacher.getCity(), city)) {
            teacher.setCity(city);
        }

        if (country != null && country.length() > 0 && !Objects.equals(teacher.getCountry(), country)) {
            teacher.setCountry(country);
        }

        if (phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(teacher.getPhoneNumber(), phoneNumber)) {
            teacher.setPhoneNumber(city);
        }

//        Long salaryLong=Long.parseLong(salary);
        if (salary != null && salary > 0 && !Objects.equals(teacher.getSalary(), salary)) {
            teacher.setSalary(salary);
        }


    }
}
