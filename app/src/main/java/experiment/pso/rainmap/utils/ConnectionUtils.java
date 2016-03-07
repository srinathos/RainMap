package experiment.pso.rainmap.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by vishal on 30/12/15.
 */
public class ConnectionUtils {

    Context context;
    public static String TAG_APP_NAME="RainMap";

    public ConnectionUtils(Context context) {
        this.context = context;
    }

    public static boolean checkConnection(Context context) {
        final ConnectivityManager ComMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo nwInfo = ComMgr.getActiveNetworkInfo();
        if (nwInfo != null && nwInfo.isConnected())
            return true;
        else
            return false;
    }

    public static ContentValues getConnectedTowerData(Context context){
        return null;
    }

    public static void DEBUG_printNeighbouringCellTowers(Context context){
        TelephonyManager telephonyManager=  (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        ArrayList<CellInfo> info=(ArrayList)telephonyManager.getAllCellInfo();
        for(int i=0;i<info.size();i++){
            CellInfo object=info.get(i);
            Log.d(TAG_APP_NAME+" CELL INFO",object.toString());
        }

    }
}
