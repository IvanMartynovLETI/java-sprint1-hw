public class StepTracker {
    int stepsGoal;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setStepsGoal(int goal) {
        if (goal < 0)
            System.out.println("Целевое число шагов не должно быть отрицательным");
        else stepsGoal = goal;
    }

    public void setStepsPerDay(int monthNumber, int dayNumber, int stepsNumber) {
        monthToData[monthNumber].setDataPerDay(dayNumber, stepsNumber);
    }

    public void printStepsPerMonth(int month) {
        for (int i = 0; i < 30; i++) {
            System.out.print(i + 1 + " день: " + monthToData[month].getDataPerDay(i));
            if (i != 29)
                System.out.print(", ");
            else System.out.print("\n");
        }
    }

    public int totalStepsPerMonth(int month) {
        int sum = 0;
        for (int i = 0; i < 30; i++)
            sum += monthToData[month].getDataPerDay(i);
        return sum;
    }

    public int maxStepsPerMonth(int month) {
        int max = 0;
        for (int i = 0; i < 30; i++)
            if (monthToData[month].getDataPerDay(i) > max)
                max = monthToData[month].getDataPerDay(i);
        return max;
    }

    public int averageNoOfSteps(int month) {
        return totalStepsPerMonth(month) / 30;
    }

    public double distancePerMonth(int month) {
        return new Converter().stepsToKm(totalStepsPerMonth(month));
    }

    public double KCalsBurned(int month) {
        return new Converter().stepsToKCalories(totalStepsPerMonth(month));
    }

    public int maxSeries(int month) {
        int maxSer = 0;
        int tempSer = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[month].getDataPerDay(i) >= stepsGoal) {
                tempSer++;
                if (tempSer > maxSer)
                    maxSer = tempSer;
            } else tempSer = 0;
        }
        return maxSer;
    }
}
