/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author siti jahrona rambe
 */

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{
    
    @Column(name="student_id", nullable=false, unique=true)
    private String studentId;
    
    @ManyToMany(mappedBy = "student")
    private Set<Class> classes = new HashSet<>();
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher supervisor;
    
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<Score> scores = new HashSet<>();
    
    @ManyToOne
    private Meeting meeting;
    
    @ManyToOne
    private Assignment assignment;
    

    public Student(String username, String password, String studentId, Teacher supervisor) {
        super(username, password);
        this.studentId = studentId;
        this.supervisor = supervisor;
    }


    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the classes
     */
    public Set<Class> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    /**
     * @return the supervisor
     */
    public Teacher getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the scores
     */
    public Set<Score> getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
    
    public float calculateIPK() {
        float totalScore = 0;
        int i = 0;
        for (Score score : getScores()) {
            totalScore += score.getScore(); 
            i += 1;
        }
        return totalScore / i / 100 * 4;
    }
    
    public void printTranscript() {
        System.out.println("Student " + this.getStudentId());
        System.out.println("courseCode | courseName | Score");
        for (Score score : getScores()) {
            Course course = score.getCourse();
            System.out.printf("%s | %s | %s\n", course.getCourseId(), course.getName(), score.getScore());
        }
        System.out.println();
    }
    
}
