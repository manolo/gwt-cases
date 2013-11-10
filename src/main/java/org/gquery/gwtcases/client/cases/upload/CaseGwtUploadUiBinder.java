package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class CaseGwtUploadUiBinder extends Composite implements EntryPoint{

  private static CaseGwtUploadUiBinderUiBinder uiBinder = GWT.create(CaseGwtUploadUiBinderUiBinder.class);

  interface CaseGwtUploadUiBinderUiBinder extends UiBinder<Widget, CaseGwtUploadUiBinder> {}

  public CaseGwtUploadUiBinder() {
    initWidget(uiBinder.createAndBindUi(this));
    RootPanel.get().add(this);
  }

  @UiField SingleUploader uploader;


  public void onModuleLoad() {
  }

}
