package hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class CDPlayer extends JFrame {
    private List<SongPlayerPanel> songPlayers;
    private SongPlayerPanel currentSongPlayer;

    public CDPlayer(List<String> songTitles, List<Integer> songDurations) {
        setTitle("Multi Song Player");
        getContentPane().setLayout(new BorderLayout());

        songPlayers = new ArrayList<>();

        for (int i = 0; i < songTitles.size(); i++) {
            SongPlayerPanel songPlayerPanel = new SongPlayerPanel(songTitles.get(i), songDurations.get(i));
            songPlayers.add(songPlayerPanel);
        }

        JTabbedPane tabbedPane = new JTabbedPane();
        for (int i = 0; i < songPlayers.size(); i++) {
            tabbedPane.addTab("Song " + (i + 1), null, songPlayers.get(i), "Play " + songTitles.get(i));
        }

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        setSize(400, 172);
        setLocationRelativeTo(null);
    }

    class SongPlayerPanel extends JPanel {
        private JProgressBar progressBar;
        private JButton pauseButton;
        private JButton resumeButton;

        private String songInfo;
        private int progressBarRunTimeInSeconds;
        private AtomicBoolean paused;
        private SwingWorker<Void, Void> worker;

        public SongPlayerPanel(String songInfo, int progressBarRunTimeInSeconds) {
            setLayout(new BorderLayout());

            this.songInfo = songInfo;
            this.progressBarRunTimeInSeconds = progressBarRunTimeInSeconds;

            progressBar = new JProgressBar(0, 100);

            JPanel infoPanel = new JPanel(new GridLayout(3, 1));
            JLabel playingLabel = new JLabel("Playing: " + songInfo);
            infoPanel.add(playingLabel);

            JLabel remainingTimeLabel = new JLabel("Remaining Time: " + formatTime(progressBarRunTimeInSeconds));
            infoPanel.add(remainingTimeLabel);

            infoPanel.add(progressBar);

            add(infoPanel, BorderLayout.CENTER);

            paused = new AtomicBoolean(true);

            pauseButton = new JButton("Pause");
            resumeButton = new JButton("Resume");

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(pauseButton);
            buttonPanel.add(resumeButton);

            add(buttonPanel, BorderLayout.SOUTH);

            pauseButton.setEnabled(false);

            pauseButton.addActionListener(e -> {
                paused.set(true);
                pauseButton.setEnabled(false);
                resumeButton.setEnabled(true);
            });

            resumeButton.addActionListener(e -> {
                paused.set(false);
                pauseButton.setEnabled(true);
                resumeButton.setEnabled(false);
                currentSongPlayer = this;

                if (worker == null || worker.isDone()) {
                    worker = new SwingWorker<Void, Void>() {
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
                            progressBar.setValue(0);
                            remainingTimeLabel.setText("Remaining Time: " + formatTime(progressBarRunTimeInSeconds));
                        }
                    };

                    worker.execute();
                }
            });
        }

        private String formatTime(int seconds) {
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);
            long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
            return String.format("%02d:%02d", minutes, remainingSeconds);
        }
    }
}
