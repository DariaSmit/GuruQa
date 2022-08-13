package com.demoqaLession2;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleTests {


    @BeforeEach
    void openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void close() {
        Selenide.closeWindow();
    }

    @Test
    void assertTest() {
        // открытие формы регистрации
    }
}

