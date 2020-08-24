package yaksa.member.calendar.join;

import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class CalendarPane extends Control {

	  private CalendarSkeleton skeleton = new CalendarSkeleton();
	  
	  public CalendarPane()
	  {
	    getStyleClass().add("calendar-pane");
	  }
	  
	  protected Skin<?> createDefaultSkin()
	  {
	    return new CalendarTileSkin(this);
	  }
	  
	  CalendarSkeleton getSkeleton()
	  {
	    return this.skeleton;
	  }
}
