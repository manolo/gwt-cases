package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.$$;
import static com.google.gwt.query.client.GQuery.lazy;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;

public class CaseGQuerySelectorAll implements EntryPoint {

  public void onModuleLoad() {
    $("div")
    .hover(new Function() {
      public void f(Element e) {
        $(e).css("color", "blue").stop(true, true).animate("fontSize: '+=10px'");
      }
    }, new Function() {
      public void f(Element e) {
        $(e).css("color", "").stop(true, true).animate("fontSize: '-=10px'");
      }
    });
    
    
    // http://stackoverflow.com/questions/16101436/disable-horizontal-scroll-bar-in-gwt-richtextarea-in-ie
    final RichTextArea area = new RichTextArea();
    RootPanel.get().add(area);
    $(area).delay(100, 
      lazy().contents().find("body").css($$("overflow-x: hidden")).done()
    );
  }
  
}
