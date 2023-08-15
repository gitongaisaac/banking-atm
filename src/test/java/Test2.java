import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(time.format(timestamp));
        System.out.println(date.format(timestamp));
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
