package workWithFilesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import workWithFilesTest.domain.Teacher;


import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class SelenideDownloadTest {
    ClassLoader cl = SelenideDownloadTest.class.getClassLoader();

    @Disabled
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
    void zipParsingTest() throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/cat.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("cat.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo("GingerFatCat");
            try (InputStream inputStream = zf.getInputStream(entry)) {
            }
        }
    }

    @Test
    void JSON() throws Exception {
        Gson gson = new Gson();
        try (InputStream stream = cl.getResourceAsStream("simple.json")) {
            String json = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            assertThat(jsonObject.get("name").getAsString()).isEqualTo("Daria");
            assertThat(jsonObject.get("address").getAsJsonObject().get("street").getAsString()).isEqualTo("lou");
        }

    }

    @Test
    void JSON2() throws Exception {
        Gson gson = new Gson();
        try (InputStream stream = cl.getResourceAsStream("simple.json")) {
            String json = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            Teacher jsonObject = gson.fromJson(json, (Type) Teacher.class);
            assertThat(jsonObject.name).isEqualTo("Daria");
            assertThat(jsonObject.address.street).isEqualTo("lou");
        }
    }
}

