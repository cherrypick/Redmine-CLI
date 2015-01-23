package com.xeonlab.redmine.cli.response;

import java.util.Date;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-23
 */
final public class Issue {
    private int id;
    private int doneRatio;
    private double estimatedHours;
    private String subject;
    private String description;
    private EnumeratedValue priority;
    private EnumeratedValue assignedTo;
    private EnumeratedValue project;
    private EnumeratedValue tracker;
    private EnumeratedValue author;
    private EnumeratedValue category;
    private EnumeratedValue status;
    private EnumeratedValue fixedVersion;
    private EnumeratedValue parent;
    private Date dueDate;
    private Date startDate;
    private Date createdOn;
    private Date updatedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoneRatio() {
        return doneRatio;
    }

    public void setDoneRatio(int doneRatio) {
        this.doneRatio = doneRatio;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumeratedValue getPriority() {
        return priority;
    }

    public void setPriority(EnumeratedValue priority) {
        this.priority = priority;
    }

    public EnumeratedValue getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(EnumeratedValue assignedTo) {
        this.assignedTo = assignedTo;
    }

    public EnumeratedValue getProject() {
        return project;
    }

    public void setProject(EnumeratedValue project) {
        this.project = project;
    }

    public EnumeratedValue getTracker() {
        return tracker;
    }

    public void setTracker(EnumeratedValue tracker) {
        this.tracker = tracker;
    }

    public EnumeratedValue getAuthor() {
        return author;
    }

    public void setAuthor(EnumeratedValue author) {
        this.author = author;
    }

    public EnumeratedValue getCategory() {
        return category;
    }

    public void setCategory(EnumeratedValue category) {
        this.category = category;
    }

    public EnumeratedValue getStatus() {
        return status;
    }

    public void setStatus(EnumeratedValue status) {
        this.status = status;
    }

    public EnumeratedValue getFixedVersion() {
        return fixedVersion;
    }

    public void setFixedVersion(EnumeratedValue fixedVersion) {
        this.fixedVersion = fixedVersion;
    }

    public EnumeratedValue getParent() {
        return parent;
    }

    public void setParent(EnumeratedValue parent) {
        this.parent = parent;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return subject + " (#" + id + ")";
    }
}
