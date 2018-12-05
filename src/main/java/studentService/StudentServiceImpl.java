package studentService;

import model.Student;
import scanner.ScanStudent;

public class StudentServiceImpl implements StudentService {
    private ScanStudent sc;

    public StudentServiceImpl(ScanStudent sc) {this.sc = sc;}

    public Student getCurrentStudent() {
        return sc.getName();
    }
}
