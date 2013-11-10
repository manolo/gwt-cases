package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.lazy;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;

// http://stackoverflow.com/questions/16749711/gwt-capture-paste-event/16758588#16758588
public class CaseGQueryRichAreaContent implements EntryPoint {

  public void onModuleLoad() {
    RichTextArea richTextArea = new RichTextArea();

    // add text to text area
    richTextArea.setHTML("<b>Hi</b>");

    // First attach the widget to the DOM
    RootPanel.get().add(richTextArea);

    // We only can bind events to the content, once the iframe document has been created,
    // and this happens after it has been attached. Note that richtTextArea uses a timeout
    // to initialize, so we have to delay the event binding as well
    $(richTextArea).delay(1, 
      lazy()
      .contents()
      .find("body")
      .bind(Event.ONPASTE, new Function() {
        @Override public boolean f(Event e) {
          Window.alert("OnPaste");
          return true;
        }
      })
      .done());
  }
}
