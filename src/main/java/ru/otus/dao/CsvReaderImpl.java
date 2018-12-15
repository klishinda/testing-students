package ru.otus.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.model.Language;
import ru.otus.model.Questionnaire;
import ru.otus.model.Result;
import ru.otus.scanner.ScanStudent;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Repository
public class CsvReaderImpl implements CsvReader {
    private ScanStudent sc;

    @Autowired
    private MessageSource ms;

    public CsvReaderImpl(ScanStudent sc) {this.sc = sc;}

    private ArrayList<Questionnaire> quizArray;

    private void readCsv() throws CsvReaderException {
        final String CSV_FILE_PATH = ms.getMessage("csv_reader.path_to_csv", null, Language.language);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            quizArray = new ArrayList();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord[0].isEmpty() && nextRecord[1].isEmpty()) {
                    throw new CsvReaderException(ms.getMessage("csv_reader.exceptions.empty_strings", null, Language.language));
                }
                else if (nextRecord[0].isEmpty()) {
                    throw new CsvReaderException(ms.getMessage("csv_reader.exceptions.empty_questions", null, Language.language));
                }
                else if (nextRecord[1].isEmpty()) {
                    throw new CsvReaderException(ms.getMessage("csv_reader.exceptions.empty_answers", null, Language.language));
                }
                quizArray.add(new Questionnaire(nextRecord[0], nextRecord[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result start() throws CsvReaderException {
        readCsv();
        System.out.println(ms.getMessage("csv_reader.questions_ready", null, Language.language));
        return sc.startQuestionnaire(quizArray);
    }
}
