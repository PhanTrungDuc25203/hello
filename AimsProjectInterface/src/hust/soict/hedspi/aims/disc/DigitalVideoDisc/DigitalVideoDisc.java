package hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import java.util.concurrent.atomic.AtomicBoolean;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	
	
	@Override
	public String toString() {
		return String.format(super.toString());
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public void playDialog() {
//		showPlayingDialog(this.getTitle(), this.getLength());
		SwingUtilities.invokeLater(() -> {
            PlayingFrame playingFrame = new PlayingFrame(this.getTitle(), this.getLength());
            playingFrame.setVisible(true);
        });
	}
	
	 private static void showPlayingDialog(String songInfo, int progressBarRunTimeInSeconds) {
	        JOptionPane optionPane = new JOptionPane();
	        
	        JProgressBar progressBar = new JProgressBar(0, 100);
	        optionPane.setMessage(new Object[]{
	                "Playing: " + songInfo,
	                progressBar
	        });

	        JButton pauseButton = new JButton("Pause");
	        JButton resumeButton = new JButton("Resume");
	        optionPane.setOptions(new Object[]{pauseButton, resumeButton});

	        AtomicBoolean paused = new AtomicBoolean(false);

	        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
	            @Override
	            protected Void doInBackground() throws Exception {
	                int totalTimeSteps = 100;  // Số bước cần thiết để ProgressBar đi từ 0% đến 100%
	                int timeIncrement = progressBarRunTimeInSeconds / totalTimeSteps;

	                for (int i = 0; i <= totalTimeSteps; i++) {
	                    while (paused.get()) {
	                        Thread.sleep(100);
	                    }

	                    progressBar.setValue(i);

	                    int remainingTime = progressBarRunTimeInSeconds - i * timeIncrement;
	                    optionPane.setMessage(new Object[]{
	                            "Playing: " + songInfo,
	                            "Remaining Time: " + formatTime(remainingTime),
	                            progressBar
	                    });

	                    Thread.sleep(timeIncrement * 100);
	                }
	                return null;
	            }

	            @Override
	            protected void done() {
	                optionPane.setValue(JOptionPane.CLOSED_OPTION);
	            }
	        };

	        worker.execute();

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

	        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
	        JDialog dialog = optionPane.createDialog("Now Playing");
	        dialog.setVisible(true);
	    }

	    private static String formatTime(int seconds) {
	        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
	        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
	        return String.format("%02d:%02d", minutes, remainingSeconds);
	    }
}
