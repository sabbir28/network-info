import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkTypeDetector {

    private Context context;

    public NetworkTypeDetector(Context context) {
        this.context = context;
    }

    /**
     * Detect the current network type.
     * @return The network type ('1G', '2G', '3G', '4G', '5G', 'Unknown', 'Offline')
     */
    public String getNetworkType() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return "Unknown";
        }

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "Offline";
        }

        int type = networkInfo.getType();
        int subtype = networkInfo.getSubtype();

        switch (type) {
            case ConnectivityManager.TYPE_WIFI:
                return "Wi-Fi";
            case ConnectivityManager.TYPE_MOBILE:
                switch (subtype) {
                    case NetworkInfo.TYPE_GPRS:
                    case NetworkInfo.TYPE_EDGE:
                    case NetworkInfo.TYPE_CDMA:
                    case NetworkInfo.TYPE_1xRTT:
                    case NetworkInfo.TYPE_IDEN:
                        return "2G";
                    case NetworkInfo.TYPE_UMTS:
                    case NetworkInfo.TYPE_EVDO_0:
                    case NetworkInfo.TYPE_EVDO_A:
                    case NetworkInfo.TYPE_HSDPA:
                    case NetworkInfo.TYPE_HSUPA:
                    case NetworkInfo.TYPE_HSPA:
                    case NetworkInfo.TYPE_EVDO_B:
                    case NetworkInfo.TYPE_EHRPD:
                    case NetworkInfo.TYPE_HSPAP:
                        return "3G";
                    case NetworkInfo.TYPE_LTE:
                        return "4G";
                    case NetworkInfo.TYPE_NR:
                        return "5G";
                    default:
                        return "Unknown";
                }
            default:
                return "Unknown";
        }
    }

    /**
     * Detect the connection type (mobile data or Wi-Fi).
     * @return The connection type ('Mobile Data', 'Wi-Fi', 'Unknown')
     */
    public String getConnectionType() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return "Unknown";
        }

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "Offline";
        }

        int type = networkInfo.getType();

        switch (type) {
            case ConnectivityManager.TYPE_WIFI:
                return "Wi-Fi";
            case ConnectivityManager.TYPE_MOBILE:
                return "Mobile Data";
            default:
                return "Unknown";
        }
    }

    /**
     * Get detailed network information.
     * @return An object containing both the network type and connection type.
     */
    public NetworkDetails getNetworkDetails() {
        return new NetworkDetails(getNetworkType(), getConnectionType());
    }

    public static class NetworkDetails {
        private String networkType;
        private String connectionType;

        public NetworkDetails(String networkType, String connectionType) {
            this.networkType = networkType;
            this.connectionType = connectionType;
        }

        public String getNetworkType() {
            return networkType;
        }

        public String getConnectionType() {
            return connectionType;
        }

        @Override
        public String toString() {
            return "NetworkDetails{" +
                    "networkType='" + networkType + '\'' +
                    ", connectionType='" + connectionType + '\'' +
                    '}';
        }
    }
}
