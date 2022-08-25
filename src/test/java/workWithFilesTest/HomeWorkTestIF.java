package workWithFilesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("DownloadFiles")
public class HomeWorkTestIF {
    ClassLoader cl = SelenideDownloadTest.class.getClassLoader();
    private String pdfName = "Guide.RU.pdf";
    String xlsxName = "sample-xlsx-file.xlsx";
    String csvName = "teachers.html";

    @Owner("DariaSmit")
    @Severity(SeverityLevel.MINOR)
    @Feature("Тестинг загрузки и прверки файлов")

    @Test
    void checkFilesTest() throws Exception {
        ZipFile ar = new ZipFile(new File("src/test/resources/Work.zip"));
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("Work.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                try (InputStream inputStream = ar.getInputStream(entry)) {
                    if (entry.getName().equals(pdfName)) {

                        PDF pdf = new PDF(inputStream);
                        Assertions.assertEquals(59, pdf.numberOfPages);
                        assertThat(pdf, new ContainsExactText("200 миллионов"));
                    }
                    if (entry.getName().equals(csvName)) {
                        CSVReader reader = new CSVReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                        {

                            List<String[]> content = reader.readAll();
                            org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo(csvName);
                            org.assertj.core.api.Assertions.assertThat(content).containsAnyOf(

                                    new String[]{"Name", "Surname"},
                                    new String[]{"Dmitrii", "Tuchs"});
                        }
                        if (entry.getName().equals(xlsxName)) {
                            XLS xls = new XLS(inputStream);
                            String stringCellValue = xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue();
                            org.assertj.core.api.Assertions.assertThat(stringCellValue).contains("Philip");
                        }
                    }
                }

            }
        }
    }
}