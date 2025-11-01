package ru.chamortsev.data.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.chamortsev.data.service.data.Student;
import ru.chamortsev.data.service.data.StudentRepository;
import ru.chamortsev.data.api.StudentDataApi;
import ru.chamortsev.data.model.StudentDataCreateRequest;
import ru.chamortsev.data.model.StudentDataResponse;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentDataApi {


    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<StudentDataResponse> createStudentDataInData(StudentDataCreateRequest request) {
        Student student = new Student();
        student.setName(request.getFullName());
        student.setPassport(request.getPassport());
        studentRepository.save(student);
        StudentDataResponse response = new StudentDataResponse();
        response.setId(student.getId());
        response.setFullName(student.getName());
        response.setPassport(student.getPassport());

        return ResponseEntity.status(200).body(response);
    }

  /*@Override
  public ResponseEntity<StudentDataResponse> getStudentDataByIdFromData(Long id) {

    return ResponseEntity.status(200).body(response);
  }*/
}
