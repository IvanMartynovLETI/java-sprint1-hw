import java.util.Scanner ;

public class Main {
    public static void main( String[ ] args ) {
        System.out.println( "Пришло время практики!" ) ;
        Scanner scanner = new Scanner( System.in ) ;
        printMenu( ) ;
        int userInput = scanner.nextInt( ) ;

        StepTracker stepTracker = new StepTracker( ) ;
        int monthNo, dayNo, stepsNum ;
        while ( userInput != 0 ) {
            if ( userInput == 1 ) {
                System.out.println( "Введите номер месяца (0-11), для которого требуется задать число шагов:" ) ;
                monthNo = scanner.nextInt( ) ;
                if ( ( monthNo < 0 ) || ( monthNo > 11 ) )
                    System.out.println( "Номер месяца задан неправильно" ) ;
                else {
                    System.out.println( "Введите номер дня (1-30), для которого требуется задать число шагов:" ) ;
                    dayNo = scanner.nextInt( ) ;
                    if ( ( dayNo < 1 ) || ( dayNo > 30 ) )
                        System.out.println( "Номер дня задан неправильно" ) ;
                    else {
                        System.out.println( "Введите количество шагов:" ) ;
                        stepsNum = scanner.nextInt( ) ;
                        if( stepsNum <= 0 )
                            System.out.println( "Количество шагов задано неправильно" ) ;
                        else stepTracker.setStepsPerDay ( monthNo, dayNo, stepsNum ) ;
                    }
                }

            } else if ( userInput == 2 ) {
                System.out.println( "Введите номер месяца (0-11), для которого требуется напечатать статистику:" ) ;
                monthNo = scanner.nextInt( ) ;
                if ( ( monthNo < 0 ) || ( monthNo > 11 ) )
                    System.out.println( "Номер месяца задан неправильно" ) ;
                else {
                    System.out.println( "Количество пройденных шагов по дням:" ) ;
                    stepTracker.printStepsPerMonth ( monthNo ) ;
                    System.out.println( "Количество пройденных шагов за месяц: " + stepTracker.totalStepsPerMonth( monthNo ) ) ;
                    System.out.println( "Максимальное пройденное количество шагов в месяце: " + stepTracker.maxStepsPerMonth( monthNo ) ) ;
                    System.out.println( "Среднее количество шагов за месяц: " + stepTracker.averageNoOfSteps( monthNo ) ) ;
                    System.out.println( "Пройденная дистанция (в км): " + stepTracker.distancePerMonth( monthNo ) ) ;
                    System.out.println( "Количество сожжённых килокалорий: " + stepTracker.KCalsBurned( monthNo ) ) ;
                    System.out.println( "Лучшая серия: " + stepTracker.maxSeries( monthNo ) ) ;
                }

            } else if ( userInput == 3 ) {
                System.out.println( "Введите целевое количество шагов: " ) ;
                stepTracker.setStepsGoal ( scanner.nextInt ( ) ) ;
            }  else {
                System.out.println( "Такой команды нет" ) ;
            }


            printMenu( ) ;
            userInput = scanner.nextInt( ) ;
        }
        System.out.println( "Программа завершена" ) ;
    }

    private static void printMenu( ) {
        System.out.println( "Выберите действие:" ) ;
        System.out.println( "1 - Ввести количество шагов за определённый день" ) ;
        System.out.println( "2 - Напечатать статистику за определённый месяц" ) ;
        System.out.println( "3 - Изменить цель по количеству шагов в день" ) ;
        System.out.println( "0 - Выйти из приложения" ) ;
    }
}