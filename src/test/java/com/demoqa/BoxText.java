package com.demoqa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoxText {

    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        // открытие формы регистрации
    }

    @Test
    void assertTest1() {
    }
}

