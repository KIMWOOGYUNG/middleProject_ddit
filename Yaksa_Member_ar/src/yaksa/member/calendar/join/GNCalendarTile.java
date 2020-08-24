package yaksa.member.calendar.join;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class GNCalendarTile extends Region {
	
	private VBox base = new VBox();
	  
	  public GNCalendarTile()
	  {
	    this.base.getStyleClass().add("calendar-tile");
	    this.base.setAlignment(Pos.CENTER);
	    
	    Label title = new Label(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.KOREA) + ", " + LocalDate.now().getYear());
	    
	    Label footer = new Label(String.valueOf(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.KOREA)));
	    
	    footer.setMinHeight(40.0D);
	    title.setMinHeight(40.0D);
	    
	    title.getStyleClass().add("title");
	    footer.getStyleClass().add("footer");
	    
	    CalendarPane tile = new CalendarPane();
	    this.base.getChildren().add(title);
	    this.base.getChildren().add(tile);
	    this.base.getChildren().add(footer);
	    setPrefSize(250.0D, 250.0D);
	    getChildren().add(this.base);
	    
	    VBox.setVgrow(title, Priority.ALWAYS);
	    VBox.setVgrow(tile, Priority.ALWAYS);
	    VBox.setVgrow(footer, Priority.ALWAYS);
	  }
	  
	  public double computeMinWidth(double height)
	  {
	    return this.base.minWidth(height);
	  }
	  
	  public double computeMinHeight(double width)
	  {
	    return this.base.minHeight(width);
	  }
	  
	  public double computePrefWidth(double height)
	  {
	    return this.base.prefWidth(height) + snappedLeftInset() + snappedRightInset();
	  }
	  
	  public double computePrefHeight(double width)
	  {
	    return this.base.prefHeight(width) + snappedTopInset() + snappedBottomInset();
	  }
	  
	  public void layoutChildren()
	  {
	    double x = snappedLeftInset();
	    double y = snappedTopInset();
	    double w = getWidth() - (snappedLeftInset() + snappedRightInset());
	    double h = getHeight() - (snappedTopInset() + snappedBottomInset());
	    this.base.resizeRelocate(x, y, w, h);
	  }
	  
	  public String getUserAgentStylesheet()
	  {
	    return GNCalendarTile.class.getResource("../../css/join/calendar.css").toExternalForm();
	  }
	
}
