package io.zipcoder;

import java.util.*;

public class Classroom {
    int maxNumberOfStudents;
    private Student[] students;

    public Classroom() {
        new Classroom(30);
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Student[] students() {
        return this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        List<Student> newStud = new ArrayList<>(Arrays.asList(students));
        newStud.add(student);


    }

    public void removeStudent(String firstName, String secondName) {
        List<Student> newStud = new ArrayList<>(Arrays.asList(students));
        for (int x = 0; x < newStud.size(); x++) {
            if (newStud.get(x).equals(firstName) && newStud.get(x).equals(secondName)) {
                newStud.remove(students[x]);
            }
        }

    }

    public Student[] getStudentsByScore() {
        List<Student> newSort = new ArrayList<>(Arrays.asList(students));
        for (int x = 0; x < newSort.size(); x++) {
            if (newSort.get(x) == null) {
                newSort.remove(newSort.get(x));
            }
        }
        Comparator<Student> comparator = Comparator.comparingDouble((Student s) -> -s.getAverageExamScore())
                .thenComparing(s -> s.getFirstName())
                .thenComparing(s -> s.getLastName());
        newSort.sort(comparator);
        return newSort.toArray((newSort.toArray(new Student[students.length])));
    }

    public HashMap<Student, String> getGradeBook() {
        List<Double> studentGrades = new ArrayList<>();
        for (Student s : students) {
            studentGrades.add(s.getAverageExamScore());
        }
        Collections.sort(studentGrades);
        HashMap<Student, String> gradeBook = new HashMap<>();
        for (int x = 0; x < studentGrades.size(); x++) {
            double total = studentGrades.size();
            double ranking = x - total - 1 / studentGrades.size() * 100;
            double percentileRange = ranking * 100;
            if (percentileRange >= 90) {
                gradeBook.put(students[x], "A");
            } else if (percentileRange <= 89 && percentileRange >= 80) {
                gradeBook.put(students[x], "B");
            } else if (percentileRange <= 79 && percentileRange >= 70) {
                gradeBook.put(students[x], "C");
            } else if (percentileRange <= 69 && percentileRange >= 60) {
                gradeBook.put(students[x], "D");

            } else  {
                gradeBook.put(students[x], "F");
            }
        }


        return (HashMap<Student, String>) gradeBook.keySet();
    }
}
