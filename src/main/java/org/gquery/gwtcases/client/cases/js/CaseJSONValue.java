package org.gquery.gwtcases.client.cases.js;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;



// 
public class CaseJSONValue implements EntryPoint {

    
    public void onModuleLoad() {
      JSONString value = new JSONString("whatever");
      jsni(value);
    }
    
    private static native void jsni(JSONValue value) /*-{
      if (value) {
        value =  value.@com.google.gwt.json.client.JSONValue::getUnwrapper()()(value);
        alert(value);
      }
    }-*/;
  
}
