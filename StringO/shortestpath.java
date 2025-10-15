package StringO;

public class shortestpath {
    public static float shortpath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char di=path.charAt(i);
            //north
            if(di=='N'){
                y++;
            }
            //south
            else if(di=='S'){
                y--;
            }
            //East
            else if(di=='E'){
                x++;
            }
            //West
            else if(di=='W'){
                x--;
            }
        }
        float x2=x*x;
        float y2=y*y;
        return ((float)Math.sqrt(x2+y2));
    }
    public static void main(String[] args){
        String path="WNEENESENNN";
        System.out.println(shortpath(path));
    }
}
