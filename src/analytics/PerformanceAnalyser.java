package analytics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import strategys.BaseStrategy;
import strategys.DiffuseReflexion;
import strategys.DiffuseReflexionSpotlight;
import strategys.PhongShader;
import strategys.PhongShaderWithHalfway;
import strategys.PhongShaderWithHalfwayAndCase;
import strategys.PhongShaderWithHalfwayAndCaseAndSchlick;

public class PerformanceAnalyser extends BaseStrategy{
	
	private boolean is_Enabled = false;
	private BaseStrategy active_shader = null;
	JButton ButtonStart = new JButton("Start");
	JTextArea Textresult = new JTextArea(4,10);
	JProgressBar progress = new JProgressBar(0, 100);
	
	long start_time = 0;
	int fps_accumulator = 0;
	int monitoring_time = 3; //sekunden die ein Shader aktiv ist
	int monitoring_time_counter = 0; 
	
	int fp10ms = 0;
	int fp10ms_counter = 0;
	int fp10ms_messwerte_anzahl = 1000;
	
	int active_shader_nr = -1;
	
	
	
	ArrayList<BaseStrategy> shaderlist = new ArrayList<BaseStrategy>();
	ArrayList<BaseStrategy> shaderlist_tmp = null;
	
	int [][] messwerte = new int[4][fp10ms_messwerte_anzahl];
	
	
	public PerformanceAnalyser() {
		init_options_panel();
		
		shaderlist.add(new PhongShader());
		shaderlist.add(new PhongShaderWithHalfway());
		shaderlist.add(new PhongShaderWithHalfwayAndCase());
		shaderlist.add(new PhongShaderWithHalfwayAndCaseAndSchlick());
		shaderlist.add(null);
		
		
		
	}
	
	private void init_options_panel() {
		optionsPanel.setLayout(new GridLayout(2,0));
		optionsPanel.add(ButtonStart);
		optionsPanel.add(progress);
		optionsPanel.add(Textresult);
		
        //Action Listener
		StartHandler listener =new StartHandler();
		ButtonStart.addActionListener(listener);
		
		
	}
	
	public void startMonitoring() {
		is_Enabled = true;
		shaderlist_tmp = (ArrayList<BaseStrategy>) shaderlist.clone();
		activateNextShader();
	}
	
	
	public BaseStrategy getActiveShader() {
		return active_shader;
	}
	

	
	
	public void stopMonitoring() {

		is_Enabled = false;
		  long delta_ms = System.nanoTime() - start_time;
		  long fps_result = fps_accumulator /(delta_ms / 1000000000);
		  fps_accumulator = 0;
		  start_time = 0;
		  Textresult.setText("FPS:" +fps_result );
		  ButtonStart.setEnabled(true);
		  progress.setValue(0);
		  BoxAndWhisker bw = new BoxAndWhisker(messwerte, fp10ms_messwerte_anzahl);
		  
		  for (int i=0; i<fp10ms_messwerte_anzahl; i++) {
			  
			  System.out.println(messwerte[0][i]);
			  
		  }

	}
	
	private void activateNextShader() {
		active_shader = shaderlist_tmp.get(0);
		
		System.out.println("anal: shader: " + active_shader);
		progress.setValue(progress.getValue()+20);
		shaderlist_tmp.remove(0);
		if (active_shader == null) {
			stopMonitoring();
		}
		active_shader_nr++;
		
		
	}
	
	public boolean isEnabled() {
		
		// Wenn Monitoring aktiv, muss darf sync nicht aufgerufen werden.
		return is_Enabled;
	}
	
	 class StartHandler implements ActionListener {
		  public void actionPerformed(ActionEvent e){
			  ButtonStart.setEnabled(false);
			  start_time = System.nanoTime();
			  startMonitoring();
			  
		  }
	}
	 
		
	 
	 public void setFPS(long fps) {

		 if (isEnabled()) {
				// jeweils 3 Sekunden einen shader aktiv halten
			 
			 if (monitoring_time_counter == monitoring_time) {
				 
				 monitoring_time_counter = 0;
				 System.out.println("Shader fps: " + fps_accumulator/monitoring_time);
				 fps_accumulator = 0;
				 activateNextShader();
			 }
			 
			 
			 monitoring_time_counter++;

			 fps_accumulator += fps;
		 }
		 
		 
		 //hier muss dann die Shader Klasse gewechselt werden
		 
	 }
	 
	 
	 
	 public void set10ms(long fp10ms) {
		 
		 if (isEnabled()) {

			 //wert in passendes array schreiben
			 messwerte[active_shader_nr][fp10ms_counter] =  (int)fp10ms;
			 fp10ms_counter++;
			 
			 if (fp10ms_counter == fp10ms_messwerte_anzahl-1) {
				 fp10ms_counter = 0;
				 
				 activateNextShader();
			 }

			 
			 
		 }
		 
		 
		 
		 
	 }
	

}
