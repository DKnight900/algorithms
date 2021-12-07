import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SetTest {
    static class Job {
        private int jobId;
        private String name;
        private int time;

        @Override
        public int hashCode() {
            return jobId;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Job) obj).jobId == jobId;
        }

        public int getTime() {
            return time;
        }

        public int getJobId() {
            return jobId;
        }
    }

    public static void main(String[] args) {
        List<Job> set = new ArrayList<>();

        Job obj = new Job();
        obj.jobId = 1;
        obj.time = 10;

        Job obj2 = new Job();
        obj2.jobId = 2;
        obj2.time = 11;

        set.add(obj);
        set.add(obj2);

        System.out.println("set.contains(obj):" + set.contains(obj));
        Collections.sort(set, Comparator.comparingInt(Job::getJobId));
        Collections.reverse(set);
        System.out.println(set);

        System.out.println("set.contains(obj2):" + set.contains(obj2));
    }

}
