import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void putBlankFIO() {
        String fio = new String("");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void put2SymbolsFIO() {
        String fio = new String("Ин");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void put20SymbolsFIO() {
        String fio = new String("Константинополь Иван");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void fioStartsWithWhitespace() {
        String fio = new String(" Иван Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void fioEndsWithWhitespace() {
        String fio = new String("Иван Иванов ");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void fioContains2Whitespaces() {
        String fio = new String("Иван  Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    void fioMeetsRequirements() {
        String fio = new String("Марк Глушков");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertTrue(actual);
    }

}