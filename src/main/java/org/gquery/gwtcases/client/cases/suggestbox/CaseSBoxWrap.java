package org.gquery.gwtcases.client.cases.suggestbox;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;

// http://stackoverflow.com/questions/19260068/gwt-suggestbox-as-a-textbox/19264122#19264122
//http://stackoverflow.com/questions/19264238/how-to-make-flowpanel-flow-its-children-vertically-like-verticalpanel/19265170#19265170
public class CaseSBoxWrap implements EntryPoint {

  public void onModuleLoad() {
    
    TextBox b = new TextBox();
    RootPanel.get().add(b);
    b.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        System.out.println("Click");
      }
    });
    
    MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
    String[] words = new String[] {"aaa", "bbb", "aabb"};
    for (int i = 0; i < words.length; ++i) {
      oracle.add(words[i]);
    }
    
    SuggestBox s = new SuggestBox(oracle, b);
    RootPanel.get().add(s);
      
      FlowPanel verticalFlowPanel = new FlowPanel();
      TextBox textBox = new TextBox();
      Label label = new Label("Foo");
      textBox.getElement().getStyle().setDisplay(Display.BLOCK);
      verticalFlowPanel.add(textBox);
      verticalFlowPanel.add(label);
      RootPanel.get().add(verticalFlowPanel);
      
      FlowPanel horizontalFlowPanel = new FlowPanel();
      TextBox textBox2 = new TextBox();
      Label label2 = new Label("Foo");
      label2.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
      horizontalFlowPanel.add(textBox2);
      horizontalFlowPanel.add(label2);
      RootPanel.get().add(horizontalFlowPanel);
      
      
      
      FlowPanel f = new FlowPanel();
      for (String ss : words) {
        f.add(new Label(ss));
      }
      
      RootPanel.get().add(f);

    
    
  }
  
}
