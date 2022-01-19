public class PlayerShip extends Ship{
    public PlayerShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange){
            super(id, width, height, spriteName, health, position,range,moveRange);
    }

    public int[] mouseListener(){
        int[] data = {-1,-1};
        //Get mouse location
        //LIBGDX interface required
        return(data);
    }
}