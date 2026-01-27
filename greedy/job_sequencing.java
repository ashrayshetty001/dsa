package greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class job_sequencing {
    public static class jobs{
        int id;
        int deadline;
        int profit;

        public jobs(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String args[]){
        int jobsInfo[][]={{4,20},{1,10},{2,40},{3,30}};
        ArrayList<jobs> jobList=new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobList.add(new jobs(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        Collections.sort(jobList,(a,b)->b.profit-a.profit);
        ArrayList<Integer> sequence=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobList.size();i++){
            jobs currJob=jobList.get(i);
            if(currJob.deadline>time){
                sequence.add(currJob.id);
                time++;
            }
        }
        System.out.println("max jobs done: "+sequence.size());
        for(int i=0;i<sequence.size();i++){
            System.out.print(sequence.get(i)+" ");
        }
        System.out.println();
    }
}
