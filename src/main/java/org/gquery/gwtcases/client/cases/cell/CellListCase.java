package org.gquery.gwtcases.client.cases.cell;

import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;
/**
 */
public class CellListCase implements EntryPoint {
  
  static String[] a = {"manolo", "jose", "carlos", "carmen", "javi", "ismael"};
  
  public static class IPartition {
    
    static int c = 0;
    public IPartition() {
      customerKey = "";
      for (int i = 0; i < 10; i++) {
        customerKey += (char)(Random.nextBoolean() ? '0' + Random.nextInt(10) : 'A' + Random.nextInt(25));
      }
      customer = a[c++%a.length] + c;
      token = customer.substring(0,3).toUpperCase();
    }
    public String getCustomer() {
      return customer;
    }
    public void setCustomer(String customer) {
      this.customer = customer;
    }
    public String getCustomerKey() {
      return customerKey;
    }
    public void setCustomerKey(String customerKey) {
      this.customerKey = customerKey;
    }
    public String getToken() {
      return token;
    }
    public void setToken(String token) {
      this.token = token;
    }
    String customer;
    String customerKey;
    String token;
  }
  
  private class PartitionColumn extends Column<IPartition, String> implements Comparator<IPartition> {
    public String label;
    public PartitionColumn(String name, int pct, DataGrid<IPartition> grid, ListHandler<IPartition> sorter) {
      super(new TextCell());
      label = name;
      sorter.setComparator(this, this);
      setSortable(true);
      grid.addColumn(this, name);
      grid.setColumnWidth(this, pct, Unit.PCT);
    }
    public int compare(IPartition v1, IPartition v2) {
      return getValue(v1).compareTo(getValue(v2));
    }
    public String getValue(IPartition o) {
      String r = null;
      if ("customer".equalsIgnoreCase(label)) {
        r = o.getCustomer();
      } else if ("key".equalsIgnoreCase(label)) {
        r = o.getCustomerKey();
      } else if ("token".equalsIgnoreCase(label)) {
        r = o.getToken();
      }
      return r != null ? r : "";
    }
  }
  
  private ListDataProvider<IPartition> dataProvider = new ListDataProvider<IPartition>();
  DataGrid<IPartition> dataGrid = new DataGrid<IPartition>();
  SimplePager pager = new SimplePager();
  
  public void onModuleLoad() {
    List<IPartition> l = dataProvider.getList();
    for (int i = 0; i < 100; i++) {
      l.add(new IPartition());
    }
    
    dataProvider.addDataDisplay(dataGrid);
    pager.setDisplay(dataGrid);
    dataGrid.setPageSize(17);
    
    ListHandler<IPartition> sortHandler = new ListHandler<IPartition>(dataProvider.getList());
    dataGrid.addColumnSortHandler(sortHandler);
    
    new PartitionColumn("Customer", 120, dataGrid, sortHandler);
    new PartitionColumn("Key", 60, dataGrid, sortHandler);
    new PartitionColumn("Token", 10, dataGrid, sortHandler);
    
    
    DockLayoutPanel p = new DockLayoutPanel(Unit.PX);
    p.addSouth(pager, 40);
    p.add(dataGrid);
    RootLayoutPanel.get().add(p);
  }  

}
