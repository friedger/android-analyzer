/**
 * 
 */
package org.androidanalyzer.plugins.dummy;

import org.androidanalyzer.Constants;
import org.androidanalyzer.core.Data;
import org.androidanalyzer.core.IAnalyzerPlugin;
import org.androidanalyzer.core.IPluginRegistry;
import org.androidanalyzer.core.utils.Logger;
import org.androidanalyzer.plugins.AbstractPlugin;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author k.raev
 */
public class DummyPlugin extends AbstractPlugin {

  private static final String NAME = "Dummy plugin";
  private static final String TAG = "Analyzer-DisplayPlugin";

  /**
   * @return
   */
  private Data returnDummyData() {
    Data dummy = new Data();
    try {
      dummy.setName("DummyInfo");
      Data dummyInfo = new Data();
      dummyInfo.setName("Info about nothing");
      dummyInfo.setValue("no info here");
      dummyInfo.setValueType(Constants.NODE_VALUE_TYPE_STRING);
      dummy.setValue(dummyInfo);
      dummy.setValueType(Constants.NODE_VALUE_TYPE_DATA);
      try {
        Thread.currentThread().sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    return dummy;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.androidanalyzer.plugins.AbstractPlugin#getPluginName
   * ()
   */
  @Override
  public String getPluginName() {
    return NAME;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.androidanalyzer.plugins.AbstractPlugin#getPluginTimeout
   * ()
   */
  @Override
  public long getPluginTimeout() {
    return 10000;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.androidanalyzer.plugins.AbstractPlugin#getPluginVersion
   * ()
   */
  @Override
  public String getPluginVersion() {
    return "1.0.0";
  }

  /*
   * (non-Javadoc)
   * @see org.androidanalyzer.plugins.AbstractPlugin#
   * getPluginClassName()
   */
  @Override
  protected String getPluginClassName() {
    return this.getClass().getName();
  }

  /*
   * (non-Javadoc)
   * @see
   * org.androidanalyzer.plugins.AbstractPlugin#getData()
   */
  @Override
  protected Data getData() {
    return returnDummyData();
  }

  /*
   * (non-Javadoc)
   * @see org.androidanalyzer.plugins.AbstractPlugin#
   * stopDataCollection()
   */
  @Override
  protected void stopDataCollection() {
  }

}
