public class StepTracker {
    int StepsGoal ;
    MonthData[ ] monthToData;
    public StepTracker ( ) {
        monthToData = new MonthData[ 12 ] ;
        for ( int i = 0 ; i < monthToData.length ; i ++ ) {
            monthToData[ i ] = new MonthData( ) ;
        }
    }
    public void setStepsGoal ( int goal ) {
        if ( goal < 0 )
            System.out.println ( "Целевое число шагов не должно быть отрицательным" ) ;
        else StepsGoal = goal ;
    }
    public void setStepsPerDay ( int monthNumber, int dayNumber, int StepsNumber ) {
        monthToData[ monthNumber ].setDataPerDay ( dayNumber, StepsNumber ) ;
    }

    public void printStepsPerMonth ( int month ) {
        for ( int i = 0 ; i < 30 ; i ++ ) {
            System.out.print ( i + 1 + " день: " + monthToData[month].getDataPerDay ( i ) ) ;
            if ( i != 29 )
                System.out.print( ", " ) ;
            else System.out.print( "\n" ) ;
        }
    }

    public int totalStepsPerMonth ( int month ) {
        int sum = 0 ;
        for ( int i = 0 ; i < 30 ; i ++ )
            sum += monthToData[ month ].getDataPerDay( i ) ;
        return sum ;
    }

    public int maxStepsPerMonth ( int month ) {
        int max = 0 ;
        for ( int i = 0 ; i < 30 ; i ++ )
            if ( monthToData[ month ].getDataPerDay( i ) > max )
                max = monthToData[ month ].getDataPerDay( i ) ;
        return max ;
    }

    public int averageNoOfSteps ( int month ) {
        return totalStepsPerMonth ( month ) / 30 ;
    }

    public double distancePerMonth ( int month ) {
        return new Converter( ).StepsToKm( totalStepsPerMonth ( month ) ) ;
    }

    public double KCalsBurned ( int month ) {
        return new Converter( ).StepsToKCalories( totalStepsPerMonth ( month ) ) ;
    }

    public int maxSeries ( int month ) {
        int maxSer = 0 , tempSer = 0 ;
        for ( int i = 0 ; i < 30 ; i ++ ) {
            if ( monthToData [ month ] . getDataPerDay ( i ) >= StepsGoal ) {
                tempSer ++ ;
                if ( tempSer > maxSer )
                    maxSer = tempSer ;
            } else tempSer = 0 ;
        }
        return maxSer ;
    }
}
