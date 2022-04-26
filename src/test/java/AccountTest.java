import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Test
    public void putBlankFIOTest() {
        String fio = new String("");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void put2SymbolsFIOTest() {
        String fio = new String("Ин");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void put20SymbolsFIOTest() {
        String fio = new String("Константинополь Иван");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void fioStartsWithWhitespaceTest() {
        String fio = new String(" Иван Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void fioEndsWithWhitespaceTest() {
        String fio = new String("Иван Иванов ");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void fioContains2WhitespacesTest() {
        String fio = new String("Иван  Иванов");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertFalse(actual);
    }

    @Test
    public void fioMeetsRequirementsTest() {
        String fio = new String("Марк Глушков");
        Account account = new Account(fio);
        boolean actual = account.checkNameToEmboss();
        assertTrue(actual);
    }

}