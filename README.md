# Project README: Encoding and Persistent Storage of Graphical Data

This project focuses on the efficient encoding of geometric coordinates and color information into single integer values for optimized storage and processing.

---

## 🛠 Project Components

The core logic is implemented in the `PositionAndColor.java` class, which handles bitwise manipulation to compress and decompress graphical data.

### 1. Data Encoding (`encode` method)

The `encode` method packs two coordinates (x, y) and one color object into a single 32-bit integer:

* **X-Coordinate**: Retains the lowest 12 bits using the mask `0xFFF`.
* **Y-Coordinate**: Retains the lowest 12 bits, shifted left by 12 positions, and combined using a bitwise OR operation.
* **Color Data**: A byte representing the color is masked with `0xFF`, shifted left by 24 bits, and placed in the highest byte of the integer.

### 2. Data Decoding (`decode` method)

The `decode` method reverses the encoding process to retrieve the original values:

* **Extraction**: Uses bit shifting and masking to separate the x-coordinate, y-coordinate, and color byte.
* **Storage**: Returns an integer array `res` where `res[0]` is x, `res[1]` is y, and `res[2]` is the color byte.

### 3. Color Transformation (`byteToColor` method)

This method decompresses the color byte back into a full RGB `Color` object:

* **Red Component**: Extracts 3 bits (shifted right by 5, masked with `0b111`) and rescales them to the 0-255 range by multiplying by 255 and dividing by 7.
* **Green Component**: Extracts 3 bits (shifted right by 2, masked with `0b111`) and rescales them similarly to the red component.
* **Blue Component**: Extracts the 2 least significant bits (masked with `0b11`) and rescales them by multiplying by 255 and dividing by 3.

---

## 🚀 How to Use

### Setup

1. **Class Creation**: Implement the `PositionAndColor` class with the described static methods.
2. **Dependencies**: Ensure the `java.awt.Color` package is imported for color object handling.

### Implementation Workflow

1. **Encode Data**: Call `PositionAndColor.encode(x, y, color)` to compress your graphical data for persistent storage.
2. **Decode Data**: Use `PositionAndColor.decode(encodedValue)` to retrieve coordinates and the color byte.
3. **Restore Color**: Pass the extracted color byte to `PositionAndColor.byteToColor(colorByte)` to get the final `Color` object.

### Testing

* Verify the implementation by running the provided unit tests in `PositionAndColorTest.java` to ensure no data is lost during the compression/decompression cycles.
