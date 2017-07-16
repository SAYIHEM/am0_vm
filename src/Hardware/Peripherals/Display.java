package Hardware.Peripherals;

import Hardware.Heaps.Heap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by X0R_R0X on 7/8/2017.
 */
public class Display extends Device {

    private int baseAddress;
    private JFrame displayPanel;
    private int virtualWidth, virtualHeight;
    private Integer[] pixels;
    private VirtualDisplay virtualDisplay;

    public Display(Heap sharedStorage, int baseAddress, int virtualWidth, int virtualHeight, JFrame displayPanel) {
        super(sharedStorage);
        this.baseAddress = baseAddress;
        this.displayPanel = displayPanel;
        this.virtualWidth = virtualWidth;
        this.virtualHeight = virtualHeight;
        pixels = new Integer[virtualHeight * virtualWidth];

        virtualDisplay = new VirtualDisplay();
        displayPanel.add(virtualDisplay);

        for(int i = 0; i < virtualHeight * virtualWidth; i++)
        {
            sharedStorage.store(baseAddress + i, 0);
        }

    }

    @Override
    public void update() {

        for(int y = 0; y < virtualHeight; y++)
        {
            for(int x = 0; x < virtualWidth; x++)
            {
                int currAddress = baseAddress + (y * virtualWidth + x);
                pixels[(y * virtualWidth + x)] = sharedStorage.load(currAddress);
            }
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    @Override
    public void reset() {
        for(int i = 0; i < virtualHeight * virtualWidth; i++)
        {
            sharedStorage.store(baseAddress + i, 0);
        }
    }

    class VirtualDisplay extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(int y = 0; y < Display.this.virtualHeight; y++)
            {
                for(int x = 0; x < Display.this.virtualWidth; x++)
                {
                    if(pixels[(y * Display.this.virtualWidth + x)] != null && pixels[(y * Display.this.virtualWidth + x)] != 0)
                    {
                        g.setColor(Color.black);
                    }
                    else
                    {
                        g.setColor(Color.white);
                    }

                    int pxWidth = displayPanel.getWidth() / virtualWidth;
                    int pxHeight = displayPanel.getHeight() / virtualHeight;
                    g.fillRect(x * pxWidth, y * pxHeight, pxWidth, pxHeight);
                }
            }
        }
    }
}
