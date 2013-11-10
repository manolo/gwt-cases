package org.gquery.gwtcases.client.cases.dom;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * http://stackoverflow.com/questions/17619282/gxt-gwt-widget-for-the-object-tag/17627616#17627616
 */
public class CaseDOM implements EntryPoint {
  

  public void onModuleLoad() {
  
//      // Create an element and programatically set its attributes
//      ObjectElement o = Document.get().createObjectElement();
//      o.setWidth("100%");
//      o.setHeight("100%");
//      o.setData("/media/invoice1.pdf");
//      
//      // Attach the element to the document
//      Document.get().getBody().appendChild(o);
//  
//      // Optionally you could wrap your element into a widget.
//      Widget w = HTMLPanel.wrap(o);
      
      
      
      RadioButton b1 = new RadioButton("a", "b");
      RadioButton b2 = new RadioButton("a", "b");
      RootPanel.get().add(b1);
      RootPanel.get().add(b2);
      
      ListBox l = new ListBox();
      
      Panel panel = new VerticalPanel();
      final HTML widget1 = new HTML("<span>Foo</span> <span>Bar</span");
      final HTML widget2 = new HTML("<span>Foo</span> <span>Bar</span");
      final HTML widget3 = new HTML("<span>Foo</span> <span>Bar</span");
      
      panel.add(widget1);
      panel.add(widget2);
      panel.add(widget3);

      // we need to wrap our panel with a widget supporting click events
      FocusPanel wrapper = new FocusPanel();
      wrapper.add(panel);
      RootPanel.get().add(wrapper);

      wrapper.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          // The element is not the HTML widget clicked but the span element
          Element e = event.getNativeEvent().getEventTarget().cast();
          // We know that HTML widgets have gwt-HTML class
          // but we could mark our widgets with a customized class name
          Widget w = $(e).closest(".gwt-HTML").widget();
          if (w == widget1) {
            Window.alert("Clicked on widget 1");
          }
          if (w == widget2) {
            Window.alert("Clicked on widget 2");
          }
          if (w == widget3) {
            Window.alert("Clicked on widget 3");
          }
        }
      });
  }  

}
