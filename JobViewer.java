import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobViewer {
    private static class Job {
        private final int jobId;
        private final String name;
        private final int time;

        private static class Builder {
            private int jobId;
            private String name;
            private int time;

            private Builder withJobId(int jobId) {
                this.jobId = jobId;
                return this;
            }

            private Builder withDuration(int time) {
                this.time = time;
                return this;
            }

            private Builder withName(String name) {
                this.name = name;
                return this;
            }

            private Job build(){
                return new Job(this);
            }

        }
        private Job(Builder builder) {
            this.jobId = builder.jobId;
            this.name = builder.name;
            this.time = builder.time;
        }

        @Override
        public boolean equals(Object obj) {
            Job job;

            if(!(obj instanceof Job)) {
                return false;
            }
            job = (Job) obj;

            return this.jobId == job.jobId;
        }

        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;

            result = prime * result + this.jobId;

            return result;
        }

        @Override
        public String toString() {
            return "name=" + name + ", " + "time=" + time;
        }

        public int getJobId() {
            return jobId;
        }

        public int getTime() {
            return time;
        }

        public String getName() {
            return name;
        }
    }
    private static void extractTopDurationJobs(String[] jobs, int k) {
        List<Job> jobsList = new ArrayList<>();
        Arrays.stream(jobs)
            .forEach(job -> jobsList.add(generateJobFromString(jobsList, job)));
        Collections.sort(jobsList, Comparator.comparing(Job::getTime).reversed());
        jobsList.stream()
            .limit(k)
            .forEach(System.out::println);
    }

    private static Job generateJobFromString(List<Job> jobsList, String job) {
        final Job newJob = extractAJob(job);
        if(!jobsList.contains(newJob)) {
            return newJob;
        }
        else {
            int indexOfJob = jobsList.indexOf(newJob);
            Job previousJob = jobsList.get(indexOfJob);
            Job.Builder resultingJobBuilder = new Job.Builder()
                .withJobId(previousJob.getJobId())
                .withName(previousJob.getName())
                .withDuration(previousJob.getTime());
            if(previousJob.getTime() == 0 || previousJob.getTime() < newJob.getTime()) {
                resultingJobBuilder = resultingJobBuilder
                    .withDuration(newJob.getTime());
            }
            if(previousJob.getName().equals("")) {
                resultingJobBuilder = resultingJobBuilder.withName(newJob.getName());
            }
            jobsList.remove(indexOfJob);
            return resultingJobBuilder.build();
        }
    }

    private static Job extractAJob(String job) {

        String[] line = job.split(" ");
        int jobId;
        if(line[0].equals("Starting")) {
            jobId = Integer.parseInt(extractMeaningfulInformation(line[2]));
            String name = extractMeaningfulInformation(line[1]);
            return new Job.Builder()
                .withJobId(jobId)
                .withName(name)
                .build();
        }
        else {
            jobId = Integer.parseInt(extractMeaningfulInformation(line[1]));
            int time = Integer.parseInt(extractMeaningfulInformation(line[2]));
            return new Job.Builder()
                .withJobId(jobId)
                .withDuration(time)
                .build();
        }

    }

    private static String extractMeaningfulInformation(String lineSegment) {
        return lineSegment.split("=")[1];
    }


    public static void main(String[] args) {
        String jobs[] = {
            "Starting name=grep_logs job_id=1234",
            "Starting name=app_logs job_id=4321",
            "Ending job_id=1234 time=300",
            "Starting name=server_logs job_id=7890",
            "Ending job_id=4321 time=200",
            "Starting name=grep_logs job_id=1234",
            "Ending job_id=1234 time=100",
            "Ending job_id=7890 time=500"
        };

        extractTopDurationJobs(jobs, 2);
    }
}



