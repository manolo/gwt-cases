package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$$;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.builders.JsonBuilder;

public class CaseJson implements EntryPoint {
  
  String json = "{\"testLong\":\"3234345\",\"testDate\":\"2013-04-11T06:09:36.489Z\",\"testString\":\"sathya\",\"testDouble\":\"123.98\",\"testInt\":\"123\"}";

  @SuppressWarnings("unused")
  public void onModuleLoad() {
    System.out.println(json.replaceAll(":\"(-?\\d[\\d\\.]*|null|false|true)\"(,|$)", ":$1$2"));
    System.out.println(json.replaceAll("([\\d\\-]+)T([\\d:]+)\\.\\d+Z", "$1 $2"));
    
    {
      Properties p = $$(json);
      
      long l = p.<Number>get("testLong").longValue();
      double d = p.<Number>get("testDouble").doubleValue();
      int i = p.<Number>get("testInt").intValue();
      String s = p.get("testString");
      Date dat = new Date((long)JsDate.parse(p.<String>get("testDate")));
    }
    
    {
      MyBean b = GWT.create(MyBean.class);
      b.parse(json, true);
          
      long l = b.getTestLong();
      double d = b.getTestDouble();
      int i = b.getTestInt();
      String s = b.getTestString();
      Date dat = new Date((long)JsDate.parse(b.getTestDate()));
    }
  }

  static interface MyBean extends JsonBuilder {
    Long getTestLong();
    Double getTestDouble();
    Integer getTestInt();
    String getTestString();
    String getTestDate();
  }
}
