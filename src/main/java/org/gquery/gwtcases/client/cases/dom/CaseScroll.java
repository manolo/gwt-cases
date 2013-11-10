package org.gquery.gwtcases.client.cases.dom;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
/**
 * http://stackoverflow.com/questions/19559078/gwt-scrollpanel-scrollbar-shown-event/19560603#19560603
 */
public class CaseScroll implements EntryPoint {
  

  public void onModuleLoad() {
    String s = "";
    for (int i = 0; i < 500; i++) {
      s += "Con diez canones por banda viento en popa a toda vela. ";
    }
    final String c = s;
    
    final ScrollPanel p = new ScrollPanel();

    $("<button>click</button>").appendTo(document).click(new Function(){public void f() {
      $("<div>").appendTo(document).text(c);
      System.out.println(isWindowVerticalScrollShown() + " " + isElementVerticalScrollShown(p.getElement()));
    }});
    
    p.setHeight("300px");
    RootPanel.get().add(p);
    System.out.println(isWindowVerticalScrollShown() + " " + isElementVerticalScrollShown(p.getElement()));
    
    p.add(new Label(s));
    System.out.println(isWindowVerticalScrollShown() + " " + isElementVerticalScrollShown(p.getElement()));
    
    
    
  }  
  
  // To check if the window scroll is being shown
  public static boolean isWindowVerticalScrollShown() {
    return Document.get().getScrollHeight() > Document.get().getClientHeight();
  }

  // To check if a element scroll is being shown 
  public static boolean isElementVerticalScrollShown(Element el) {
    return el.getScrollHeight() > el.getClientHeight();
  }

}
