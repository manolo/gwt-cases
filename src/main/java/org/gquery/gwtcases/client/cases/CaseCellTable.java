package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
/**
 * SinkEvents CellTable
 * http://stackoverflow.com/questions/15833985/gwt-sinkevents-in-hosted-mode
 * 
 * Enhance CellTable with GQuery
 * http://stackoverflow.com/questions/15841066/in-gwt-how-to-add-a-row-on-top-of-header-of-celltable
 */
public class CaseCellTable implements EntryPoint {
  
  public class Tooltip extends PopupPanel {
    
    Grid g = new Grid(5, 5);
    VerticalPanel v = new VerticalPanel();
    Label l = new Label();

    public Tooltip() {
      setWidget(v);
      v.add(l);
      v.add(g);
    }

    public Grid getGrid() {
      return g;
    }

    public void setHTML(String title) {
      l.setText(title);
    }
  }
  
  
  public class MyCellTable<T> extends CellTable<T> {
    private Tooltip popup = new Tooltip();
    private List<String> tooltipHiddenColumn = new ArrayList<String>();
    private boolean showTooltip;

    public MyCellTable() {
        super();
        sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
    }

    @Override
    public void onBrowserEvent2(Event event) {
        super.onBrowserEvent2(event);
        if (isShowTooltip()) {
            switch (DOM.eventGetType(event)) {
                case Event.ONMOUSEOUT: {
                    popup.hide(true);
                    break;
                }
                case Event.ONMOUSEOVER: {
                    popup.setAutoHideEnabled(true);
                    showToolTip(event);
                    break;
                }
            }
        }
    }

    private void showToolTip(final Event event) {
        EventTarget eventTarget = event.getEventTarget();
        if (!Element.is(eventTarget)) {
            return;
        }
        final Element target = event.getEventTarget().cast();
        // Find the cell where the event occurred.
        TableCellElement tableCell = findNearestParentCell(target);
        if (tableCell == null) {
            return;
        }
        Element trElem = tableCell.getParentElement();
        if (trElem == null) {
            return;
        }
        TableRowElement tr = TableRowElement.as(trElem);
        Element sectionElem = tr.getParentElement();
        if (sectionElem == null) {
            return;
        }
        TableSectionElement section = TableSectionElement.as(sectionElem);
        if (section == getTableHeadElement()) {
            return;
        }
        NodeList<TableCellElement> cellElements = tr.getCells().cast();
        NodeList<TableCellElement> headers = getTableHeadElement().getRows().getItem(0).getCells().cast();
        popup.getGrid().clear(true);
        popup.getGrid().resizeRows(cellElements.getLength());
        for (int i = 0; i < cellElements.getLength(); i++) {
            if (getTooltipHiddenColumn().indexOf(headers.getItem(i).getInnerHTML()) == -1) {
                TableCellElement tst = TableCellElement.as(cellElements.getItem(i));
                popup.getGrid().setHTML(i, 0, headers.getItem(i).getInnerHTML());
                popup.getGrid().setHTML(i, 1, tst.getInnerHTML());
            }
        }
        // Here the constant values are used to give some gap between mouse pointer and popup panel
        popup.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
            public void setPosition(int offsetWidth, int offsetHeight) {
                int left = event.getClientX() + 5;
                int top = event.getClientY() + 5;
                if ((offsetHeight + top + 20) > Window.getClientHeight()) {
                    top = top - offsetHeight - 10;
                }
                popup.setPopupPosition(left, top);
            }
        });
        popup.show();
    }

    private TableCellElement findNearestParentCell(Element elem) {
        while ((elem != null) && (elem != getElement())) {
            String tagName = elem.getTagName();
            if ("td".equalsIgnoreCase(tagName) || "th".equalsIgnoreCase(tagName)) {
                return elem.cast();
            }
            elem = elem.getParentElement();
        }
        return null;
    }

    /**
     * Specify Name of the column's which is not to shown in the Tooltip
     */
    public List<String> getTooltipHiddenColumn() {
        return tooltipHiddenColumn;
    }

    /**
     * Set title to tooltip
     * 
     * @param title
     */
    public void setTooltipTitle(String title) {
        popup.setHTML(title);
    }

    public boolean isShowTooltip() {
        return showTooltip;
    }

    public void setShowTooltip(boolean showTooltip) {
        this.showTooltip = showTooltip;
    }
}
  
  
  
  private static class Contact {
    private final String address;
    private final String name;

    public Contact(String name, String address) {
      this.name = name;
      this.address = address;
    }
  }

  // The list of data to display.
  private static List<Contact> CONTACTS = Arrays.asList(new Contact("John",
      "123 Fourth Road"), new Contact("Mary", "222 Lancer Lane"), new Contact(
      "Zander", "94 Road Street"));

  public void onModuleLoad() {

    // Create a CellTable.
    final MyCellTable<Contact> celltable = new MyCellTable<Contact>();
    celltable.setShowTooltip(true);

    // Create name column.
    TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
      @Override
      public String getValue(Contact contact) {
        return contact.name;
      }
    };

    // Make the name column sortable.
    nameColumn.setSortable(true);

    // Create address column.
    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
      @Override
      public String getValue(Contact contact) {
        return contact.address;
      }
    };
    

    // Add the columns.
    celltable.addColumn(nameColumn, "Name");
    celltable.addColumn(addressColumn, "Address");

    // Create a data provider.
    ListDataProvider<Contact> dataProvider = new ListDataProvider<Contact>();

    // Connect the table to the data provider.
    dataProvider.addDataDisplay(celltable);

    // Add the data to the data provider, which automatically pushes it to the
    // widget.
    List<Contact> list = dataProvider.getList();
    for (Contact contact : CONTACTS) {
      list.add(contact);
    }

    // Add a ColumnSortEvent.ListHandler to connect sorting to the
    // java.util.List.
//    ColumnSortEvent.ListHandler<Contact> columnSortHandler = new ColumnSortEvent.ListHandler<Tester.Contact>(list);
//    columnSortHandler.setComparator(nameColumn,
//        new Comparator<Tester.Contact>() {
//          public int compare(Contact o1, Contact o2) {
//            if (o1 == o2) {
//              return 0;
//            }
//
//            // Compare the name columns.
//            if (o1 != null) {
//              return (o2 != null) ? o1.name.compareTo(o2.name) : 1;
//            }
//            return -1;
//          }
//        });
//    table.addColumnSortHandler(columnSortHandler);

    // We know that the data is sorted alphabetically by default.
    celltable.getColumnSortList().push(nameColumn);

    // Add it to the root panel.
    RootPanel.get().add(celltable);
    System.out.println($("th > div", celltable).size() + " " + $("th div", celltable).text());
    
//    final CellTable<MyObject> celltable;
//    [...]

    
    $(celltable).delay(0, new Function(){
       public void f() {
         $("th", celltable).prepend($("<div class='mypanel' style='height: 40px'/>"));
         
         
         GQuery panels = $(".mypanel", celltable).as(Widgets).panel();
         
         List<HTMLPanel> list = panels.widgets(HTMLPanel.class);
         for (int i = 0; i < list.size(); i++) {
           list.get(i).add(new Button("Button: " + i));
         }
       }
    }).delay(2000, new Function(){public void f() {
      RootPanel.get().add(celltable);
    }});
    
  }  

}
