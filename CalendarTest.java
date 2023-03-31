
/*
  Calendar class contains methods calculating information about a calendar.
*/
class Calendar {
  int[] num_days_in_month;

  Calendar() {
    /* Jan: num_days_in_month[1] = 31 */
    num_days_in_month = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  }

  /* Returns true if year is a leap year and false otherwise. */
  boolean isLeapYear(int year) {
    return false;
  }

  /*
   * Returns the number of leap years between year1 and year2, inclusive.
   * Precondition: 0 <= year1 <= year2
   */
  int numberOfLeapYears(int year1, int year2) {
    return 0;
  }

  /*
   * Returns the value representing the day of the week for Jan 1 of the year,
   * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
   */
  int firstDayOfYear(int year) {
    if (year == 2021)
      return 5;
    if (year == 2020)
      return 3;
    if (year == 2000)
      return 6;
    return 0;
  }

  /*
   * Returns n, where month, day, and year specify the nth day of the year.
   * Returns 1 for Jan 1 (month = 1, day = 1).
   */
  int dayOfYear(int month, int day, int year) {
    return 0;
  }

  /*
   * Returns the day of the week for the given date (month, day, year), where 0
   * denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
   */
  int dayOfWeek(int month, int day, int year) {
    return 0;
  }
}

public class CalendarTest {
  public static void main(String[] args) {
    Calendar c = new Calendar();
    int[] y = { 2021, 2020, 2019, 2011, 2000, 1998, 1996, 1900, 2022 };
    boolean[] leap_year = { false, true, false, false, true, false, true, false, false };
    for (int k = 0; k < 8; k++) {
      if (c.isLeapYear(y[k]) != leap_year[k]) {
        System.out.println("ERROR: k=" + k + " year=" + y[k] + " c.isLeapYear(y[k])=" + c.isLeapYear(y[k])
            + " leap_year[k]=" + leap_year[k]);
      }
    }

    if (c.numberOfLeapYears(1900, 2021) != 30) {
      System.out.println("c.numberOfLeapYears(1900, 2021) = " + c.numberOfLeapYears(1900, 2021) + "  correct: 30");
    }

    int n = c.dayOfYear(3, 20, 2021);
    if (n != 79) {
      System.out.println("ERROR: c.dayOfYear(3, 20, 2021) = " + n + " != 79");
    }

    n = c.dayOfYear(12, 31, 2020);
    if (n != 366) {
      System.out.println("ERROR: c.dayOfYear(12, 31, 2020) = " + n + " != 366");
    }

    n = c.dayOfYear(12, 31, 2000);
    if (n != 366) {
      System.out.println("ERROR: c.dayOfYear(12, 31, 2020) = " + n + " != 366");
    }

    String[] day_of_week = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    int d = c.dayOfWeek(3, 20, 2021);
    if (d != 6) {
      System.out
          .println("ERROR: c.dayOfWeek(3, 20, 2021) = " + c.dayOfWeek(3, 20, 2021) + "  correct: 6 " + day_of_week[6]);
    }

    d = c.dayOfWeek(12, 31, 2020);
    if (d != 4) {
      System.out.println(
          "ERROR: c.dayOfWeek(12, 31, 2020) = " + c.dayOfWeek(12, 31, 2020) + "  correct: 4 " + day_of_week[4]);
    }

    d = c.dayOfWeek(12, 31, 2000);
    if (d != 0) {
      System.out.println(
          "ERROR: c.dayOfWeek(12, 31, 2000) = " + c.dayOfWeek(12, 31, 2000) + "  correct: 0 " + day_of_week[0]);
    }
  }
}