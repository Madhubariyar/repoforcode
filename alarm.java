import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input alarm time
        System.out.print("Set alarm hour (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Set alarm minute (0-59): ");
        int minute = scanner.nextInt();

        LocalTime alarmTime = LocalTime.of(hour, minute);
        System.out.println("Alarm set for: " + alarmTime);

        // Continuous loop to check time
        while (true) {
            LocalTime now = LocalTime.now();

            // Print current time (optional)
            System.out.print("\rCurrent time: " + now.withNano(0));

            // Check if current time matches alarm time
            if (now.getHour() == alarmTime.getHour() &&
                now.getMinute() == alarmTime.getMinute()) {

                System.out.println("\n⏰ Alarm ringing!");

                // Beep sound (works on most systems)
                for (int i = 0; i < 5; i++) {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break; // stop after alarm
            }

            // Wait for 1 second before checking again
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
