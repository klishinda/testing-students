package dao;

import au.com.bytecode.opencsv.CSVReader;
import model.Questionnaire;
import model.Result;
import scanner.ScanStudent;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CsvReaderImpl implements CsvReader {
    private ScanStudent sc;

    public CsvReaderImpl(ScanStudent sc) {this.sc = sc;}

    private static final String CSV_FILE_PATH = "src/main/resources/questions.csv";

    private ArrayList<Questionnaire> quizArray;

    private void readCsv() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            quizArray= new ArrayList();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                quizArray.add(new Questionnaire(nextRecord[0], nextRecord[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result start() {
        readCsv();
        System.out.println("Вопросы подготовлены, начинаем опрос.");
        return sc.startQuestionnaire(quizArray);
    }
}
