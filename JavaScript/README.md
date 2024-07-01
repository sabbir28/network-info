# NetworkTypeDetector Library

## Version: 1.1.1

**Author:** Md. Sabbir Hoshen Howlader

The `NetworkTypeDetector` library detects the network type (1G, 2G, 3G, 4G, 5G) and whether the connection is mobile data or Wi-Fi. It works in any browser that supports the `navigator.connection` API.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API](#api)
  - [getNetworkType](#getnetworktype)
  - [getConnectionType](#getconnectiontype)
  - [getNetworkDetails](#getnetworkdetails)
- [Example](#example)
- [License](#license)

## Installation

You can include the `NetworkTypeDetector` library in your project by downloading the script and adding it to your HTML file:

```html
<script src="https://github.com/sabbir28/network-info/blob/main/JavaScript/NetworkTypeDetector.js"></script>
```

Alternatively, you can install it via npm if available:

```bash
npm install network-type-detector
```

## Usage

To use the `NetworkTypeDetector`, create an instance of the class and call its methods to get the network details.

```javascript
var detector = new NetworkTypeDetector();
console.log(detector.getNetworkDetails());
```

## API

### `getNetworkType()`

Detect the current network type.

**Returns:**

- `{string}`: The network type ('1G', '2G', '3G', '4G', '5G', 'Unknown', 'Offline').

### `getConnectionType()`

Detect the connection type (mobile data or Wi-Fi).

**Returns:**

- `{string}`: The connection type ('Mobile Data', 'Wi-Fi', 'Unknown').

### `getNetworkDetails()`

Get detailed network information.

**Returns:**

- `{object}`: An object containing both the network type and connection type.

```javascript
{
    networkType: '4G',
    connectionType: 'Wi-Fi'
}
```

## Example

Here is an example of how to use the `NetworkTypeDetector`:

```javascript
var detector = new NetworkTypeDetector();
console.log(detector.getNetworkDetails());
```

## License

This project is licensed under the MIT License.
```

Feel free to customize it further based on your needs.
