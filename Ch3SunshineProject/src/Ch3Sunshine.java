import java.text.DecimalFormat;
import java.util.Scanner;

public class Ch3Sunshine {
    //Global variables
    static Scanner inputDevice;
    static DecimalFormat dollarAmt;
    static DecimalFormat time;
    public static void main(String[] args) {
        init();
        double iTime = rentalTime();
        double iHours = calHours(iTime);
        double iAdMinutes = calAdMinutes(iTime);
        double iPrice = calPrice(iHours, iAdMinutes);
        output(iHours, iAdMinutes, iPrice);
    }
    private static double rentalTime() {
        try {
            System.out.println("Enter rental time in minutes: ");
            String iData = inputDevice.nextLine();
            double iMinutes = Double.parseDouble(iData);
            return iMinutes;
        } catch (Exception e) {
            System.out.println("Default minutes to 60.");
            return 60;
        }
    }
    private static double calHours(double iRentalTime) {
        double iRentalHours = (int) iRentalTime / 60 ;
        return iRentalHours;
    }
    private static double calAdMinutes(double iRentalTime) {
        double iRentalAdMinutes =  iRentalTime % 60;
        return iRentalAdMinutes;
    }
    private static double calPrice(double iRentalHours, double iRentalAdMinutes) {
        double cPrice = iRentalHours * 40 + iRentalAdMinutes;
        return cPrice;
    }
    private static void output(double Hours, double AdMinutes, double Price) {
         //print today's date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //prompt user to enter a date
        String strDate;
        strDate = getDateFromUser();
        System.out.println("Date as entered: " + strDate);


        //now format the entered date
        formatDate(strDate);

        System.out.println(CompanyMotto.getMotto());
        System.out.format("%-12s%-12s%-12s\n" , "Hours" , "Minutes" , "Price" );
        //System.out.print(time.format(Hours) + "\t\t\t");
        //System.out.print(time.format(AdMinutes) + "\t\t\t");
        //System.out.print(dollarAmt.format(Price) + "\n");
        System.out.format("%-12.0f%-12.0f$%-12.2f" , Hours , AdMinutes , Price);

    }
    private static String getDateFromUser() {
        String enteredDate;
            System.out.print("Enter a date (MM/DD/YYYY format): ");
            enteredDate = inputDevice.nextLine();
           
            return enteredDate;

    }
    private static void formatDate(String enteredDate) {
        String enteredPattern = "MM/dd/yyyy";
        String newPattern = "MMMM dd, yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(enteredPattern);
        try {
            Date d = sdf.parse(enteredDate);
            sdf.applyPattern(newPattern);
            String newDateString = sdf.format(d);
            System.out.println("Entered date formatted: " + newDateString);
        } catch (ParseException pe) {
            System.out.println("Invalid date entered. Default to current date.");
        }
    }
    private static void init() {
        inputDevice = new Scanner(System.in);
        //dollarAmt =  new DecimalFormat("$###,###.00");
        //time = new DecimalFormat("####");
    }
}
