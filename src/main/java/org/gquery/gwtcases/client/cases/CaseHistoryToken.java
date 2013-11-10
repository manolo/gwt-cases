package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
/**
 */
public class CaseHistoryToken implements EntryPoint {
  

  public void onModuleLoad() {
    
    // Esto funciona con HistoryImplMozilla modificado
    
//    History.addValueChangeHandler(new ValueChangeHandler<String>() {
//      @Override public void onValueChange(ValueChangeEvent<String> event) {
//        System.out.println(event.getValue());
//      }
//    });
//    
//    History.newItem("A");
//    History.newItem("B");
    
    $("<button>click</button>").click(new Function(){public void f() {
      Window.Location.replace(Window.Location.getPath() + Window.Location.getQueryString() +"#whatever");
    }}).appendTo(document);
  }  

}
