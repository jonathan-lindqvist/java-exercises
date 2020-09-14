package exercises;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;

/*
 * Program for Conway's game of life.
 * See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 * This is a graphical program using JavaFX to draw on the screen.
 * There's a bit of "drawing" code to make this happen (far below).
 * You don't need to implement (or understand) any of it.
 * NOTE: To run tests must uncomment in init() method, see comment
 *
 * Use smallest step development + functional decomposition!
 *
 * See:
 * - UseEnum
 * - BasicJavaFX (don't need to understand, just if you're curious)
 */
public class Ex5GameOfLife extends Application {

    final Random rand = new Random();

    // Enum type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    // This is the *only* accepted modifiable instance variable in program.
    Cell[][] world;

    @Override
    public void init() {
        // test();        // <--------------- Uncomment to test!
        int nLocations = 10000;
        double distribution = 0.15;   // % of locations holding a Cell
        // TODO Create and populate world
        int nPerSide = (int)sqrt((double)nLocations);
        world = new Cell[nPerSide][nPerSide];
        int nAliveCells = (int)Math.round(nLocations * distribution);
        for(int i = 0; i < nAliveCells; i++){
            int randRow = rand.nextInt(nPerSide);
            int randCol = rand.nextInt(nPerSide);

            while(world[randRow][randCol] == Cell.ALIVE){
                randRow = rand.nextInt(nPerSide);
                randCol = rand.nextInt(nPerSide);
            }

            world[randRow][randCol] = Cell.ALIVE;
        }
    }

    // Implement this method (using functional decomposition)
    // Every involved method should be tested, see below, method test()
    // This method is automatically called by a JavaFX timer (don't need to call it)
    void update() {
        // TODO Update (logically) the world
        // check all cells
        // when checking a cell, count how many alive around
        // update state
        //
        /*
        First make a copy so that we can update the state without changing the result for the current gen
        Then go trough the index and get how many neighbours a cell have
        Then update the state depending on nAlive and the rules
         */
        Cell[][]nextGenWorld = copyWorld();
        for(int rowIndex = 0; rowIndex < world.length;rowIndex++){
            for(int colIndex = 0; colIndex < world[rowIndex].length; colIndex++){
                int nAlive = checkAlive(rowIndex, colIndex);
                if(nAlive < 2){
                    nextGenWorld[rowIndex][colIndex] = Cell.DEAD;
                }if(nAlive > 3){
                    nextGenWorld[rowIndex][colIndex] = Cell.DEAD;
                }if(nAlive == 3){
                    nextGenWorld[rowIndex][colIndex] = Cell.ALIVE;
                }else{
                    nextGenWorld[rowIndex][colIndex] = world[rowIndex][colIndex] = Cell.DEAD;
                }
            }
        }
        world = nextGenWorld;
    }

    // -------- Write methods below this --------------
    // Need to copy it because this will be the next generation,
    // If we do not copy it will affect the result of the current generation
    Cell[][] copyWorld(){
        Cell[][] copy = new Cell[world.length][world[0].length];
        for(int y = 0; y < copy.length; y++){
            for(int x = 0; x < copy[y].length; x++){
                copy[y][x] = world[y][x];
            }
        }
        return copy;
    }

    // Loop through all the values in the matrix, then make sure that all our neighbours are inside the matrix
    // Then increase sum
    int checkAlive(int rowPos, int colPos){
        int sum = 0;
        for(int rowIndex = -1; rowIndex <=1; rowIndex++){
            for(int colIndex = -1;  colIndex <= 1; colIndex++){
                if(rowIndex + rowPos < world.length && rowIndex + rowPos > -1){
                    if(colIndex + colPos < world[rowIndex+rowPos].length && colIndex + colPos > -1){
                        if(!(colIndex + colPos == colPos && rowIndex + rowPos == rowPos)) {
                            if(world[rowIndex+rowPos][colIndex+colPos] == Cell.ALIVE){
                                sum++;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }



    // ---------- Testing -----------------
    // Here you run your tests i.e. call your logic methods
    // to see that they really work
    void test() {
        // Hard coded test world
        Cell[][] testWorld = {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE},

        };
        int size = testWorld.length;

        // TODO tests!


        exit(0);
    }

    // -------- Below is JavaFX stuff, nothing to do --------------

    void render() {
        gc.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 3 * col + 50;
                int y = 3 * row + 50;
                renderCell(x, y, world[row][col]);
            }
        }
    }

    void renderCell(int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.WHITE);
        }
        gc.fillOval(x, y, 3, 3);
    }

    final int width = 400;   // Size of window
    final int height = 400;
    GraphicsContext gc;

    // Must have public before more later.
    @Override
    public void start(Stage primaryStage) throws Exception {

        // JavaFX stuff
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {

            long timeLastUpdate;

            // This method called by FX at a certain rate, parameter is the current time
            public void handle(long now) {
                if (now - timeLastUpdate > 300_000_000) {
                    update();
                    render();
                    timeLastUpdate = now;
                }
            }
        };
        // Create a scene and connect to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();
        timer.start();  // Start simulation
    }

    public static void main(String[] args) {
        launch(args);   // Launch JavaFX
    }
}