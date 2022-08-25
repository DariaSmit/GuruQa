package workWithFilesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class SelenideDownloadTest {
    ClassLoader cl = SelenideDownloadTest.class.getClassLoader();

    @Test
    void downloadTest() throws Exception {

        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File textFile = $("#raw-url").download(); // обязательна ссылка href для download
        InputStream is = new FileInputStream(textFile);
        try {
            //try InputStream is = new FileInputStream(textFile); finally не нужен

            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            org.assertj.core.api.Assertions.assertThat(strContent).contains("JUnit 5");

        } finally {
            is.close();
        }
    }


    @Test
    void pdfParsingTest() throws Exception {

        InputStream stream = cl.getResourceAsStream("junit-user-guide-5.9.0.pdf");
        PDF pdf = new PDF(stream);
        Assertions.assertEquals(179, pdf.numberOfPages);
        assertThat(pdf, new ContainsExactText("123"));

    }

    @Test
    void xlsParsingTest() throws Exception {
        InputStream stream = cl.getResourceAsStream("sample-xlsx-file.xlsx");
        XLS xls = new XLS(stream);
        String stringCellValue = xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue();
        org.assertj.core.api.Assertions.assertThat(stringCellValue).contains("Philip");
    }

    @Test
    void csvParsingTest() throws Exception {
        try (
                InputStream stream = cl.getResourceAsStream("teacher.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {

            List<String[]> content = reader.readAll();
            org.assertj.core.api.Assertions.assertThat(content).contains(

                    new String[]{"Oleg", "Egorov"},
                    new String[]{"Nick", "Summer"});
        }

    }
    @Test
    void zipParsingTest () throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/cat.zip"));
        ZipInputStream is = new ZipInputStream( cl.getResourceAsStream("cat.zip"));
        ZipEntry entry;
        while((entry = is.getNextEntry()) != null) {
            org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo("GingerFatCat");
            try ( InputStream inputStream = zf.getInputStream(entry)){
                       }
                 }
          }
    }

