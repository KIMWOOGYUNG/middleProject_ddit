package yaksa.member.calendar.join;

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CalendarHeader extends Label {


	  private LocalDate date;
	  
	  CalendarHeader(int id, LocalDate date, String text)
	  {
	    setPrefSize(40.0D, 40.0D);
	    date = date;
	    setId(String.valueOf(id));
	    setText(text);
	  }
	  
	  CalendarHeader(String id, LocalDate date, String text)
	  {
	    setPrefSize(40.0D, 40.0D);
	    setAlignment(Pos.CENTER);
	    setStyle("-fx-background-color : red");
	    date = date;
	    setId(String.valueOf(id));
	    setText(text);
	  }
}
