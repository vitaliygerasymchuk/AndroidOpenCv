package oprncv.android.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

public class OpenCvInitializer {

    public void initOpenCV(@NonNull Context context, @NonNull BaseLoaderCallback callback) {
        if (!OpenCVLoader.initDebug()) {
            Log.d("OpenCvInitializer", "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_4_0, context, callback);
        } else {
            Log.d("OpenCvInitializer", "OpenCV library found inside package. Using it!");
            callback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
}
