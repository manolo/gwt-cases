package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.plugins.effects.ClipAnimation;
import com.google.gwt.query.client.plugins.effects.PropertiesAnimation;
import com.google.gwt.query.client.plugins.effects.TransitionsAnimation;

public class CaseGQueryAnimations implements EntryPoint {
  
  private void createDivs() {
    String[] colors = new String[] {"aqua", "darkmagenta", "fuchsia", "gold", "maroon"};

    
    int t = 40;
    for (int i = 0; i < colors.length; i++) {
      String color = colors[i];
      if (i%5 == 0) t+=105;
      int l = i*105;
      $("<div class='sample'></div><button>FX</button>")
        .css($$("position: absolute, top:" + t + ",left:" + l))
        .appendTo(document)
        .filter("div")
        .css($$("border: solid 1px black, width: 100px, height: 100px, background:" + color));
    }
    
  }
  public void onModuleLoad() {
    createDivs();
    
    $("button").eq(0).click(new Function(){
      Animation a;
      public void f() {
        if (a == null) {
          a = new TransitionsAnimation($(this).prev().get(0),
             $$("width: toggle"));
        }
//        a.cancel();
        a.run(2000);
      }
    });

    $("button").eq(1).click(new Function(){
      Animation a;
      public void f() {
        if (a == null) {
          a = new ClipAnimation($(this).prev().get(0),
             $$(""));
        }
//        a.cancel();
        a.run(2000);
      }
    });
    
  }
  
}
