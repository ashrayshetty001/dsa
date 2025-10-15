package OOPs;
public class oop {
    
}
class Student{
    int name;
    String usn;
    int marks[]=new int[3];
    Student(Student S1){
        this.name=S1.name;
        this.usn=S1.usn;
        // this.marks=S1.marks;//shallow copy
        for(int i=0;i<marks.length;i++){
            this.marks[i]=S1.marks[i];//deep copy
        }

    }
}
interface chess{
    void moves();
}
class Queen implements chess {
    public void moves(){
        System.out.println("up,down,diagonal,sides");
    }
    
}