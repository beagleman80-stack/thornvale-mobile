# Thornvale Mobile 1.0 — GitHub APK Builder

This ZIP is **source code**, not an APK. GitHub Actions will build a debug APK after upload.

## Upload using GitHub (PC recommended)

1. Sign in to https://github.com/beagleman80-stack and select **New repository**. Name it `thornvale-mobile`. Select **Private** to keep game source private; leave README/gitignore/license initialization unchecked.
2. Extract this ZIP to a folder on your PC. IMPORTANT: Upload the **contents** of the extracted folder to the repository root, including the hidden `.github/workflows/build-apk.yml` file. GitHub's browser file upload may not accept hidden folders reliably. Using GitHub Desktop or Git is recommended:

   ```bash
   git init
   git add .
   git commit -m "Thornvale Android APK builder"
   git branch -M main
   git remote add origin https://github.com/beagleman80-stack/thornvale-mobile.git
   git push -u origin main
   ```

   If Git prompts you to authenticate, follow its GitHub sign-in flow.
3. Open the repository's **Actions** tab. If prompted, enable Actions. Open **Build Thornvale Android APK** and choose **Run workflow** if it did not start automatically.
4. When the run succeeds, open the run page, scroll to **Artifacts**, and download `Thornvale-Mobile-1.0-APK`. Extract the downloaded artifact ZIP to get `app-debug.apk`.
5. On your REDMAGIC Android phone, open the APK file and allow installation from your file manager/browser if prompted.

## Limitations and precautions

- This is a **debug-signed** APK for private testing, not a Play Store release.
- The workflow has not been run in GitHub or on a phone. Build success and game behavior are not yet confirmed.
- The initial mobile version may still need touch-control and performance adjustments.
- Mobile progress stays on the phone; Windows saves do not automatically transfer. Uninstalling the app can delete progress. Back up character data before uninstalling.
- Future APK updates must use the same application ID and signing certificate to install over an existing app. GitHub's default debug keystore can change between builds; preserve the keystore before relying on in-place updates. For now, treat this as an initial test build.
