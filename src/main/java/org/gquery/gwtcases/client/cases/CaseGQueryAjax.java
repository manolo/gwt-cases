package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Promise;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.builders.JsonBuilder;
import com.google.gwt.query.client.plugins.ajax.Ajax;
import com.google.gwt.query.client.plugins.ajax.Ajax.Settings;
import com.google.gwt.user.client.Window;

// http://stackoverflow.com/questions/17945322/gwt-how-to-do-async-response-with-http-promise-like-in-playframework/17947233#17947233
// http://stackoverflow.com/questions/17534864/gwt-rpc-vs-rest-is-it-really-one-or-the-other/17575966#17575966
public class CaseGQueryAjax implements EntryPoint {
  
  
    // GQuery generator
    public static interface MyBean extends JsonBuilder {
      long getId();
      String[] getTags();
      String getTitle();
    }
    
    public void onModuleLoad1() {
      // Configure an Ajax request
      Settings rq = Ajax.createSettings()
        .setUrl("rest_service.js")
        .setType("post") // options: get post put delete head
        .setDataType("json") // send and read json data
        .setData($$("foo: bar")); // Your JavaScriptObject
      
      System.out.println(rq.toJson());
      
      // GQuery Ajax return a Promise
      Ajax.ajax(rq)
        .done(new Function() {
          public void f() {
            // You can inspect arguments with this
            System.out.println(dumpArguments());
    
            // Create the bean, and wrap the json object read
            MyBean b = GWT.create(MyBean.class);
            b.load(arguments(0));
    
            // toString in JsonBuilder returns the json string
            System.out.println(b.toString());
          }
        })
        .fail(new Function() {
          public void f() {
    
          }
        });
    }
    
    public void onModuleLoad() {
      
      Promise promise = ajax($$("url: rest_service.js, type: post, dataType: json, data: {foo: bar}"));
      
      promise.done(new Function(){public void f() {
        Properties jsonResponse = arguments(0);
        Window.alert("Feed title:" + jsonResponse.get("title"));
      }});
      
      
      
      if(true) return;
//      GQuery.ajax();
      // Configure an Ajax request
      Settings rq = Ajax.createSettings()
        .setUrl("rest_service.js")
        .setType("post") // options: get post put delete head
        .setDataType("json") // send and read json data
        .setData($$("foo: bar")); // Your JavaScriptObject
      
      System.out.println(rq.toJson());
      
      // GQuery Ajax return a Promise
      Ajax.ajax(rq)
        .done(new Function() {
          public void f() {
            // You can inspect arguments with this
            System.out.println(dumpArguments());
    
            // Create the bean, and wrap the json object read
            MyBean b = GWT.create(MyBean.class);
            b.load(arguments(0));
    
            // toString in JsonBuilder returns the json string
            System.out.println(b.toString());
          }
        })
        .fail(new Function() {
          public void f() {
    
          }
        });
    }
    
  
}
