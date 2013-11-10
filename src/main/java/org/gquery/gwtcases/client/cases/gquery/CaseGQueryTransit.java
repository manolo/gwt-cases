package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation.EasingCurve;
import com.google.gwt.query.client.plugins.effects.Transitions;
import com.google.gwt.query.client.plugins.effects.TransitionsAnimation;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;

public class CaseGQueryTransit implements EntryPoint {
  
  public static class MyPopupPanel extends DecoratedPopupPanel {
    public MyPopupPanel() {
      super(true, true);
    }
    
    public void center() {
      super.center();
      $(this)
        .as(Transitions.Transitions)
        .css($$("{scale: 0, rotate: 0, background: violet, transformOrigin: 'center'}"))
        .as(Transitions.Transitions)
        .transition("{scale: 1, rotate: 360, background: green}", 1000, EasingCurve.easeIn, 0);
    }
    
    public void hide(final boolean b) {
      $(this)
        .as(Transitions.Transitions)
        .transition("{scale: 0, rotate: 0, background: violet}", 2000, EasingCurve.easeOut, 0)
        .promise().done(new Function(){public void f() {
            MyPopupPanel.super.hide(b);
        }});
    }
  }
  
  TransitionsAnimation a;
  Function f1;
  Function f2;
  int cont = 0;
  public void onModuleLoad() {

    final Transitions g1 = $("<div>AAAA</div>").css($$("border: solid 1px black, width: 200px, position: absolute, top: 100px")).appendTo(document).as(Transitions.Transitions);
    final Transitions gn2 = $("<div>BBBB</div>").css($$("border: solid 1px black, width: 200px, position: absolute, top: 200px")).appendTo(document).as(Transitions.Transitions);
    
//    TransitionsAnimation a = new TransitionsAnimation(null,  g1.get(0), 
//        $$("{ opacity: 0.1, scale: 2, x: 50, y: 50, rotate: 90deg, transformOrigin: 'right'}")
//        );
//    g1.hide();
//    gn2.hide();
    
    f1 = new Function(){public void f() {
      System.out.println(cont);
      if (cont++ < 1) {
        System.out.println("run " + cont);
        a.run(4000);
      }
      
    }};
    
    f2 = new Function(){public void f() {
      gn2.as(Effects).toggle(4000, f2);
    }};
    

    a = new TransitionsAnimation(null,  g1.get(0), 
        $$("opacity: 'toggle'") //, width : 'toggle', height : 'toggle'")
      , f1);
    
    a.run(4000);
    
//    f1.f();
//    f2.f();
    
    
    
//    a.onStart();
//    a.run(4000);
//    gn2.as(Effects).toggle(4000);
//    System.out.println(a.toString());
    
    if(true) return;
    
    final Transitions g2 = $("<div>BBBB</div>").css(
        $$("border: solid 1px black, height: 200px, background: red, width: 200px, position: absolute, top: 40%, bottom: 40%"))
        .appendTo(document)
        .as(Transitions.Transitions);
    
    g1.transition("{ opacity: 0.1, scale: 2, x: 50, y: 50 }", 5000, EasingCurve.easeInBack, 0)
      .transition("{x: +100, width: +40px}", 2000, EasingCurve.easeOut, 0);
    
    g2.css($$("{ transform: 'scale(0,1)', transformOrigin: 'right' }"));
    g2.transition("{scale: 1,1}", 5000, EasingCurve.easeOut, 0);

    final GQuery g3 = $("<div>CCC</div>").css(
        $$("border: solid 1px green, height: 200px, width: 200px"));
    
    final PopupPanel pop = new MyPopupPanel();
    
    Panel l = g3.as(Widgets).panel().widget();
    
    pop.setWidget(l);
    pop.center();
    
    $("<button>click</button>").click(new Function(){public void f() {
      pop.center();
    }}).appendTo(document);

    
    final GQuery g4 = $("<div>DDD</div>").css(
        $$("border: solid 1px green, height: 200px, width: 200px")).appendTo(document);
    
    final GQuery g5 = $("<div>EEE</div>").css(
        $$("border: solid 1px green, height: 200px, width: 200px")).appendTo(document);
    
    g4.css($$("{opacity: 0.5}")).hide().fadeIn(4000);
    
    g5
      .hide()
      .as(Transitions.Transitions)
      .css($$("{opacity: 0}"))
      .show()
      .as(Transitions.Transitions)
      .transition("{opacity: 1}", 4000, null, 0, new Function(){public void f() {
        $(this).css($$("{opacity: ''}"));
    }});
    
  }
  
}
