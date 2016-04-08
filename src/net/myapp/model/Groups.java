package net.myapp.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="groups")
public class Groups {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = true)
	private Teacher teacher;
	private Date create_date;
	private String name;
	private int lesson_count;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<Student>  studentSet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getname() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLesson_count() {
		return lesson_count;
	}
	public void setLesson_count(int lesson_count) {
		this.lesson_count = lesson_count;
	}
	
	
	

}
