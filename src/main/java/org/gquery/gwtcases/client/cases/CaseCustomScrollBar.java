package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.js.JsUtils;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CustomScrollPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalScrollbar;
import com.google.gwt.user.client.ui.Widget;
/**
 * SinkEvents CellTable
 * http://stackoverflow.com/questions/15833985/gwt-sinkevents-in-hosted-mode
 * 
 * Enhance CellTable with GQuery
 * http://stackoverflow.com/questions/15841066/in-gwt-how-to-add-a-row-on-top-of-header-of-celltable
 */
public class CaseCustomScrollBar implements EntryPoint {
  
  HorizontalPanel hpanel = new HorizontalPanel();

  @Override 
  public void onModuleLoad() {
    RootPanel.get().add(hpanel);
    
    CustomScrollPanel customPanel = new CustomScrollPanel();
    customPanel.setSize("100px", "200px");
    String s = "asdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    for (int i = 0; i < 500; i++) {
      s += "asd ";
    }
    customPanel.add(new HTML(s));
    customPanel.setVerticalScrollbar(new AbstractNativeScrollbar(), 10);
    
    final ScrollPanel scrollPanel = new ScrollPanel();
    scrollPanel.setSize("100px", "200px");
    scrollPanel.add(new HTML(s));
    
    Button button = new Button("Click");
    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        NativeEvent nevent = Document.get().createScrollEvent();
        JsUtils.prop(nevent, "delta", 10);
        JsUtils.prop(nevent, "wheelDelta ", 10);
        DomEvent.fireNativeEvent(nevent, scrollPanel);
      }
    });
    
    Label label = new Label("wheel me");
    label.addMouseWheelHandler(new MouseWheelHandler() {
      public void onMouseWheel(MouseWheelEvent event) {
        int d = event.getDeltaY();
        final NativeEvent ev = event.getNativeEvent();
        System.out.println(d);
        Properties p = ev.cast();
//        System.out.println(p.toJsonString());
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
          public void execute() {
            scrollPanel.getElement().dispatchEvent(ev);
            
          }
        });
//        doJs(ev, d, scrollPanel.getElement());
//        scrollPanel.getElement().dispatchEvent(ev);
      }
    });
    
    hpanel.add(customPanel);
    hpanel.add(scrollPanel);
    hpanel.add(button);
    hpanel.add(label);
  }
  
  private native void doJsFF(JavaScriptObject ev, int delta, Element view)/*-{
    try {
    var evt = $doc.createEvent("MouseEvents");
    evt.initMouseEvent(
      'DOMMouseScroll', // in DOMString typeArg,
       true,  // in boolean canBubbleArg,
       true,  // in boolean cancelableArg,
       $wnd,  // in views::AbstractView viewArg,
       delta, // in long detailArg,
       0,     // in long screenXArg,
       0,     // in long screenYArg,
       0,     // in long clientXArg,
       0,     // in long clientYArg,
       0,     // in boolean ctrlKeyArg,
       0,     // in boolean altKeyArg,
       0,     // in boolean shiftKeyArg,
       0,     // in boolean metaKeyArg,
       0,     // in unsigned short buttonArg,
       null,   // in EventTarget relatedTargetArg
       0x01
    );
    view.dispatchEvent(evt);
    } catch(e) {alert(e);}    

}-*/;
  
  private native void doJs(JavaScriptObject ev, int delta, Element el )/*-{
//    var evt = $doc.createEvent("MouseEvents");
//    evt.initEvent('mousewheel', true, true);
//    evt.wheelDeltaY = delta;
    $wnd.console.log(" > " + delta);
//    alert(el.dispatchEvent);

//      el.dispatchEvent(ev);
    
    setTimeout(function() {
//      alert('aa');
      el.dispatchEvent(ev);
//      $wnd.el = el;
//      $wnd.ev = ev;
//      el.dispatchEvent(ev)
    }, 200);
  
  }-*/;
  
  
  public static class AbstractNativeScrollbar extends Widget implements VerticalScrollbar {
    
    Element contentDiv = DOM.createDiv();
    Element scrollable = DOM.createDiv();
    int totalHeight = 0;
    int spos = 0;
    
    public AbstractNativeScrollbar() {
      contentDiv.appendChild(scrollable);
      setElement(contentDiv);
      $(contentDiv).css($$("background: yellow"));
      $(scrollable).css($$("background: red; position: relative"));
    }

    public HandlerRegistration addScrollHandler(ScrollHandler handler) {
      Event.sinkEvents(getElement(), Event.ONSCROLL);
      return addHandler(handler, ScrollEvent.getType());
    }

    @Override protected void onAttach() {
      super.onAttach();
      Event.setEventListener(getElement(), this);
    }

    @Override protected void onDetach() {
      Event.setEventListener(getElement(), null);
      super.onDetach();
    }

    @Override public int getMaximumVerticalScrollPosition() {
      System.out.println("getMaximumVerticalScrollPosition " + " " +  getElement().getClientHeight() + " " + (scrollable.getScrollHeight() - getElement().getClientHeight()));
      return scrollable.getScrollHeight() - getElement().getClientHeight();
    }

    @Override public int getMinimumVerticalScrollPosition() {
      System.out.println("getMinimumVerticalScrollPosition");

      return 0;
    }

    @Override public int getVerticalScrollPosition() {
      System.out.println("getVerticalScrollPosition "  + " " +  getElement().getClientHeight() + " " + scrollable.getOffsetTop());
      return spos;
//      int p = scrollable.getOffsetTop();
//      return p * totalHeight / contentDiv.getClientHeight();
    }

    @Override  public void setVerticalScrollPosition(int position) {
      System.out.println("setVerticalScrollPosition "  + " " +  getElement().getClientHeight() + " " + totalHeight + " " + position + " " + getScrollHeight());
      int p = (spos = position) * contentDiv.getClientHeight() / totalHeight;
      scrollable.getStyle().setTop(p, Unit.PX);
    }

    @Override public int getScrollHeight() {
      System.out.println("getScrollHeight "  + " " +  getElement().getClientHeight() + " " + scrollable.getOffsetHeight());
      return contentDiv.getOffsetHeight();
    }

    @Override  public void setScrollHeight(int height) {
      System.out.println("setScrollHeight "  + " " +  getElement().getClientHeight() + " " + height);
      totalHeight = height;
      int h = height * contentDiv.getClientHeight() / totalHeight;
      scrollable.getStyle().setHeight(contentDiv.getClientHeight() / 2, Unit.PX);
    }
  }
  
}
