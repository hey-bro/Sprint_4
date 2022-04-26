import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Test
    @DisplayName("ФИО не введено")
    public void putBlankFIOTest() {
        String fio = new String("");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("В ФИО менее 3 символов")
    public void put2SymbolsFIOTest() {
        String fio = new String("Ин");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("В ФИО более 20 символов")
    public void put20SymbolsFIOTest() {
        String fio = new String("Константинополь Иван");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пробел в начале ФИО")
    public void fioStartsWithWhitespaceTest() {
        String fio = new String(" Иван Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пробел в конце ФИО")
    public void fioEndsWithWhitespaceTest() {
        String fio = new String("Иван Иванов ");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("В ФИО 2 пробела")
    public void fioContains2WhitespacesTest() {
        String fio = new String("Иван  Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    @DisplayName("ФИО соответствует требованиям")
    public void fioMeetsRequirementsTest() {
        String fio = new String("Марк Глушков");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertTrue(actual);
    }

}