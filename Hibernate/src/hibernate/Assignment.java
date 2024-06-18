/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author siti jahrona rambe
 */

@Entity
@Table(name="assignment")
public class Assignment extends Activity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="assignment_id", nullable=false, unique=true)
    private String assignmentId;
    
    @Column(name="desription", nullable=false)
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Class classes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Teacher teacher;
    
    @Column(name="due_date", nullable=false)
    private LocalDateTime dueDate;
    
    @OneToMany(mappedBy = "assignment")
    private Set<Student> assignee = new HashSet<>();
    
    
    /**
     *
     * @param assignmentId
     * @param description
     * @param course
     * @param classes
     * @param teacher
     * @param dueDate
     */
    public Assignment(String assignmentId, String description, Course course, Class classes, Teacher teacher, LocalDateTime dueDate){
        this.assignmentId = assignmentId;
        this.description = description;
        this.course = course;
        this.classes = classes;
        this.teacher = teacher;
        this.dueDate = dueDate;
    }

    @Override
    String getDescription() {
        return description;
    }

    @Override
    Course getCourse() {
        return course;
    }

    @Override
    Class getClasses() {
        return classes;
    }

    @Override
    Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Class classes) {
        this.classes = classes;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the dueDate
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the assignee
     */
    public Set<Student> getAssignee() {
        return assignee;
    }

    /**
     * @param assignee the assignee to set
     */
    public void setAssignee(Set<Student> assignee) {
        this.assignee = assignee;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the assignmentId
     */
    public String getAssignmentId() {
        return assignmentId;
    }

    /**
     * @param assignmentId the assignmentId to set
     */
    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    
}
