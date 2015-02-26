import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;

import uk.co.jatra.asunittest.MainActivity;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void simple() {
        assertThat(6/2)
                .isEqualTo(3);
    }

    @Test
    public void shouldHaveTitle() {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class).create();
        MainActivity activity = controller.get();
        String title = activity.getTitle().toString();
        assertThat(title)
                .isEqualTo("Hello world!");
    }
}
