package org.gaeproxy;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;

public class InnerSocketBuilder {

  private String proxyHost = "127.0.0.1";
  private int proxyPort = 1053;

  private Socket innerSocket = null;

  private boolean isConnected = false;

  private final String TAG = "CMWRAP->InnerSocketBuilder";

  /**
   * 寤虹珛缁忕敱浠ｇ悊鏈嶅姟鍣ㄨ嚦鐩爣鏈嶅姟鍣ㄧ殑杩炴帴
   *
   * @param proxyHost 浠ｇ悊鏈嶅姟鍣ㄥ湴鍧�
   * @param proxyPort 浠ｇ悊鏈嶅姟鍣ㄧ鍙�
   * @param target 鐩爣鏈嶅姟鍣�
   */
  public InnerSocketBuilder(String proxyHost, int proxyPort, String target) {
    this.proxyHost = proxyHost;
    this.proxyPort = proxyPort;

    connect();
  }

  private void connect() {

    // starTime = System.currentTimeMillis();
    Log.v(TAG, "寤虹珛閫氶亾");

    try {
      innerSocket = new Socket(proxyHost, proxyPort);
      innerSocket.setKeepAlive(true);
      innerSocket.setSoTimeout(60 * 1000);
      isConnected = true;
    } catch (IOException e) {
      Log.e(TAG, "寤虹珛闅ч亾澶辫触锛�" + e.getLocalizedMessage());
    }
  }

  public Socket getSocket() {
    return innerSocket;
  }

  public boolean isConnected() {
    return this.isConnected;
  }
}
