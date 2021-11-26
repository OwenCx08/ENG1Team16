public class Board{
    Pos startPos;
    int width;
    int height;
    
    public Board(int[] zeroZero, int width, int height){
        this.startPos.x = zeroZero[0];
        this.startPos.y = zeroZero[1];
        this.width = width;
        this.height = height;
    }

    public int Get(String request){
        if(request=="limx"){
            return(this.width);
        }else if(request=="limy"){
            return(this.height);
        }else if(request=="minx"){
            return(this.startPos.x);
        }else if(request=="miny"){
            return(this.startPos.y);
        }else{
            return(0);
        }
    }
}