public class Converter {

    public double stepsToKm(int steps) {
        double stepsToKmCoeff = 75E-5;
        return (double) steps * stepsToKmCoeff;
    }

    public double StepsToKCalories(int steps) {
        double stepsToKCalCoeff = 0.05;
        return steps * stepsToKCalCoeff;
    }
}
