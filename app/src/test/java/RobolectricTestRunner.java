import org.robolectric.AndroidManifest;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;

/**
 * Created by tim on 19/02/15.
 */
public class RobolectricTestRunner extends org.robolectric.RobolectricTestRunner {
    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC = 18;

    public RobolectricTestRunner(Class<?> testClass) throws org.junit.runners.model.InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {

        String mainPath = "src/main";
        if (!new File(mainPath).exists()) {
            mainPath = "app/" + mainPath;
        }

        String manifestPath = mainPath+"/AndroidManifest.xml";
        String resourcePath = mainPath+"/res";
        return new AndroidManifest(Fs.fileFromPath(manifestPath), Fs.fileFromPath(resourcePath)) {
            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }
        };
    }
}