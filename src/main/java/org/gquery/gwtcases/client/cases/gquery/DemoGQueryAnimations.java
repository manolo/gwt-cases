package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.effects.Fx;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Action;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Corner;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Direction;

public class DemoGQueryAnimations implements EntryPoint {
  
  private TreeMap<String, Function> animations = new TreeMap<String, Function>(){{
    put("01 fadeOut", new Function(){public void f() {$(this).as(Effects).fadeOut();}});
    put("02 fadeIn", new Function(){public void f() {$(this).as(Effects).fadeIn();}});
    put("03 fadeTo 0.5", new Function(){public void f() {$(this).as(Effects).fadeTo(.5);}});
    put("04 fadeTo 1", new Function(){public void f() {$(this).as(Effects).fadeTo(1);}});
    put("05 fadeToggle", new Function(){public void f() {$(this).as(Effects).fadeToggle(800);}});
    put("06 slideUp", new Function(){public void f() {$(this).as(Effects).slideUp();}});
    put("07 slideDown", new Function(){public void f() {$(this).as(Effects).slideDown();}});
    put("08 slideLeft", new Function(){public void f() {$(this).as(Effects).slideLeft();}});
    put("09 slideRight", new Function(){public void f() {$(this).as(Effects).slideRight();}});
    put("10 slideToggle", new Function(){public void f() {$(this).as(Effects).slideToggle(800);}});
    put("11 toggle", new Function(){public void f() {$(this).as(Effects).toggle(800);}});
    put("12 clipUp", new Function(){public void f() {$(this).as(Effects).clipUp();}});
    put("13 clipDown", new Function(){public void f() {$(this).as(Effects).clipDown();}});
    put("14 clipDisappear", new Function(){public void f() {$(this).as(Effects).clipDisappear();}});
    put("15 clipAppear", new Function(){public void f() {$(this).as(Effects).clipAppear();}});
    put("16 clipToggle", new Function(){public void f() {$(this).as(Effects).clipToggle(800);}});
    put("17 clip custom", new Function(){public void f() {$(this).as(Effects).clip(Action.TOGGLE, Corner.TOP_RIGHT, Direction.BIDIRECTIONAL);}});
    put("18 animate red", new Function(){public void f() {$(this).as(Effects).animate($$("background-color: red, color: gold"));}});
    put("18 animate gold", new Function(){public void f() {$(this).as(Effects).animate($$("background-color: gold, color: red"));}});
    put("19 rotation", new Function(){public void f() {$(this).as(Effects).animate($$("rotateY:180deg, rotateX:180deg, background:red, color: gold, transformOrigin:'center'"));}});
    put("20 rotation", new Function(){public void f() {$(this).as(Effects).animate($$("rotateY:0deg, rotateX:0deg, background: gold, color: red, transformOrigin:'center'"));}});
  }};

  public void onModuleLoad() {
    
    final GQuery div = $("<div class='sample'>Lorem ipsum dolor sit amet, consectetur adipiscing elit</div>")
      .css($$("position: absolute, top: 20px, right: 20px"))
      .css($$("border: solid 1px black, width: 100px, background: gold, font-size: 14px, padding: 15px"));
    
//    Fx.css3 = false;
    
    GQuery ul= $("<ul>");
    for (final Entry<String, Function> e : animations.entrySet()) {
      $("<li>" + e.getKey()).appendTo(ul).click(new Function(){public void f() {
        e.getValue().setElement(div
            .stop(false, true)
            .get(0)).f();
      }});
    }
    ul.appendTo(document);
    div.appendTo(document);
  }
  
}
