# Android Painter App

Welcome to the Android Painter App! This application provides users with a canvas to express their creativity by painting with different colors and brush sizes and shapes. Users can start with a blank canvas, or draw on images from their gallery. With a user-friendly interface and a range of features, this app makes digital painting easy and enjoyable. To draw on an image, navigate to the image on your files, and open with FingerPainter.

This app follows professional standards, utilizing the Model-View-ViewModel (MVVM) architectural pattern and Data Binding to maintain a clean and efficient codebase.

## Features

### 1. Main Painting Activity
- This is the core feature of the app, where users can paint onto a blank canvas.
- Users can select from a variety of colors, brush sizes, and shapes to create their artwork.

### 2. Color Selection Activity
- A second activity is dedicated to color selection, allowing users to choose from a palette of colors.
- The currently chosen color is displayed within this activity.

### 3. Brush Selection Activity
- The third activity is designed for brush customization, where users can select the shape and size of their brush.
- The currently chosen brush shape and size are displayed in this activity.

### 4. State Persistence
- The app maintains the selected color and brush settings even when the device's orientation changes (e.g., phone rotation).
- It also preserves the chosen settings when switching to other applications (e.g., receiving a phone call), ensuring a seamless painting experience.

### 5. Open and Paint
- Users can open images from their device's storage and start painting on top of them. This feature allows users to add their creative touch to existing images.
