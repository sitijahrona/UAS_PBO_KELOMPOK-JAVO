/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;

import javax.persistence.ManyToOne;

/**
 *
 * @author siti jahrona rambe
 */
public abstract class Activity { 
    abstract String getDescription();
    abstract Course getCourse();
    abstract Class getClasses();
    abstract Teacher getTeacher();
    
    @ManyToOne
    private Class classes;
    
}
