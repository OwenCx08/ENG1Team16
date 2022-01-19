public class Entity{
    protected int ID;
    protected float width;
    protected float height;
    protected String spriteName;
    protected int health;
    protected int[] position;
    
    public Entity(int id, float width,float height, String spriteName, int health, int[] position){
        this.ID = id;
        this.width = width;
        this.height = height;
        this.spriteName = spriteName;
        this.health = health;
        this.position = position;
    }

    public Boolean detectCollision(){
        boolean collision = false;
        //Colision detection
        return(collision);
    }

    public void attack(int[] position){
        //attach method
        //  -damage anything at position
        
    }

    public int[] draw(){
        int[] data = {this.position[0],this.position[1],this.width,this.height};//May need image data
        return(data);
    }
}