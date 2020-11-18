package education.data;

import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String fullName;
    private Faculty faculty;
    private Conclusion conclusion;
    private Subject subject;

    public Student(String fullName, Faculty faculty, List<Boolean> examResults) {
        this.fullName = fullName;
        this.faculty = faculty;
        conclusion = new Conclusion();
        /*
        В Subject вы формируем результаты экзаменов, на основе факультета, откуда мы берем список предметов,
        и на основе самих результатов, переданных в качестве параметра. Не отрицаю, что лучше было бы передать
        просто Map в качестве параметра, но тогда получится, что каждый ученик может иметь разное количество
        предметов и на уровне кода это никак не будет контролироваться. В нашем случае, будет бросаться исключение в случае
        несходимости количества предметов и количества результатов.
         */
        subject = new Subject(faculty, examResults);
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }
    public Conclusion getConclusion() {
        return conclusion;
    }

    public Subject getSubjectList() {
        return subject;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return new Formatter()
                .format("Full name: %s\n" +
                                "Faculty: %s\n" +
                                "Expulsion decision: %s\n" +
                                "Clarification: %s\n",
                        fullName, faculty, conclusion.isExpelled(), conclusion.getClarification())
                .toString();
    }

    public class Subject {
        private Map<String, Boolean> results;

        public Subject(Faculty faculty, List<Boolean> examResults) {
            results = new HashMap<>();
            List<String> subjects = faculty.getSubjects();
            if(subjects.size() != examResults.size()) {
                throw new IndexOutOfBoundsException(
                        fullName + "'s subject list doesn't suitable for the faculty: " + faculty.name());
            }
            for (int i = 0; i < examResults.size(); i++) {
                results.put(subjects.get(i), examResults.get(i));
            }
        }

        public boolean hasFailedExam() {
            for (Map.Entry<String, Boolean> m: results.entrySet()) {
                if(!m.getValue()) return true;
            }
            return false;
        }

        public String failedExams() {
            String result = "";
            for (Map.Entry<String, Boolean> m: results.entrySet()) {
                if(m.getValue() == false) result += m.getKey() + ", ";
            }
            if(result.equals("")) return "All subjects have been passed";
            return result.substring(0, result.length() - 2);
        }
    }
}