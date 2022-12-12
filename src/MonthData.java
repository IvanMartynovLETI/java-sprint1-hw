import java.util.Arrays;

public class MonthData {
    int[] dataPerMonth;

    public MonthData() {

        dataPerMonth = new int[30];
        Arrays.fill(dataPerMonth, 0);
    }

    public void setDataPerDay(int dayNumber, int steps) {
        dataPerMonth[dayNumber - 1] = steps;
    }

    public int getDataPerDay(int dayNumber) {
        return dataPerMonth[dayNumber];
    }
}
