package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.lazy;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.js.JsObjectArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * http://stackoverflow.com/questions/17029044/gwt-richtextarea-formatter-fires/17037808#17037808
 */
public class CaseRichTextAreaBody implements EntryPoint {

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
    RootPanel.get().add(richTextArea);

    new Timer() {
      private native Element getBodyElement(Element iframe) /*-{
		    return iframe.contentWindow.document.body;
      }-*/;

      public void run() {
        Element e = getBodyElement(richTextArea.getElement());
        e.getStyle().setProperty("fontName", "Verdana");
        e.getStyle().setProperty("fontSize", "x-small");
        e.getStyle().setProperty("color", "gray");
      }
    }.schedule(1);
    
    $(richTextArea)
      .delay(1, 
        lazy()
          .contents().find("body")
            .css("font-name", "verdana")
            .css("font-size", "x-small")
            .css("color", "gray")
        .done());
    
  }
  

}
