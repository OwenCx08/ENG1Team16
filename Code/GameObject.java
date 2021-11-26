public class GameObject{
    Board Board;
    String name;
    Pos pos;
    int points;
    int plunder;
    
    public GameObject(Board Board, String name, int[] pos, int points, int plunder){
        this.Board = Board;
        this.name = name;
        this.pos.x = pos[0];
        this.pos.y = pos[1];
        this.points = points;
        this.plunder = plunder;
    }

	public int[] GetPos(Boolean x, Boolean y){
        if(x && y){
            int[] value = {this.pos.x,this.pos.y};
            return(value);
        }else if(x){
            int[] value = {this.pos.x,0};
            return(value);
        }else if(y){
            int[] value = {0,this.pos.y};
            return(value);
        }else{
            int[] value = {0,0};
            return(value);
        }
        //return(value);//Java Won't complile code with this format
    }

    public int[] GetPos(){
        int[] value = {this.pos.x,this.pos.y};
        return(value);
    }

    public int GetX(){
        return(this.pos.x);
    }

    public int GetY(){
        return(this.pos.y);
    }
    public int[] GetPlunder(Boolean all){
        int oldPlunder = this.plunder;
        this.plunder = 0;
        int[] value = {oldPlunder,this.plunder};
        return(value);

    }
    public int[] GetPlunder(int loss){
        this.plunder-=loss;
        if(this.plunder<0){
            this.plunder+=loss;
            int[] value = {0,this.plunder};
            return(value);
        }else{
            int[] value = {loss,this.plunder};
            return(value);
        }
    }
    public int GetPlunder(){
        return(this.plunder);
    }
}
