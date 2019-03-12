import java.applet.*;
import java.awt.Event;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;

/*import javax.sound.sampled.*;
import java.io.*;
public class MusicPlayer{

private AudioFormat format;
private byte[] samples;

public static void main(String args[])throws Exception{
MusicPlayer sound =new MusicPlayer("./src/a.wma");
InputStream stream =new ByteArrayInputStream(sound.getSamples());
// play the sound
sound.play(stream);
// exit
System.exit(0);
}

public MusicPlayer(String filename) {
try {
// open the audio input stream
AudioInputStream stream =AudioSystem.getAudioInputStream(new File(filename));
format = stream.getFormat();
// get the audio samples
samples = getSamples(stream);
}
catch (UnsupportedAudioFileException ex) {
ex.printStackTrace();
}
catch (IOException ex) {
ex.printStackTrace();
}
}

public byte[] getSamples() {
return samples;
}

private byte[] getSamples(AudioInputStream audioStream) {
// get the number of bytes to read
int length = (int)(audioStream.getFrameLength() * format.getFrameSize());
// read the entire stream
byte[] samples = new byte[length];
DataInputStream is = new DataInputStream(audioStream);
try {
is.readFully(samples);
}
catch (IOException ex) {
ex.printStackTrace();
}
// return the samples
return samples;
}

public void play(InputStream source) {
// use a short, 100ms (1/10th sec) buffer for real-time
// change to the sound stream
int bufferSize = format.getFrameSize() *
Math.round(format.getSampleRate() / 10);
byte[] buffer = new byte[bufferSize];
// create a line to play to
SourceDataLine line;
try {
DataLine.Info info =
new DataLine.Info(SourceDataLine.class, format);
line = (SourceDataLine)AudioSystem.getLine(info);
line.open(format, bufferSize);
}
catch (LineUnavailableException ex) {
ex.printStackTrace();
return;
}
// start the line
line.start();
// copy data to the line
try {
int numBytesRead = 0;
while (numBytesRead != -1) {
numBytesRead =
source.read(buffer, 0, buffer.length);
if (numBytesRead != -1) {
line.write(buffer, 0, numBytesRead);
}
}
}
catch (IOException ex) {
ex.printStackTrace();
}
// wait until all data is played, then close the line
line.drain();
line.close();
}

}
*/

public class MusicPlayer extends JApplet {
	AudioClip clip;
	JButton play;
	public void init() {
		//URL url;
		
			clip = this.getAudioClip(getCodeBase(), "a.wma");
		
		clip.play();
		play = new JButton("sound");
		add(play);
	}
	
	public boolean action(Event event, Object arg) {
		if(event.target == play) {
			clip.play();
		}
		return true;
	}
}