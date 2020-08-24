package yaksa.member.main.main.calendar;


import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;

public class CalendarCell extends ToggleButton {

	  private LocalDate date;
	  
	  CalendarCell(int id, LocalDate date, String text)
	  {
	    setPrefSize(40.0D, 40.0D);
	    date = date;
	    setId(String.valueOf(id));
	    setText(text);
	  }
	  
	  CalendarCell(String id, LocalDate date, String text)
	  {
	    setPrefSize(50.0D, 50.0D);
	    setAlignment(Pos.CENTER);
	    getStyleClass().add("calendar-cell");
	    date = date;
	    setId(String.valueOf(id));
	    setText(text);
	  }
}
