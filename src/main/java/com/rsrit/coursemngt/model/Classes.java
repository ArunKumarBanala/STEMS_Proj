package com.rsrit.coursemngt.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "classes_m")
public class Classes {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASSID")
	private int classId;
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "CLASSNAME")
	private String className;
	
	@Column(name = "TRAINERID")
	private int trainerId;
	
	@Column(name = "TRAINERNAME")
	private String trainerName;
	
	@Column(name = "STUDENTSIDS")
	private String studentsIds;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="CREATEDON")
	private Timestamp createdOn;
	
	@Column(name="CREATEDBY")
	private String createdBy;
	
	@OneToMany(mappedBy = "classes")
	private List<Session> listOfSessions;
	
	@OneToOne
	@JoinColumn(name = "SCHEDULEID")
	private Schedule schedule;

	@JsonCreator
	public Classes(int classId, @JsonProperty(value = "className", required = true) @NotNull String className,
			@JsonProperty(value = "trainerId", required = true) int trainerId,
			@JsonProperty(value = "trainerName", required = true) String trainerName,
			@JsonProperty(value = "studentsIds", required = true) String studentsIds, Timestamp createdOn,
			String createdBy, List<Session> listOfSessions, Schedule schedule) {
		super();
		this.classId = classId;
		this.className = className;
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.studentsIds = studentsIds;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.listOfSessions = listOfSessions;
		this.schedule = schedule;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getStudentsIds() {
		return studentsIds;
	}

	public void setStudentsIds(String studentsIds) {
		this.studentsIds = studentsIds;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Session> getListOfSessions() {
		return listOfSessions;
	}

	public void setListOfSessions(List<Session> listOfSessions) {
		this.listOfSessions = listOfSessions;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", trainerId=" + trainerId
				+ ", trainerName=" + trainerName + ", studentsIds=" + studentsIds + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", listOfSessions=" + listOfSessions + ", schedule=" + schedule + "]";
	}

}
