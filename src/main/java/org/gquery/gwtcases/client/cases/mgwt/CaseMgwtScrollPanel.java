package org.gquery.gwtcases.client.cases.mgwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
/**
 * http://stackoverflow.com/questions/19433813/move-viewport-in-gwt/19465232
 */
public class CaseMgwtScrollPanel implements EntryPoint {


    public void onModuleLoad() {
      
      LayoutPanel main = new LayoutPanel();
      ScrollPanel scrollPanel = new ScrollPanel();
      RoundPanel roundPanel = new RoundPanel();

      scrollPanel.setWidget(roundPanel);
      main.add(scrollPanel);
      RootPanel.get().add(main);


      StringBuffer buffer = new StringBuffer();
      for (int i = 0; i < 500; i++) {
          buffer.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
      }
      HTML html = new HTML(buffer.toString());

      roundPanel.add(html);

      // Set the size of your view-port and its content
      main.setSize("400px", "400px");
      html.setWidth("1000px");
      
    }
  
}
