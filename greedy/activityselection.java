package greedy;
import java.util.*;
public class activityselection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        //sorting based on end time
        int[][] activities = new int[start.length][3];
        int n = start.length;
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
            activities[i][2] = i;
        }
        //lambda function to sort based on end time
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
        int maxActivities = 1;
        int lastEndTime = activities[0][1];
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastEndTime) {
                maxActivities++;
                lastEndTime = activities[i][1];
            }
        }
        System.out.println("Maximum number of activities: " + maxActivities);
    }
}
