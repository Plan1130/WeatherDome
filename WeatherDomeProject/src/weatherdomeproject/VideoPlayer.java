/*
 * WeatherDome!
 */
package weatherdomeproject;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.x.XFullScreenStrategy;
import uk.co.caprica.vlcj.test.VlcjTest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author FlorianF
 */
public class VideoPlayer extends VlcjTest {

    private JFrame frame;

    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    @SuppressWarnings("serial")
    public VideoPlayer() {
        frame = new JFrame("LibX11 Full Screen Strategy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setSize(1200, 800);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {
            @Override
            protected FullScreenStrategy onGetFullScreenStrategy() {
                return new XFullScreenStrategy(frame);
            }
        };

        frame.setContentPane(mediaPlayerComponent);

        frame.setVisible(true);
    }

    protected void start(String mrl) {
        mediaPlayerComponent.getMediaPlayer().playMedia(mrl);
        mediaPlayerComponent.getMediaPlayer().setFullScreen(true);
    }
}