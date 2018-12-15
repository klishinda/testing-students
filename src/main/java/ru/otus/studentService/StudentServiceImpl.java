package ru.otus.studentService;

import org.springframework.stereotype.Service;
import ru.otus.model.Student;
import ru.otus.scanner.ScanStudent;

@Service
public class StudentServiceImpl implements StudentService {
    private ScanStudent sc;

    public StudentServiceImpl(ScanStudent sc) {this.sc = sc;}

    public Student getCurrentStudent() {
        return sc.getName();
    }
}