package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import java.util.Arrays;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.effects.Bezier;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

// http://stackoverflow.com/questions/18751561/gwtquery-load-replaces-element
public class CaseGQueryResize implements EntryPoint {
  

      // Create your own implementation of a panel
      public static class MyFlowPanel extends FlowPanel {
        
        // The GQuery object for this panel
        GQuery $this = $(this);
        
        // Override the add method so as each time it is called, we run an animation
        // You can do the same with the remove method.
        @Override
        public void add(Widget w) {
          // Compute the actual height
          int hInitial = $this.height();
          // Set height to auto before adding the new child.
          $this.height("auto").css("transition", "height 0s");
          // Add the new widget to panel
          super.add(w);
          // Compute the new height
          int hFinal = $this.height();
          
          $this.height(hFinal*2).css("transition", "height 2s");
          $this.height(hFinal);
          System.out.println(hInitial + " " + hFinal);

          // Use Gquery to .animate the panel from the old to the new height
          // You could replace this with css3 transitions
//          $this.height(hInitial)
//               .stop(true)
//               .animate("height: " + hFinal, 2000);
        };
      };
      
      private String toBar(double t) {
        int i = (int)(120 * t);
        if (i<1) return "";
        char[] b = new char[i];
        Arrays.fill(b, 'x');
        return new String(b);
      }
      
      public void onModuleLoad() {
        
        double duration = 200; // duration of animation in milliseconds.
        double epsilon = (1000 / 60 / duration) / 4;

        Bezier easeIn2 = new Bezier(.68,-.55,.265,1.55);
        Bezier linear2 = new Bezier(0, 0, 1, 1);
        for (double t = 0; t <= 1; t += 0.001){
//            System.out.println(toBar(easeIn.f(t)));
            System.out.println(toBar(easeIn2.f(t)));
//            System.out.println(toBar(linear.f(t)));
            System.out.println(toBar(linear2.f(t)));
        }        
        
        if(true) return;
        
        // Create your panel, and use it as usual in GWT
        final FlowPanel myFlowPanel = new MyFlowPanel();
        RootPanel.get().add(myFlowPanel);
        // Set some css properties to your panel. You could set these in your style-sheet.
        $(myFlowPanel).css($$("border: 1px solid grey; overflow: hidden; border-radius: 8px; background: #F5FFFA; width: 500px; padding: 8px"));
        
        // Add 10 labels to the panel in periodes of 1000 ms
        Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
          int c = 10;
          public boolean execute() {
            if (c-- > 0) {
              myFlowPanel.add(new Label(c + " Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
              return true;
            }
            return false;
          }
        }, 4000);
      }

}
