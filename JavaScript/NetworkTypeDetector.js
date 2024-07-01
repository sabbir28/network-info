/**
 * NetworkTypeDetector Library
 * Version: 1.1.2
 * Author: Md. Sabbir Hoshen Howlader
 * 
 * This library detects the network type (1G, 2G, 3G, 4G, 5G) and whether the connection is mobile data or Wi-Fi.
 * It works in any browser that supports the navigator.connection API.
 */

(function(global) {
    // Define the NetworkTypeDetector constructor
    function NetworkTypeDetector() {}

    /**
     * Detect the current network type.
     * @returns {string} The network type ('1G', '2G', '3G', '4G', '5G', 'Unknown', 'Offline')
     */
    NetworkTypeDetector.prototype.getNetworkType = function() {
        if (!navigator.connection) {
            return 'Unknown';
        }

        var connection = navigator.connection || navigator.mozConnection || navigator.webkitConnection;
        var type = connection.effectiveType || connection.type;

        switch (type) {
            case 'slow-2g':
                return '1G';
            case '2g':
                return '2G';
            case '3g':
                return '3G';
            case '4g':
                return '4G';
            case '5g':
                return '5G';
            case 'none':
                return 'Offline';
            default:
                return 'Unknown';
        }
    };

    /**
     * Detect the connection type (mobile data or Wi-Fi).
     * @returns {string} The connection type ('Mobile Data', 'Wi-Fi', 'Unknown')
     */
    NetworkTypeDetector.prototype.getConnectionType = function() {
        if (!navigator.connection) {
            return 'Unknown';
        }

        var connection = navigator.connection || navigator.mozConnection || navigator.webkitConnection;
        var type = connection.type;

        switch (type) {
            case 'cellular':
                return 'Mobile Data';
            case 'wifi':
                return 'Wi-Fi';
            case 'none':
                return 'Offline';
            default:
                return 'Unknown';
        }
    };

    /**
     * Get detailed network information.
     * @returns {object} An object containing both the network type and connection type.
     */
    NetworkTypeDetector.prototype.getNetworkDetails = function() {
        return {
            networkType: this.getNetworkType(),
            connectionType: this.getConnectionType()
        };
    };

    // Expose the NetworkTypeDetector to the global object
    if (typeof module !== 'undefined' && typeof module.exports !== 'undefined') {
        module.exports = NetworkTypeDetector;
    } else {
        global.NetworkTypeDetector = NetworkTypeDetector;
    }
})(this);

// Example usage:
// var detector = new NetworkTypeDetector();
// console.log(detector.getNetworkDetails());
