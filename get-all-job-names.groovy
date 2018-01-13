#!/usr/bin/env groovy

/**
 * @ Maintainer sudheer veeravalli<veersudhir83@gmail.com>
 * Gets the names of all the jobs in the instance
 * Prepends "Generic:" for normal freestyle and other category of jobs
 * Prepends "Pipeline:" for all workflow/multibranch pipeline jobs
*/

def arr = new ArrayList<String>();
Jenkins.instance.getAllItems(AbstractProject.class).each {it ->
  arr.add("Generic:" + it.fullName)
}

def jobs = Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)*.fullName
Iterator<?> iterator = jobs.iterator();
while (iterator.hasNext()) {
    arr.add("Pipeline:" + iterator.next());
}
println arr
