package analytics;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;

public class BoxAndWhisker extends Frame{
	
	Graphics g2d;
	int values_arrayOfarray[][];
	int anzahl_messwerte;
	
	
	
	public BoxAndWhisker(int values_aa[][], int anzahl) {
		anzahl_messwerte = anzahl;
		values_arrayOfarray = values_aa;
		setTitle("BoX % Whisker");
		setSize(1300, 700);
		//dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				//System.exit(0);
				dispose();
			}
			
		}
		);
		setVisible(true);
		
	}
	
	public void drawBoxAndWhiskers (int values[], int x, int y, int version) {
		
		//Array sortieren
		Arrays.sort(values);
		
		int y_offset = 10;
		
		
		
		//SkalierFaktor für 600px berechnen
		double faktorextrema = values[199] / 600;
		double faktor = (values[50] + values[150]) / 600;
		System.out.println("asfasf " + faktor);
		
		
		if (faktor == 0) {faktor = 0.01; System.out.println("faktor auf 1 gesetzt!");}
		if (faktorextrema == 0) {faktorextrema = 0.01; System.out.println("faktorextrema auf 1 gesetzt!");}
		
		
		
		
		
		//Berechnung
		int min, uq, median, oq, max, deltamax;
		min = (int)(values[0]/faktor);
		uq = (int) (values[(int)(anzahl_messwerte*0.25)] / faktor);
		median = (int) (values[(int)(anzahl_messwerte*0.5)] / faktor);
		oq = (int) (values[(int)(anzahl_messwerte*.75)] / faktor);
		max = (int) (values[anzahl_messwerte-1] / faktorextrema);
		deltamax = max - oq;
		
		//Boxplot
		g2d.drawLine(min+x, y_offset+20+y, min+x, y_offset+30+y); // unteres extrema strich
		g2d.drawLine(min+x, y_offset+25+y, uq+x, y_offset+25+y); // unteres extrema line
		g2d.drawLine(median+x, y_offset+y, median+x, y_offset+50+y); // Median
		g2d.drawRect(uq+x, y_offset+y, oq-uq, 50); // Box
		g2d.drawLine(max+x, y_offset+20+y, max+x, y_offset+30+y); // oberes  extrema strich
		g2d.drawLine(oq+x, y_offset+25+y, (max - (deltamax/2))-20+x, y_offset+25+y); // oberes extrema line 1
		g2d.drawLine(max - (deltamax/2)+x, y_offset+25+y, max+x, y_offset+25+y); // oberes extrema line 2
		
		//Skala
		g2d.drawLine(min+x, y_offset+90+y, max+x, y_offset+90+y);
		g2d.drawLine(min+x, y_offset+85+y, min+x, y_offset+95+y);
		g2d.drawLine(max+x, y_offset+85+y, max+x, y_offset+95+y);
		g2d.drawLine(uq+x, y_offset+85+y, uq+x, y_offset+95+y);
		g2d.drawLine(oq+x, y_offset+85+y, oq+x, y_offset+95+y);
		
		//Beschriftung
		
		g2d.drawString("MIN:"+values[0]+" [fp/10ms]", min+x, y_offset+110+y);
		g2d.drawString("UQ:"+values[(int)(anzahl_messwerte*0.25)]+" [fp/10ms]", uq+x, y_offset+110+y);
		g2d.drawString("OQ:"+values[(int)(anzahl_messwerte*0.75)]+" [fp/10ms]", oq+x, y_offset+110+y);
		g2d.drawString("MAX:"+values[anzahl_messwerte-1]+" [fp/10ms]", max+x, y_offset+110+y);
		
		g2d.drawString("Version "+version+":", 100+x, y_offset+50+y);
	}
	
	
	public void paint(Graphics g) {
		
		g2d = (Graphics2D) g;
		
//		long values1[] = new long[200];
//		
//		
//		Random rand = new Random();
//		
//		
//		for (int x = 0 ; x <200; x++) {
//			
//			values1[x] = Math.abs(rand.nextLong()%40000);
//			//System.out.println(values1[x]);
//		}
		
//		
//		
		int y_start = 50;
		int y_offset = 170;
		
		drawBoxAndWhiskers(values_arrayOfarray[0],20,y_start,1);
		drawBoxAndWhiskers(values_arrayOfarray[1],20,y_start + y_offset,2);
		drawBoxAndWhiskers(values_arrayOfarray[2],20,y_start + y_offset * 2,3);
		drawBoxAndWhiskers(values_arrayOfarray[3],20,y_start + y_offset * 3,4);
	}
	
	public static void main (String[] args) {
		
		//new BoxAndWhisker();
		
	}
	

}
