package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;
import gwtquery.plugins.enhance.client.Enhance;
import gwtquery.plugins.enhance.client.colorpicker.ColorPickerFactory.ColorPickerType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.widgets.WidgetFactory;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CaseGQPluginsEnhance implements EntryPoint {

  @Override public void onModuleLoad() {
//    $(".multiselect").as(Enhance.Enhance).multiselect();
    
    HTML h = new HTML("<div><input type=text class='pick' value='#888'></div>");
    RootPanel.get().add(h);
    
    $(".pick").as(Enhance.Enhance).colorBox(ColorPickerType.ADVANCED);
    
    TextBox bb = $(".pick").widget();
    bb.addValueChangeHandler(new ValueChangeHandler<String>() {
      
      @Override public void onValueChange(ValueChangeEvent<String> event) {
        System.err.println("VALC");
      }
    });
    bb.addChangeHandler(new ChangeHandler() {
      @Override public void onChange(ChangeEvent event) {
        System.err.println("CHANGE ....");
        
      }
    });
    
    $("<button>click</button>").appendTo(document).click(new Function(){public void f() {
      TextBox b = $(".pick").widget();
      b.setValue("#444", true);
    }});
  }
  
}
