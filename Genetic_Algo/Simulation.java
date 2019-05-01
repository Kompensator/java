import java.util.Random;
import java.lang.System;

public class Simulation {
    public int[] initialGrid = new int[225];
    public int[] currentGrid = new int[225];
    public int initialPos;
    public int currentPos;
    public double score;
    public int situation;
    Random random = new Random();

    public Simulation() {
        for (int i = 0; i < 225; i ++) {
            this.initialGrid[i] = random.nextInt(2);
        }
        System.arraycopy(this.initialGrid, 0, this.currentGrid, 0, 225);
        this.initialPos = random.nextInt(225);
        this.currentPos = this.initialPos;
        this.score = 0;
        this.situation = 0;
    }

    public void detection() {
        this.situation = 0;
        int x = this.currentPos % 15;
        int y = this.currentPos/15;

        int northPos = this.currentPos + 15;
        int southPos = this.currentPos - 15;
        int eastPos = this.currentPos + 1;
        int westPos = this.currentPos - 1;

        if ((y + 1) > 14) {;}
        else if (currentGrid[northPos] == 0) {
            situation += 81;
        }
        else if (currentGrid[northPos] == 1) {
            situation += 162;
        }

        if ((y - 1) < 0) {;}
        else if (currentGrid[southPos] == 0) {
            situation += 27;
        }
        else if (currentGrid[southPos] == 1) {
            situation += 54;
        }

        if ((x + 1) > 14) {;}
        else if (currentGrid[eastPos] == 0) {
            situation += 9;
        }
        else if (currentGrid[eastPos] == 1) {
            situation += 18;
        }

        if ((x - 1) < 0) {;}
        else if (currentGrid[westPos] == 0) {
            situation += 3;
        }
        else if (currentGrid[westPos] == 1) {
            situation += 6;
        }

        if (currentGrid[currentPos] == 0) {
            situation += 1;
        }
        else if (currentGrid[currentPos] == 1) {
            situation += 2;
        }
    }

    
    public void move(int[] chromosome) {
        int decision = chromosome[situation];
        int x = this.currentPos % 15;
        int y = this.currentPos/15;

        if (decision == 6) {
            decision = random.nextInt(6);
        }

        if (decision == 0) {
            if (y + 1 <= 14) {
                y += 1;
            }
            else {
                this.score -= 5;
            }
        }
        else if (decision == 1) {
            if (y - 1 >= 0) {
                y -= 1;
            }
            else {
                this.score -= 5;
            }
        }
        else if (decision == 2) {
            if (x + 1 <= 14) {
                x += 1;
            }
            else {
                score -= 5;
            }
        }
        else if (decision == 3) {
            if (x - 1 >= 0) {
                x -= 1;
            }
            else {
                score -= 5;
            }
        }
        else if (decision == 5) {
            if (this.currentGrid[this.currentPos] == 1) {
                this.currentGrid[this.currentPos] = 0;
                this.score += 10;
            }
            else {
                this.score -= 1;
            }
        }
        else {
            ;
        }
        this.currentPos = y*15 + x;         
    }

    public double run(int[] chromosome) {
        for (int i = 0; i < 450; i ++) {
            this.detection();
            this.move(chromosome);
        }
        double adjustedScore = this.score*10/112.5;

        this.score = 0;
        System.arraycopy(this.initialGrid, 0, this.currentGrid, 0, 225);
        this.currentPos = this.initialPos;

        return adjustedScore;
    }

    public static void main(String[] argv) {
        Simulation sim = new Simulation();
        int[] grid = {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        sim.currentGrid = grid;
        sim.currentPos = 20;
        int[] chromosome = {0, 5, 5, 1, 6, 5, 3, 3, 5, 2, 2, 5, 0, 6, 5, 1, 3, 5, 2, 2, 5, 2, 2, 5, 2, 0, 5, 6, 4, 5, 3, 3, 5, 2, 3, 5, 2, 1, 5, 1, 3, 5, 3, 3, 5, 6, 2, 5, 2, 2, 5, 2, 3, 5, 1, 1, 5, 1, 1, 5, 4, 6, 5, 1, 1, 5, 1, 1, 5, 1, 3, 5, 2, 1, 5, 2, 1, 5, 4, 2, 5, 0, 0, 5, 2, 0, 5, 3, 3, 5, 0, 2, 5, 0, 2, 5, 3, 3, 5, 3, 2, 5, 2, 2, 5, 6, 2, 5, 1, 2, 5, 6, 0, 5, 3, 3, 5, 0, 2, 5, 3, 1, 5, 3, 3, 5, 3, 2, 5, 5, 2, 5, 6, 3, 5, 1, 6, 5, 1, 1, 5, 5, 1, 5, 1, 1, 5, 3, 1, 5, 1, 3, 5, 3, 2, 5, 1, 1, 5, 1, 2, 5, 1, 0, 5, 0, 0, 5, 0, 0, 5, 2, 0, 5, 6, 0, 5, 6, 0, 5, 3, 0, 5, 6, 0, 5, 0, 0, 5, 3, 0, 5, 2, 0, 5, 0, 0, 5, 0, 0, 5, 0, 0, 5, 6, 0, 5, 0, 0, 5, 2, 0, 5, 0, 0, 5, 0, 0, 5, 0, 0, 5, 3, 1, 5, 2, 0, 5, 0, 0, 5, 2, 0, 5, 2, 0, 5, 0, 0, 5, 1, 0, 5};
        System.out.println(sim.run(chromosome));
    }
}

