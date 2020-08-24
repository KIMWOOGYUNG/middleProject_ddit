package yaksa.member.calendar.join;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class CalendarSkeleton {
	 private LocalDate date;
	  private int year;
	  private int monthValue;
	  private Month month;
	  private Locale locale;
	  private int columns = 7;
	  private int rows = 7;
	  
	  CalendarSkeleton()
	  {
	    this.date = LocalDate.now();
	    this.year = this.date.getYear();
	    this.monthValue = this.date.getMonthValue();
	    this.date = LocalDate.of(this.year, this.monthValue, 1);
	  }
	  
	  CalendarSkeleton(int monthValue)
	  {
	    this.date = LocalDate.now();
	    this.year = this.date.getYear();
	    monthValue = monthValue;
	    this.date = LocalDate.of(this.year, monthValue, 1);
	  }
	  
	  CalendarSkeleton(int year, int monthValue)
	  {
	    this.date = LocalDate.now();
	    year = year;
	    monthValue = monthValue;
	    this.date = LocalDate.of(year, monthValue, 1);
	  }
	  
	  String[][] createSkeleton()
	  {
	    String[][] days = new String[this.rows][this.columns];
	    
	    DateFormatSymbols symbols = new DateFormatSymbols();
	    String[] dayNames = symbols.getShortWeekdays();
	    for (int k = 0; k < this.columns; k++)
	    {
	      days[0][k] = dayNames[(k + 1)];
	      System.out.printf(" %s", new Object[] { days[0][k] });
	    }
	    System.out.println();
	   
	    
	    this.date = LocalDate.of(this.year, this.monthValue, 1);
	    TemporalField fieldUS = WeekFields.of(Locale.KOREA).dayOfWeek();
	    int firstDayCalendar = this.date.with(fieldUS, 1L).getDayOfMonth() - 1;
	    if (this.date.getMonthValue() == 1) {
	      this.date = LocalDate.of(this.date.minusYears(1L).getYear(), 4, firstDayCalendar);
	    } else {
	      this.date = LocalDate.of(this.date.getYear(), this.date.minusMonths(1L).getMonth(), firstDayCalendar);
	    }
	    for (int i = 1; i < this.rows; i++) {
	      for (int j = 0; j < this.columns; j++)
	      {
	        if ((this.date.getDayOfYear() == 365) || (this.date.getDayOfYear() == 366)) {
	          this.date = LocalDate.of(this.date
	            .plusYears(1L).getYear(), this.date
	            .plusMonths(1L).getMonth(), this.date
	            .plusDays(1L).getDayOfMonth());
	        } else if (this.date.getDayOfMonth() == this.date.getMonth().maxLength()) {
	          this.date = LocalDate.of(this.date
	            .getYear(), this.date
	            .plusMonths(1L).getMonth(), this.date
	            .plusDays(1L).getDayOfMonth());
	        } else {
	          this.date = LocalDate.of(this.date
	            .getYear(), this.date
	            .getMonth(), this.date
	            .plusDays(1L).getDayOfMonth());
	        }
	        days[i][j] = this.date.toString();
	      }
	    }
	    return days;
	  }
	  
	  int getRows()
	  {
	    return this.rows;
	  }
	  
	  int getColumns()
	  {
	    return this.columns;
	  }
	  
	  void setYear(int year)
	  {
	    this.year = year;
	  }
	  
	  int getYear()
	  {
	    return this.year;
	  }
	  
	  int getMonthValue()
	  {
	    return this.monthValue;
	  }
	  
	  void setMonthValue(int monthValue)
	  {
	    this.monthValue = monthValue;
	  }
	  
	  public static void main(String[] args)
	  {
	    new CalendarSkeleton().createSkeleton();
	  }

}
