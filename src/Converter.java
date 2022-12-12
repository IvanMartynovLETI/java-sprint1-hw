public class Converter {

    public  double StepsToKm ( int steps ) {
        double StepsToKmCoeff = 75E-5 ;
        return ( double ) steps * StepsToKmCoeff ;
    }

    public double StepsToKCalories ( int steps ) {
        double stepsToKCalories = 0.05 ;
        return steps * stepsToKCalories ;
    }
}
