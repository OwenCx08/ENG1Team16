public class Character extends GameObject{
    College college;
    public Character(Board Board, String name, College College, int[] pos, int points, int plunder){
        super(Board, name, pos, points, plunder);
        this.college = College;
    }

    public void Move(int x, int y){
        Boolean collide = this.CheckCollision(x,y);
        if(collide==false){
            this.pos.x+=x;
            if(this.pos.x>this.Board.Get("limx") || this.pos.x<this.Board.Get("minx")){
					this.pos.x-=x;
            }
            this.pos.y+=y;
            if(this.pos.y>this.Board.Get("limy") || this.pos.y<this.Board.Get("miny")){
                this.pos.y-=y;
            }
        }
    }

    public void Move(int x, int y, Boolean set){
        if(set==false){
            this.Move(x,y);
        }else{
            int lastx = this.pos.x;
            this.pos.x = x;
            if(this.pos.x>this.Board.Get("limx") || this.pos.x<this.Board.Get("minx")){
				this.pos.x = lastx;
            }

            int lasty = this.pos.y;
            this.pos.y = y;
            if(this.pos.y>this.Board.Get("limy") || this.pos.y<this.Board.Get("miny")){
				this.pos.y = lasty;
            }
        }
    }

    public Boolean CheckCollision(int x, int y){
        //Implement at later date
        return(false);
    }
}