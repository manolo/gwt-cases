package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Window;

public class CaseNode implements EntryPoint {

  public void onModuleLoad() {
    $("body > :not(iframe)").remove();
    
    $("<button>click</button>").appendTo(document).click(new Function() {
      public void f() {
        createNodes();
      }
    });
    
    $("<button>click</button>").appendTo(document).click(new Function() {
      public void f() {
        Window.alert("REMOVE-JAVA");
        Document.get().getBody().removeAllChildrenJava();
        if (Document.get().getBody().getLastChild() == null) {
          Window.alert("DONE-JAVA");
        } else {
          Document.get().getBody().removeChild(null);
        }
      }
    });
    
    $("<button>click</button>").appendTo(document).click(new Function() {
      public void f() {
        Window.alert("REMOVE-JNSI");
        Document.get().getBody().removeAllChildrenJsni();
        if (Document.get().getBody().getLastChild() == null) {
          Window.alert("DONE-JSNI");
        } else {
          Document.get().getBody().removeChild(null);
        }
      }
    });
    
    Element e = $("<div id=''>a</div>").appendTo(document).get(0);
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }
    if (e.getLastChild() != null) {
      e = $("<div id=''>a</div>").appendTo(document).get(0);
    }


    
    
  }
  
  private void createNodes() {
    for (int i = 0; i < 300; i++) {
      $("<div id='" + i + "'>" + i + "</div>").appendTo(document);
    }
    
  }
  
}
