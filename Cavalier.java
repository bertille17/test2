import java.util.Random;

/**
 * Le cavalier se déplace en forme de L et aléatoirement
 *
 * @author (Bertille)
 * @version (2023-11-02)
 */
public class Cavalier extends Robot
{
    public int position_x;
    public int position_y;
    public int direction;
    private Random random;
    
    /**
     * Constructeur d'objets de classe TheCavalier
     */
    public Cavalier(String name, World world)
    {
        super(name);
        colour = Colour.BLUE;
        world.newRobotIn(this);
     }
     
    /**
     * Constructeur d'objets de classe TheCavalier
     */
   public Cavalier(String name, int xposition, int yposition, Colour newColor, World world) {
    super(name, xposition, yposition, newColor, world);
    world.newRobotIn(this);
    }
    
   public void move (){
     Random random = new Random();
        int choix = random.nextInt(8) + 1; 
        int newX = xPosition;
        int newY = yPosition;
        
        switch (choix) {
            case 1:
                newY += 2;
                newX ++;
                break;
            case 2:
                newY += 2;
                newX --;
                break;
            case 3:
                newX += 2;
                newY ++;
                break;
            case 4:
                newX += 2;
                newY --;
                break;
            case 5:
                newY -= 2;
                newX ++;
                break;
            case 6:
                newY -= 2;
                newX --;
                break;
            case 7:
                newX -= 2;
                newY ++;
                break;
            case 8:
                newX -= 2;
                newY --;
                break;
            default:
                break;
   }
   // Vérifier les limites du canva pour pas que le robot sorte du canva
        if (newX < 0 ) {
            newX = 11;
        }
        if (newX > 11 ) {
            newX = 0;
        }
        if (newY < 0 ){
            newY = 11;
        }
        if (newY > 11){
            newY = 0;
        }
        
        if (getWorld().canMove(this, newX, newY)) {
        xPosition = newX;
        yPosition = newY;
        System.out.println(name +" est maintenant en position x = " + xPosition + ", y = " + yPosition);
        draw();
        }
        else{ move();}
}
}
