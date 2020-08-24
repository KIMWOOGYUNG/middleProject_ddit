package yaksa.member.main.main.calendar;

import java.time.LocalDate;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.SkinBase;

public class CalendarTileSkin extends SkinBase<CalendarPane> {
	
	
	private CalendarSkeleton skeleton;
	  
	  protected CalendarTileSkin(CalendarPane control)
	  {
	    super(control);
	    this.skeleton = ((CalendarPane)getSkinnable()).getSkeleton();
	    refresh();
	  }
	  
	  private void refresh()
	  {
	    getChildren().clear();
	    
	    
	    
	    this.skeleton.setYear(2020);
	    this.skeleton.setMonthValue(4);
	    String[][] val = this.skeleton.createSkeleton();
	    for (int k = 0; k < this.skeleton.getColumns(); k++)
	    {
	      CalendarCell cell = new CalendarCell(val[0][k], LocalDate.now(), val[0][k]); // 월을 추가한다.
	      
	      getChildren().add(cell);
	    }
	    for (int i = 1; i < this.skeleton.getRows(); i++) {
	      for (int j = 0; j < this.skeleton.getColumns(); j++)
	      {
	        CalendarCell cell = null;
	        
	        cell = new CalendarCell("day" + String.valueOf(LocalDate.parse(val[i][j]).getDayOfMonth()), LocalDate.now(), String.valueOf(LocalDate.parse(val[i][j]).getDayOfMonth()));
	        if (LocalDate.parse(val[i][j]).getMonthValue() != this.skeleton.getMonthValue()) {
	          cell.setDisable(true);
	        }
	        if (LocalDate.parse(val[i][j]).equals(LocalDate.now())) {
	          cell.setSelected(true);
	        }
	        cell.setMouseTransparent(true);
	        getChildren().add(cell);
	      }
	    }
	  }
	  
	  protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight)
	  {
	    double width = ((CalendarPane)getSkinnable()).getWidth();
	    double height = ((CalendarPane)getSkinnable()).getHeight();
	    
	    double cellWidth = width / this.skeleton.getColumns();
	    double cellHeight = height / this.skeleton.getRows();
	    for (int i = 0; i < this.skeleton.getRows(); i++) {
	      for (int j = 0; j < this.skeleton.getColumns(); j++)
	      {
	        if (getChildren().size() <= i * this.skeleton.getColumns() + j) {
	          break;
	        }
	        layoutInArea((Node)getChildren().get(i * this.skeleton.getColumns() + j), j * cellWidth, i * cellHeight, cellWidth, cellHeight, 0.0D, HPos.CENTER, VPos.CENTER);
	      }
	    }
	  }

}
