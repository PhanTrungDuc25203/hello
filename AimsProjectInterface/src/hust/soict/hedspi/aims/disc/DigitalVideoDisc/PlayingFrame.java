package hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayingFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
    private JButton pauseButton;
    private JButton resumeButton;
    private AtomicBoolean paused;

    public PlayingFrame(String songInfo, int progressBarRunTimeInSeconds) {
        setTitle("Now Playing");
        getContentPane().setLayout(new BorderLayout());

        progressBar = new JProgressBar(0, 100);

        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        JLabel playingLabel = new JLabel("Playing: " + songInfo);
        infoPanel.add(playingLabel);

        JLabel remainingTimeLabel = new JLabel("Remaining Time: " + formatTime(progressBarRunTimeInSeconds));
        infoPanel.add(remainingTimeLabel);

        infoPanel.add(progressBar);

        getContentPane().add(infoPanel, BorderLayout.CENTER);

        paused = new AtomicBoolean(false);

        pauseButton = new JButton("Pause");
        resumeButton = new JButton("Resume");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(pauseButton);
        buttonPanel.add(resumeButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        buttonPanel.add(cancelButton);

        pauseButton.addActionListener(e -> {
            paused.set(true);
            pauseButton.setEnabled(false);
            resumeButton.setEnabled(true);
        });

        resumeButton.addActionListener(e -> {
            paused.set(false);
            pauseButton.setEnabled(true);
            resumeButton.setEnabled(false);
        });

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(314, 149);
        setLocationRelativeTo(null);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int totalTimeSteps = 100;
                int timeIncrement = progressBarRunTimeInSeconds / totalTimeSteps;

                for (int i = 0; i <= totalTimeSteps; i++) {
                    while (paused.get()) {
                        Thread.sleep(100);
                    }

                    progressBar.setValue(i);

                    int remainingTime = progressBarRunTimeInSeconds - i * timeIncrement;
                    remainingTimeLabel.setText("Remaining Time: " + formatTime(remainingTime));

                    Thread.sleep(timeIncrement * 100);
                }
                return null;
            }

            @Override
            protected void done() {
                dispose();  // Đóng JFrame khi công việc hoàn thành
            }
        };

        worker.execute();
    }

    private String formatTime(int seconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            PlayingFrame playingFrame = new PlayingFrame("Song Title", 60);
//            playingFrame.setVisible(true);
//        });
//    }
}
