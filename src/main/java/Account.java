public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name.isEmpty()) {
            System.out.println("Пустое имя");
            return false;
        } else if (name.length() < 3 || name.length() > 19) {
            System.out.println("Имя должно содержать от 3 до 19 символов");
            return false;
        } else if (Character.isWhitespace(name.charAt(0)) || Character.isWhitespace(name.charAt(name.length() - 1))) {
            System.out.println("Имя не должно начинаться или заканчиваться пробелом");
            return false;
        } else if (name.length() - name.replace(" ", "").length() > 1) {
            System.out.println("Имя не содержит пробела или содержит более одного пробела");
            return false;
        } System.out.println("Карта выпущена: " + name);
        return true;
    }

}