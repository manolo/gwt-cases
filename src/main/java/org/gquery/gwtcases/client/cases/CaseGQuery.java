package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class CaseGQuery implements EntryPoint {

  public void onModuleLoad() {
//    $("div")
//    .hover(new Function() {
//      public void f(Element e) {
//        $(e).css("color", "blue").stop(true, true).animate("fontSize: '+=10px'");
//      }
//    }, new Function() {
//      public void f(Element e) {
//        $(e).css("color", "").stop(true, true).animate("fontSize: '-=10px'");
//      }
//    });
    
    
    // http://stackoverflow.com/questions/16101436/disable-horizontal-scroll-bar-in-gwt-richtextarea-in-ie
    final RichTextArea area = new RichTextArea();
    RootPanel.get().add(area);
    $(area).delay(100, 
      lazy().contents().find("body").css($$("overflow-x: hidden")).done()
    );
    
    
    // http://stackoverflow.com/questions/17930945/gwtquery-empty-widget-after-fadeout/18308817#18308817
    $("div").click(new Function(){public void f() {
      showErrorNotification("Que pasa tron");
    }});
    $("<div class='aaa'>AAA</div>").appendTo(document).hide();
    
  }
  
  public static void showErrorNotification(String message){
//    for (Widget w : allNotifications){
//      System.out.println($(w));
    String w = ".aaa";
        $(w).stop(true, true).fadeIn(1000);
        $(w).find(".errorAlert").remove();
        $(w).append("<div id=\"errorAlert\" class=\"rounded10 errorAlert\">" +
                "<img alt=\"\" src=\"public/images/exclamation.png\"> " +
                "You must accept the terms and conditions to finish your registration." +
                "</div>");
        $(w).fadeOut(5000);
        $(w).queue(new Function(){
          public void f() {
            $(this).find(".errorAlert").remove();  
          }
        });
        
        
//        $(w)
//            .stop(true, true)
//            .fadeIn(1000)
//            .find(".errorAlert").remove().end()
//            .append("<div id=\"errorAlert\" class=\"rounded10 errorAlert\">" +
//                "<img alt=\"\" src=\"public/images/exclamation.png\"> " +
//                "You must accept the terms and conditions to finish your registration." +
//                "</div>")
//            .fadeOut(5000)
//            .queue(new Function(){
//              public void f() {
//                $(this).find(".errorAlert").remove();  
//              }
//            });
        
        //$(w).empty();
//    }
  }
  
}
