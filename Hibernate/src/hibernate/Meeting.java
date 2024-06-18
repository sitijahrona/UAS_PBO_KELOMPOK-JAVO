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
@Table(name="meeting")
public class Meeting extends Activity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="meeting_id", nullable=false, unique=true)
    private String meetingId;

    @Column(name="desription", nullable=false)
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Class classes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Teacher teacher;
    
    @Column(name="meeting_time", nullable=false)
    private LocalDateTime meetingTime;
    
    @OneToMany(mappedBy = "meeting")
    private Set<Student> attendees = new HashSet<>();
    
//    private Set<Student> attendees = new HashSet<>();
   
    /**
     *
     * @param meetingId
     * @param description
     * @param course
     * @param classes
     * @param teacher
     * @param meetingTime
     */
    public Meeting(String meetingId, String description, Course course, Class classes, Teacher teacher, LocalDateTime meetingTime){
        this.meetingId = meetingId;
        this.description = description;
        this.course = course;
        this.classes = classes;
        this.teacher = teacher;
        this.meetingTime = meetingTime;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public Class getClasses() {
        return classes;
    }

    @Override
    public Teacher getTeacher() {
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
     * @return the meetingTime
     */
    public LocalDateTime getMeetingTime() {
        return meetingTime;
    }

    /**
     * @param meetingTime the meetingTime to set
     */
    public void setMeetingTime(LocalDateTime meetingTime) {
        this.meetingTime = meetingTime;
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
     * @return the meetingId
     */
    public String getMeetingId() {
        return meetingId;
    }

    /**
     * @param meetingId the meetingId to set
     */
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    /**
     * @return the attendees
     */
    public Set<Student> getAttendees() {
        return attendees;
    }

    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(Set<Student> attendees) {
        this.attendees = attendees;
    }

    
}
