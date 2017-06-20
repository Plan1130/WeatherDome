/*
 * WeatherDome!
 */
package weatherdomeproject;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class VideoPlayer {

    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    //This is the path for libvlc.dll
    static String VLCLIBPATH = "C:\\Program Files\\VideoLAN\\VLC";

    public VideoPlayer(String name) {
        boolean found = new NativeDiscovery().discover();
        System.out.println(found);
        System.out.println(LibVlc.INSTANCE.libvlc_get_version());
        
        //MAXIMIZE TO SCREEN
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame(name);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

        frame.setContentPane(mediaPlayerComponent);

        frame.setLocation(0, 0);
        frame.setSize(screenSize.width, screenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia("src/video/Yee.mp4");//Movie name which want to play
    }
    
    public void ChangeVideo() {
        mediaPlayerComponent.getMediaPlayer().playMedia("src/video/WizardCat.mp4");//Movie name which want to play
    }
}