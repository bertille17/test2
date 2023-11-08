import java.util.Random;
/**
 * Décrivez votre classe Robot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class Robot
{
    public String name;
    public Colour colour;
    public int xPosition;
    public int yPosition;
    private int direction;
    public static int MIN_NAME_LENGTH=3;
    public static int numberOfUnnamedRobots=0 ;
    private World world;
    public CanvasRobot canvas;
    
        public Robot(String name){
        setName(name);
        this.xPosition=5;  // mettre une position de base différente pour chaque robot différent
        this.yPosition=5;
        }

    public Robot(String name, int X, int Y, Colour newColor, World w){
        this.world=w;
        setName(name);
        this.colour= newColor;
         if (w.getNumberRobots()<12)
        {
            SetPosition(X,Y);
        }       
        }
    
    public void setWorld(World w){
        world=w;
    }
    
    public World getWorld (){
        return world;
    }
    
    public String getName(){
        return name;
    }
    
    public String getColour(){
        return colour.toString();
    }
    
    public void setColour(Colour colour){
            this.colour = colour;
    }   

    public void setName (String name){
        if (name != null){
            String trimmedName = name.trim();
            if (trimmedName.length() >= MIN_NAME_LENGTH) {
                this.name = trimmedName;
            }
            if (trimmedName.length() >= MIN_NAME_LENGTH) {
                this.name = trimmedName;
                return;
            }
            numberOfUnnamedRobots++;
            this.name = "iRobot" + numberOfUnnamedRobots;
        }
    }
    
    public void setYPosition(int Y){
        this.yPosition = Y;
    }
    
    public void setXPosition(int X){
        this.xPosition = X;
        }
    public void Setdirection(int d){
        this.direction = d;
    }
    public void SetPosition(int X, int Y){
        this.xPosition = X;
        this.yPosition = Y;
    }
    public String getPosition(){
        return "x : "+ xPosition + "; y : "+yPosition;
    }
    
    public int getX() {
        return xPosition;       
    }
    public int getY() {
        return yPosition;
    
    }
    public int getd() {
        return direction;
    
    }
    public abstract void move ();
    
    public void draw(){
        canvas.drawRobot(xPosition,yPosition);
    }
    
    public void setCanvas() {
        if (colour != null) {
            canvas = new CanvasRobot(colour.toString());
        } else {
            canvas = new CanvasRobot("DEFAULT_COLOR");
        }
    }
    
    public CanvasRobot getCanvas() {
        return canvas;
    }
}