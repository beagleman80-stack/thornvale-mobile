# Thornvale Mobile 1.0 — Android Studio project

This is **Android project source, not a compiled APK**. The current environment has no Android SDK or Gradle installation, so it cannot build or device-test the APK here.

## Before building — required Three.js dependency

The original Thornvale 3.7.2 package does not include `game/vendor/three.min.js` (the desktop installer generates it). **You must bundle Three.js r128 first**:

1. Install Node.js on your computer.
2. Open a terminal in this project folder and run `npm install --no-save three@0.128.0`.
3. Copy `node_modules/three/build/three.min.js` to `app/src/main/assets/game/vendor/three.min.js`.
4. Confirm the file exists before proceeding. Without it, the game will not render.

## Build an APK

1. Install Android Studio and its Android SDK (API 35).
2. Open this project directory in Android Studio.
3. Let Gradle sync/download the Android Gradle plugin and AndroidX WebKit.
4. Select Build > Build Bundle(s) / APK(s) > Build APK(s).
5. Find `app/build/outputs/apk/debug/app-debug.apk` and copy it to your Android phone.
6. Allow installation from that source if Android asks.

The app uses a local HTTPS asset origin (`appassets.androidplatform.net` intercepted inside the WebView) so browser localStorage can persist. No game-server connection is required. There is no Windows/mobile save synchronization. This first version adds mobile-oriented CSS and save-on-background, but full touch usability and performance **are not yet device-tested**. Keep Windows and Android saves separate. Do not uninstall the app before exporting any progress; uninstalling normally removes app data.

The original game's Three.js runtime is CPU/GPU intensive; start with low settings. Android System WebView must support WebGL.
