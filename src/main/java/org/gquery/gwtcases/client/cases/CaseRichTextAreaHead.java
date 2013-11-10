package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * http://stackoverflow.com/questions/17029044/gwt-richtextarea-formatter-fires/17037808#17037808
 * http://stackoverflow.com/questions/19220293/how-to-get-content-of-iframe-using-gwt-query/19347163#19347163
 */
public class CaseRichTextAreaHead implements EntryPoint {

  private native void export() /*-{
		$wnd.$ = {
			pnotify : function(a) {
				alert(a);
				$wnd.a = a;
			}
		}
  }-*/;

  public void onModuleLoad() {
    
    final RichTextArea richTextArea = new RichTextArea();
    
    // First attach the widget to the DOM
    RootPanel.get().add(richTextArea);

    new Timer() {
      private native Element getBodyElement(Element iframe) /*-{
		    return iframe.contentWindow.document.body;
      }-*/;

      public void run() {
        Element e = getBodyElement(richTextArea.getElement());
        e.getStyle().setProperty("fontName", "Verdana");
        e.getStyle().setProperty("fontSize", "x-small");
      }
    }.schedule(1);
    
    $(richTextArea)
      .delay(1, 
        lazy()
          .contents().find("body")
            .css("font-name", "verdana")
            .css("font-size", "x-small")
        .done());
    
    new Timer() {
      private native Element getHeadElement(Element iframe) /*-{
        return iframe.contentWindow.document.head;
      }-*/;

      public void run() {
        Element e = getHeadElement(richTextArea.getElement());
        Element s = DOM.createElement("style");
        s.setInnerText("body{background: yellow}");
        e.appendChild(s);
        System.out.println($(richTextArea).contents().get(0));
      }
    }.schedule(1);
    
    $(richTextArea).delay(1, 
        lazy()
          .contents().find("head").append("<style> body{color: red} </style>")
        .done());
    
  }
  

}
