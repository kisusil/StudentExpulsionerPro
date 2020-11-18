package education.data;

/**
 * Заключение об отчислении студента. Класс хранит логическое значения состояния студента (отчислен/не отчислен),
 * а также пояснение (Если не отчислен, то пишется почему именно (Решение монетки/Все экзамены сданы и т.д).
 */
public class Conclusion {
    private boolean isExpelled;
    private String clarification;
    // Конструктор без параметров нужен для создания студентов, которые еще не рассматривались отчислятором.
    public Conclusion() {
        isExpelled = false;
        clarification = "Not resolved";
    }


    public Conclusion(boolean isExpelled, String clarification) {
        this.isExpelled = isExpelled;
        this.clarification = clarification;
    }

    public boolean isExpelled() {
        return isExpelled;
    }

    public void setExpelled(boolean expelled) {
        isExpelled = expelled;
    }

    public String getClarification() {
        return clarification;
    }

    public void setClarification(String clarification) {
        this.clarification = clarification;
    }
}