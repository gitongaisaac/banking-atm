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
//        System.out.println("Before formatting: " + date);

        DateTimeFormatter timeFormatted = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedTime = date.format(timeFormatted);
        String formattedDate = date.format(dateFormatted);

        System.out.println("After formatting: " + formattedDate);
        System.out.println("After formatting: " + formattedTime);
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
