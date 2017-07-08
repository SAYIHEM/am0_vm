package Hardware.Peripherals;

import Hardware.Heaps.Heap;
import Logs.Log;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;

/**
 * Created by X0R_R0X on 7/8/2017.
 */
public class Soundcard extends Device {
    private int frequencyAddress, timeAddress, volumeAddress;
    private float SAMPLE_RATE;

    public Soundcard(float sampleRate, Heap sharedStorage, int frequencyAddress, int timeAddress, int volumeAddress)
    {
        super(sharedStorage);
        this.frequencyAddress = frequencyAddress;
        this.timeAddress = timeAddress;
        this.SAMPLE_RATE = sampleRate;
        this.volumeAddress = volumeAddress;

        //init buffers
        sharedStorage.store(frequencyAddress, 0);
        sharedStorage.store(timeAddress, 0);
        sharedStorage.store(volumeAddress, 0);
    }

    public void tryPlayTone(int hz, int millis, int volume)
    {
        try {
            tone(hz, millis, volume / 100d);

        }
        catch (Exception e)
        {
            Log.d(this, "SOUNDCARD ERROR!");
        }
    }

    public void tone(int hz, int millis, double vol) throws LineUnavailableException
    {
        byte[] buf = new byte[1];
        AudioFormat af =
                new AudioFormat(
                        SAMPLE_RATE, // sampleRate
                        8,           // sampleSizeInBits
                        1,           // channels
                        true,        // signed
                        false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < millis*8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
            sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }


    @Override
    public void update() {

        int time = sharedStorage.load(timeAddress);
        int frequency = sharedStorage.load(frequencyAddress);
        int volume = sharedStorage.load(volumeAddress);

        if(time != 0 && frequency != 0 && volume != 0)
        {
            Thread t = new Thread(() -> tryPlayTone(frequency, time, volume));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sharedStorage.store(frequencyAddress, 0);
            sharedStorage.store(timeAddress, 0);
            sharedStorage.store(volumeAddress, 0);
        }
    }

    @Override
    public void reset() {
        sharedStorage.store(frequencyAddress, 0);
        sharedStorage.store(timeAddress, 0);
        sharedStorage.store(volumeAddress, 0);
    }
}
