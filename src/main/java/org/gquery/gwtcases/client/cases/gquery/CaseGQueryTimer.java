package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

//http://stackoverflow.com/questions/20488514/how-to-apply-gwt-query-on-the-elements-which-are-declared-in-gwt-entrypoint
public class CaseGQueryTimer implements EntryPoint {
    

    
        VerticalPanel fiscalSettingPanel = new VerticalPanel();
        AbsolutePanel messagePanel = new AbsolutePanel();
        SimplePanel finishPanel = new SimplePanel();
//        BaseCurrency baseCurrencyGlobal;
        ListBox monthListBox = new ListBox();

        @Override
        public void onModuleLoad() {
          fiscalSettingPanel.setSize("200px", "100px");
          
          RootPanel.get().add(fiscalSettingPanel);
          $("<div id='accountingsetup-div'><span>loading</span></div>").appendTo(document);
          
          $(window).delay(2000, new Function(){public void f() {

            // Removing loading image in Jsp before loading gwt module.
            $("#accountingsetup-div").delay(1000).empty();
            
            // Here i am getting success message from server(gwt-rpc) and that to the  "messagePanel", that messagePanel to the 'fiscalSettingPanel '   
            fiscalSettingPanel.add(messagePanel);
            
            messagePanel.clear();
            messagePanel.add(new Label("Server message"));
            
            $(messagePanel).show().delay(4000).fadeOut();
            
            
            
            
          }});
          
          

       }
}
