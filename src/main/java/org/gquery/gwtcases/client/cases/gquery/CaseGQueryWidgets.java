package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

//http://stackoverflow.com/questions/20172038/gwt-detach-widget-from-dom-and-add-to-panel

public class CaseGQueryWidgets implements EntryPoint {

  public void onModuleLoad() {
    $("<iframe src='http://gwtupload.alcala.org' id=bar1 />").appendTo(document);
    $("<input type=text id=bar2 value=B />" +
    		"<div id='bar3' >C</div>").appendTo(document);
    
    final HorizontalPanel horizontalPanel = new HorizontalPanel();
    
    $("#bar1, #bar2, #bar3").as(Widgets).panel().panel().panel();
    
    horizontalPanel.add($("#bar1").widget());
    horizontalPanel.add($("#bar2").widget()); 
    horizontalPanel.add($("#bar3").widget()); 
//    
    RootPanel.get().add(horizontalPanel);
//    
//    Panel p = $("#bar3").widget();
//    p.add(new Label("aaa"));
//    p.add(new Label("bbb"));
//    p.add(new Label("ccc"));
    
//    $(horizontalPanel).delay(4000).promise().done(new Function(){public void f() {
//      horizontalPanel.clear();
//    }});
    
  }
}
