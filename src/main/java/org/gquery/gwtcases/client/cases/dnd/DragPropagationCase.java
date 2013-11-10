package org.gquery.gwtcases.client.cases.dnd;

import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.plugins.UiPlugin.*;
import gwtquery.plugins.draggable.client.Draggable;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
/**
 * IE8 nested draggable propagation
 *  
 * http://stackoverflow.com/questions/16950665/gwt-query-nested-draggable-propagation
 */
public class DragPropagationCase implements EntryPoint {
  
  public void onModuleLoad() {
    HorizontalPanel draggable = new HorizontalPanel();
    Function startDragParent = new Function () {
        @Override
        public boolean f (Event e) {
        // some code here...
        return false;
    }
    };
    Function dragParent = new Function () {
        @Override
        public boolean f (Event e) {
        // some code here...
        return false;
    }
    };
    Function stopDragParent = new Function () {
        @Override
        public boolean f (Event e) {
        // some code here...
        return false;
    }
    };
    $(draggable).as(Draggable.Draggable).draggable()
        .bind(BrowserEvents.DRAGSTART, startDragParent)
        .bind(BrowserEvents.DRAG, dragParent)
        .bind(BrowserEvents.DRAGEND, stopDragParent);

    HorizontalPanel childDraggable = new HorizontalPanel();
    Function dragChild = new Function () {
        @Override
        public boolean f (Event e) {
        // some code here...
        return false;
    }
    };
    $(childDraggable).as(Draggable.Draggable).draggable().bind(BrowserEvents.DRAG, dragChild);

    // finally I add one element inside another
    draggable.add(childDraggable);
    
    RootPanel.get().add(draggable);
    $(draggable).css($$("width: 50px, height: 50px, background: red"));

    
  }  

}
