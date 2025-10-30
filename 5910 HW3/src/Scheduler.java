import java.util.Scanner;
public class Scheduler {
    public static void projectGroup1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter meeting day (Mon, Tue, Wed, Thu, Fri, Sat, Sun)");
        String day = scan.next();
        if (!day.equals("Mon") && !day.equals("Tue") && !day.equals("Wed")
                && !day.equals("Thu") && !day.equals("Fri")
                && !day.equals("Sat") && !day.equals("Sun")) {
            System.out.println("Invalid day!");
            return;
        }

        System.out.println("Enter meeting start time (hours only, 00 to 23)");
        double startHour = scan.nextDouble();
        if (startHour < 0 || startHour > 23) {
            System.out.println("Invalid hour!");
            return;
        }

        System.out.println("Enter meeting duration (in hours, >= 30 minutes)");
        double duration = scan.nextDouble();
        if (duration < 0.5) {
            System.out.println("Invalid duration!");
            return;
        }

        double endHour = startHour + duration;
        int absentees = 0;

        if (startHour < 9 || endHour > 18) {
            System.out.println("Beyond working hours.");
            return;
        }

        if ((day.equals("Mon") || day.equals("Wed")) &&
                timeOverlap(startHour, endHour, 15.5, 17.0)) {
            System.out.println("Marshall cannot attend this meeting, as it would conflict with CIT 5910.");
            System.out.println("Hank cannot attend this meeting, as it would conflict with CIT 5910.");
            absentees += 2;
        }

        if ((day.equals("Tue") || day.equals("Thu")) &&
                timeOverlap(startHour, endHour, 17.25, 18.75)) {
            System.out.println("Marshall cannot attend this meeting, as it would conflict with CIT 5920.");
            System.out.println("Hank cannot attend this meeting, as it would conflict with CIT 5920.");
            absentees += 2;
        }

        if ((day.equals("Tue") || day.equals("Thu")) &&
                timeOverlap(startHour, endHour, 12.0, 13.5)) {
            System.out.println("Marshall cannot attend this meeting, as it would conflict with CIT 5930.");
            System.out.println("Hank cannot attend this meeting, as it would conflict with CIT 5930.");
            absentees += 2;
        }

        if (day.equals("Sat") && timeOverlap(startHour, endHour, 13.0, 16.0)) {
            System.out.println("Marshall cannot attend this meeting, as it would conflict with his tennis practice.");
            absentees++;
        }

        if (absentees == 2) {
            System.out.println("Nobody can attend this meeting!");
        } else if (absentees != 0) {
            System.out.println("This meeting cannot be scheduled, there would be " + absentees + " attendee(s) absent.");
        } else {
            System.out.println("This meeting can be scheduled. It will be on: " + day + ", from " + startHour + " to " + endHour);
        }
    }

    public static void projectGroup2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter meeting day (Mon, Tue, Wed, Thu, Fri, Sat, Sun)");
        String day = scan.next();
        if (!day.equals("Mon") && !day.equals("Tue") && !day.equals("Wed")
                && !day.equals("Thu") && !day.equals("Fri")
                && !day.equals("Sat") && !day.equals("Sun")) {
            System.out.println("Invalid day!");
            return;
        }
        if (day.equals("Fri")) {
            System.out.println("Chase cannot play board games, as all three agree to not play board games on Fridays.");
            System.out.println("Janine cannot play board games, as all three agree to not play board games on Fridays.");
            System.out.println("Emilia cannot play board games, as all three agree to not play board games on Fridays.");
            System.out.println("Nobody can attend this meeting!");
            return;
        }

        System.out.println("Enter meeting start time (hours only, 00 to 23)");
        double startHour = scan.nextDouble();
        if (startHour < 0 || startHour > 23) {
            System.out.println("Invalid hour!");
            return;
        }

        System.out.println("Enter meeting duration (in hours, >= 30 minutes)");
        double duration = scan.nextDouble();
        if (duration < 0.5) {
            System.out.println("Invalid duration!");
            return;
        }

        double endHour = startHour + duration;
        int absentees = 0;

        if (startHour < 9 || endHour > 18) {
            System.out.println("Beyond working hours.");
            return;
        }


        if ((day.equals("Mon") || day.equals("Wed")) &&
                timeOverlap(startHour, endHour, 10.25, 11.75)) {
            System.out.println("Chase cannot attend this meeting, as it would conflict with Math class.");
            absentees++;
        }

        if (day.equals("Mon") && timeOverlap(startHour, endHour, 13.75, 15.25)) {
            System.out.println("Chase cannot attend this meeting, as it would conflict with Design class.");
            absentees++;
        }


        if (day.equals("Tue") || day.equals("Thu")) {
            System.out.println("Janine cannot attend this meeting,as it would conflict with class schedule.");
            absentees++;
        }

        if ((day.equals("Sat") || day.equals("Sun")) &&
                timeOverlap(startHour, endHour, 8.0, 13.0)) {
            System.out.println("Janine cannot attend this meeting, as it would conflict with band practice.");
            absentees++;
        }

        if (day.equals("Mon") || day.equals("Wed")) {
            System.out.println("Emilia cannot attend this meeting, as it would conflict with class schedule.");
            absentees++;
        }
        // Weekend duration restriction (must be at most 2 hours)
        if ((day.equals("Sat") || day.equals("Sun")) && duration > 2.0) {
            System.out.println("Emilia cannot attend this meeting, as weekend events must be at most 2 hours long.");
            absentees++;
        }

        if (absentees == 3) {
            System.out.println("Nobody can attend this meeting!");
        } else if (absentees != 0) {
            System.out.println("This meeting cannot be scheduled, there would be " + absentees + " attendee(s) absent.");
        } else {
            System.out.println("This meeting can be scheduled. It will be on: " + day + ", from " + startHour + " to " + endHour);
        }
    }

    public static boolean timeOverlap(double meetingStart, double meetingEnd,
                                       double eventStart, double eventEnd) {
        if (meetingEnd <= eventStart || meetingStart >= eventEnd) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Project to test:");
        int project = scanner.nextInt();

        if (project == 1) {
            projectGroup1();
        } else if (project == 2) {
            projectGroup2();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}


