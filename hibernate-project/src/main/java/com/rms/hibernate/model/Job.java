package com.rms.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "Job.findJobByJobId", query = "select job from Job job where job.jobId = :jobId") })

@Entity(name = "Job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long jobId;
	private String jobName;

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + "]";
	}

}
