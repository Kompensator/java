import java.util.Random;
import java.util.Arrays;


public class GA {
    static final int totGen = 1000;
    static final int numberOfSim = 200;
    static final int population = 100;
    static final int parentsPerGen = 10;
    static final int mutationRate = 2;
    static int[] start = {0, 5, 5, 1, 6, 5, 3, 3, 5, 2, 2, 5, 6, 6, 5, 1, 3, 5, 2, 2, 5, 6, 6, 5, 2, 0, 5, 6, 4, 5, 3, 3, 5, 2, 3, 5, 2, 1, 5, 1, 3, 5, 3, 3, 5, 6, 2, 5, 2, 2, 5, 2, 3, 5, 1, 0, 5, 1, 1, 5, 4, 6, 5, 1, 1, 5, 1, 1, 5, 1, 3, 5, 2, 3, 1, 2, 1, 5, 4, 2, 5, 1, 5, 1, 2, 0, 5, 3, 3, 5, 0, 2, 5, 0, 2, 5, 3, 3, 5, 3, 2, 5, 2, 2, 5, 6, 2, 5, 1, 3, 5, 6, 0, 5, 3, 3, 5, 5, 2, 5, 3, 1, 5, 1, 3, 5, 3, 2, 5, 5, 2, 5, 6, 3, 3, 1, 2, 0, 0, 1, 5, 5, 1, 5, 0, 1, 5, 3, 2, 5, 1, 3, 5, 3, 2, 5, 1, 2, 5, 1, 2, 5, 1, 2, 5, 0, 0, 5, 0, 0, 5, 2, 0, 5, 1, 0, 5, 6, 0, 5, 3, 0, 5, 6, 0, 2, 0, 6, 5, 3, 0, 3, 5, 0, 5, 0, 0, 3, 0, 0, 5, 0, 0, 0, 6, 0, 5, 3, 0, 5, 2, 0, 5, 0, 0, 0, 1, 0, 5, 0, 0, 1, 3, 1, 5, 5, 0, 5, 0, 0, 5, 2, 0, 5, 2, 0, 5, 0, 0, 5, 0, 0, 5};
    static Random random = new Random();

    static int[][] init_mutation(int[] parent, int n, int k) {
        /* mutates the parents chromosome n times
        returns k copies
        */ 
        int[][] newChromosomes = new int[k][243];
        int[] mod = new int[243];
        newChromosomes[0] = parent;
        int index;
        int value;
        for (int i = 1; i < k; i ++) {
            mod = new int[243];
            System.arraycopy(parent, 0, mod, 0, 243);
            for (int j = 0; j < n; j++) {
                index = random.nextInt(243);
                value = random.nextInt(7);
                mod[index] = value;
            }
            newChromosomes[i] = mod;
        }
        return newChromosomes;
    }

    static int[][] findParents(int[][] chromosomes, double[] currentFitness) {
        /* finds and returns the fittests parents in chromosomes
        according to currentFitness
        */
        int[][] parents = new int[parentsPerGen][243];
        double[] bestFitness = new double[parentsPerGen];
        double[] sortedFitness = new double[population];
        System.arraycopy(currentFitness, 0, sortedFitness, 0, population);
        Arrays.sort(sortedFitness);
        for (int i = population - 1; i > (population - parentsPerGen - 1); i--) {
            bestFitness[-i+population-1] = sortedFitness[i];
        }
        for (int i = 0; i < parentsPerGen; i++) {
            for (int j = 0; j < population; j++) {
                if (bestFitness[i] == currentFitness[j]) {
                    parents[i] = chromosomes[j];
                }
            }
        }
        return parents;
    }

    static int[][] copyParents(int[][] parents) {
        /* copy the each parents into the next generation so that 
        all the next gen are filled
        **/
        int copiesPerParent = population/parentsPerGen;
        int[][] copiedParents = new int[population][243];
        for (int i = 0; i < parentsPerGen; i++) {
            for (int j = 0;j < copiesPerParent; j++) {
                // copiedParents[i*parentsPerGen+j] = parents[i];      // needs to be deep copied
                System.arraycopy(parents[i], 0, copiedParents[i*parentsPerGen+j], 0, 243);
            }
        }
        return copiedParents;
    }


    static int[][] mutate(int[][] chromosomes) {
        /* randomly mutates each chromosome a certain amount of time (mutationRate)
        **/
        int index;
        int value;
        for (int i = 0;i < population; i++) {
            if (i%(population/parentsPerGen) != 0)
            {
                for (int j = 0;j < mutationRate; j++) {
                    index = random.nextInt(243);
                    value = random.nextInt(7);
                    chromosomes[i][index] = value;
                }
            }
        }
        return chromosomes;
    }

    public static void main(String[] argv) {
        int[][] currentGenePool = new int[population][243];
        double[] currentFitness = new double[population];
        int[][] nextGeneration = new int [population][243];
        int[][] parents = new int[parentsPerGen][243];
        

        currentGenePool[0] = start;
        currentGenePool = init_mutation(currentGenePool[0], mutationRate, population);

        Simulation[] simulations = new Simulation[numberOfSim];
        for (int i = 0; i < numberOfSim; i++) {
            simulations[i] = new Simulation();
        }

        Chromosome[] generation = new Chromosome[population];
        for (int i = 0; i < population; i++) {
            generation[i] = new Chromosome(currentGenePool[i], simulations);
        }

        int gen = 1;
        // main loop
        while (gen <= totGen) {
            System.out.println("Generation " + gen+"============================");
            for (int i = 0; i < population; i ++) {
                currentFitness[i] = generation[i].runSims();
                // System.out.println(currentFitness[i]);
            }
            Lib.printStats(currentFitness);

            parents = findParents(currentGenePool, currentFitness);
            nextGeneration = copyParents(parents);
            nextGeneration = mutate(nextGeneration);

            currentGenePool = Lib.twoDIntDeepcopy(nextGeneration);

            for (int i = 0; i < numberOfSim; i++) {
                simulations[i] = new Simulation();
            }
            for (int i = 0; i < population; i++) {
                generation[i] = new Chromosome(currentGenePool[i], simulations);
            }

            gen++;
        }
    }
}