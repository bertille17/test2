import java.util.ArrayList;

/**
 * Décrivez votre classe World ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList;
    import java.io.*;
    import java.lang.*;
    import java.util.Random;
    /**
     * Décrivez votre classe World ici.
     * G03
     * @version 26/10/2023
     */
    public class World
    {
        private ArrayList<Robot> live;
        private int maxRobots; //The number max of robots

        
        public World() {
            live = new ArrayList<Robot>();
        }
        
        public int getNumberRobots(){
            maxRobots= live.size();
            return maxRobots;
    
        }
        public void newRobotIn(Robot robot){
            boolean check=true;
            for(Robot r : live){
            if(r==robot){check = false;}
            }
            if(check){
                live.add(robot);
                robot.setCanvas();
                robot.setWorld(this);
                robot.draw();
            }
        }
        
        /**
         *
         * @retourne la liste des robots créé dans le monde
         */
        public ArrayList<Robot> getRobotList ()
            {
            //Returns the list of robots
            return this.live;
            }

     
        public void moveAllRobot (){
        for (Robot robot : live) {
            robot.move(); // voir comment faire / mettre dans l'ordre
            }
        }
        
            public void avoidCollisions(int X, int Y) {
            for (Robot robot1 : live) {
                if (samePlace(robot1, X, Y)) {
                    robot1.move();
                }
            }
        }
        
    
        /**
         * Booléen qui test si le robot à partir de la liste des robots va entrer en collision alors renvoie true
         */
            public boolean samePlace(Robot robot, int X, int Y) {
            // boucle qui recherche les robots de la liste
            for (Robot otherRobot : live) {
                // si un ou des robots de la liste on la même future position alors collision est à true
                if (otherRobot != robot && otherRobot.xPosition == X && otherRobot.yPosition == Y) {
                    return true;
                }
            }
            return false;
        }
        /**
         * Booléen qui retourne true si les nouveaux mouvements du robot sont hors du canvas
         */
        public boolean isOutOfCanvas(int X, int Y) {
            return X < 0 || Y < 0 || X > 11 || Y > 11;  
            // return true ici n'est pas nécessaire car faut vérifier que si la condition est vraie avec les coordonnées
            // mais renvoie en soit true
        }
         /**
         * Booléen qui test si le robot peut bouger en fonction des critères (outofcanvas et collision)
         */
        public boolean canMove(Robot robot, int X, int Y) {
            return !isOutOfCanvas(X, Y) && !samePlace(robot, X, Y);
        }

        
}


