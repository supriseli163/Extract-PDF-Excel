package org.cora.extract_pdf_excel.debug.display;

import org.cora.extract_pdf_excel.data.ExtractedPage;
import org.cora.extract_pdf_excel.data.SortedPage;
import org.cora.extract_pdf_excel.data.block.Block;
import org.cora.extract_pdf_excel.data.geom.Rectangle2;
import org.cora.extract_pdf_excel.data.lane.Lanes;
import org.cora.extract_pdf_excel.debug.tests.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by eadgyo on 27/07/16.
 *
 * Create frame and use panelPage
 */
public class FrameCreator
{
    public static void displayBlocks(String frameName, int width, int height, Collection<Block> blocks)
    {
        if (!Constants.displayBlocks)
            return;

        JFrame frame = createFrameGrid(frameName, 1, 1);

        JPanelBlocks jPanelBlocks = new JPanelBlocks(width, height);
        jPanelBlocks.setBlocks(blocks);

        Container contentPane = frame.getContentPane();

        // Add page panel to the frame
        contentPane.add(jPanelBlocks);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }


    public static void displayExtractedPage(String frameName, ExtractedPage extractedPage)
    {
        if (!Constants.displayBlocks)
            return;

        JFrame frame = createFrameGrid(frameName, 1, 1);

        JPanelBlocks jPanelBlocks = new JPanelBlocks(extractedPage.getWidth(), extractedPage.getHeight());
        jPanelBlocks.setBlocks(extractedPage.getBlocks());

        Container contentPane = frame.getContentPane();

        // Add page panel to the frame
        contentPane.add(jPanelBlocks);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void displayRect(String frameName, ArrayList<Rectangle2> rectangles)
    {
        if (!Constants.displayBlocks)
            return;

        JFrame frame = createFrameGrid(frameName, 1, 1);

        JPanelRectangles panel = new JPanelRectangles();
        panel.setRectangles(rectangles);

        Container contentPane = frame.getContentPane();

        // Add page panel to the frame
        contentPane.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void displayLanes(String frameName, int width, int height, Lanes lanes)
    {
        JFrame frame = createFrameGrid(frameName, 1, 1);

        JPanelLane lanesPanel = new JPanelLane(width, height);
        lanesPanel.setLanes(lanes);

        Container contentPane = frame.getContentPane();

        contentPane.add(lanesPanel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void displaySortedPage(String frameName, SortedPage sortedPage)
    {
        JFrame frame = createFrameGrid(frameName, 2, 2);

        ExtractedPage extractedPage = sortedPage.getLinkExtractedPage();

        JPanelLane lines = new JPanelLane(extractedPage.getWidth(), extractedPage.getHeight());
        lines.setLanes(sortedPage.getLines());

        JPanelLane columns = new JPanelLane(extractedPage.getWidth(), extractedPage.getHeight());
        columns.setLanes(sortedPage.getColumns());

        JPanelBlocks jPanelBlocks = new JPanelBlocks(extractedPage.getWidth(), extractedPage.getHeight());
        jPanelBlocks.setBlocks(extractedPage.getBlocks());

        Container contentPane = frame.getContentPane();

        // Add page panel to the frame
        contentPane.add(lines);
        contentPane.add(columns);
        contentPane.add(jPanelBlocks);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }


    /**
     * Create a frame containing a grid
     *
     * @param frameName name of the created frame
     * @param nLines number of lines
     * @param nCols number of columns
     *
     * @return created frame with grid
     */
    public static JFrame createFrameGrid( String frameName, int nLines, int nCols)
    {
        JFrame frame = new JFrame(frameName);

        // Create grid layout
        GridLayout gridLayout = new GridLayout(nLines, nCols);

        // Set layout to frame
        frame.setLayout(gridLayout);

        // Set default option
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }
}