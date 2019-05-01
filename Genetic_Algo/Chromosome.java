public class Chromosome {
    public int[] chromosome;
    public Simulation[] simulations = new Simulation[200]; 
    public double fitness;

    public Chromosome(int[] chromosome, Simulation[] simulations) {
        this.chromosome = chromosome;
        this.simulations = simulations;
    }

    public double runSims() {
        double totalScore = 0;
        for (int i = 0; i < simulations.length; i++) {
            totalScore += simulations[i].run(this.chromosome);
        }
        this.fitness = totalScore/simulations.length;

        return this.fitness;
    }
}