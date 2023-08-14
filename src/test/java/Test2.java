import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test2 {
    public void localDate() {
        LocalDate date = LocalDate.now();
        System.out.println("Local Date: " + date);
    }

    public void localTime() {
        LocalTime time = LocalTime.now();
        System.out.println("Local Time: " + time);
    }

    public void date() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Before formatting: " + date);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = date.format(dateTimeFormatter);
        System.out.println("After formatting: " + formattedDate);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        test2.localDate();
//        test2.localTime();
//
//        System.out.println();
//        System.out.println();

        test2.date();
    }

}
