package org.gquery.gwtcases.client.cases.dom;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventPreview;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * http://stackoverflow.com/questions/19433813/move-viewport-of-element-map-in-gwt/19465232#19465232
 */
public class CaseViewPort implements EntryPoint {
  

  public void onModuleLoad() {
    
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 500; i++) {
        buffer.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }
    HTML html = new HTML(buffer.toString());
    
    Viewport vport = new Viewport();
    vport.setSize("400px", "400px");
    vport.setView(html);
    vport.getElement().getStyle().setProperty("border", "solid 1px red");
    RootPanel.get().add(vport);
    
  }  
  
  public static class Viewport extends AbsolutePanel {
    private static final String DEFAULT_MOUSE_DOWN_CURSOR = "moveCursor";
    private static final String DEFAULT_MOUSE_DRAG_CURSOR = "pointerCursor";

    private final FocusPanel panel = new FocusPanel();

    private String mouseDownCursor = DEFAULT_MOUSE_DOWN_CURSOR;
    private String mouseDragCursor = DEFAULT_MOUSE_DRAG_CURSOR;

    private Widget view = null;

    private boolean dragging = false;
    private int xOffset, yOffset;

    private boolean eventPreviewAdded = false;

    private static EventPreview preventDefaultMouseEvents = new EventPreview() {
        public boolean onEventPreview(Event event) {
//          switch (DOM.eventGetType(event)) {
//             case Event.ONMOUSEDOWN:
//             case Event.ONMOUSEMOVE:
//          }
//          return true;
          DOM.eventPreventDefault(event);
          return false;
        }
      };

    public Viewport() {
      add(panel);

      panel.addMouseListener(new MouseListenerAdapter() {
        public void onMouseEnter() {
         DOM.addEventPreview(preventDefaultMouseEvents);
        }

        public void onMouseLeave() {
         DOM.removeEventPreview(preventDefaultMouseEvents);
        }

        public void onMouseDown(Widget widget, int x, int y) {
          dragging = true;

          xOffset = x;
          yOffset = y;

          DOM.setCapture(panel.getElement());
        }

        public void onMouseMove(Widget widget, int x, int y) {
          if (dragging) {
            getElement().getStyle().setCursor(Cursor.MOVE);

            int newX = x + getWidgetLeft(panel) - xOffset;
            int newY = y + getWidgetTop(panel) - yOffset;

            setWidgetPosition(panel, newX, newY);
          }
        }

        public void onMouseUp(Widget widget, int x, int y) {
          if (dragging) {
            dragging = false;
            getElement().getStyle().setCursor(Cursor.CROSSHAIR);

            DOM.releaseCapture(panel.getElement());
          }
        }
      });
    }

    public String getMouseDownCursor() {
      return mouseDownCursor;
    }

    public void setMouseDownCursor(String mouseDownCursor) {
      this.mouseDownCursor = mouseDownCursor;
    }

    public String getMouseDragCursor() {
      return mouseDragCursor;
    }

    public void setMouseDragCursor(String mouseDragCursor) {
     this.mouseDragCursor  = mouseDragCursor;
    }

   public Widget getView() {
    return view;
   }

   public void setView(Widget view) {
     this.view = view;
     panel.setWidget(view);
   }
  }
  
}
