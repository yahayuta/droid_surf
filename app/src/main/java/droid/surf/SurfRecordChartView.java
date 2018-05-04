package droid.surf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.axis.NumberAxis;
import org.afree.chart.plot.CategoryPlot;
import org.afree.chart.plot.PlotOrientation;
import org.afree.data.category.DefaultCategoryDataset;
import org.afree.graphics.geom.RectShape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * FuelUsageAnalyzerChartView
 * @author yasupong
 */
@SuppressLint("DrawAllocation")
public class SurfRecordChartView extends View {
	
	private List<SurfRecordEntity> recordList = null;
	private String chart_name = null;
	private String chart_x_label = null;
	private String chart_y_label = null;
	private String chart_plot = null;
	private int chart_type = 0;
	
	/**
	 * コンストラクター
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public SurfRecordChartView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * コンストラクター
	 * @param context
	 * @param attrs
	 */
	public SurfRecordChartView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * コンストラクター
	 * @param context
	 */
	public SurfRecordChartView(Context context) {
		super(context);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		
        RectShape chartArea = new RectShape(0,0,canvas.getWidth(),400);
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
    	
    	if (chart_type == 0) {
    		getPointChartPlot(data);
    	}
    	else if (chart_type == 1) {
    		getSizeChartPlot(data);
    	}
    	else if (chart_type == 2) {
    		getTimeOfPointChartPlot(data);
    	}
    	else if (chart_type == 3) {
    		getTakeOffBySizeChartPlot(data);
    	}
    	else if (chart_type == 4) {
    		getTakeOffByPointPlot(data);
    	}
    	else if (chart_type == 5) {
    		getTakeOffByCloudChartPlot(data);
    	}
    	
        AFreeChart chart = ChartFactory.createBarChart(chart_name,chart_x_label,chart_y_label,data,PlotOrientation.VERTICAL,true,false,false);
        
        // 整数だけにする
        CategoryPlot plot = chart.getCategoryPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        chart.draw(canvas, chartArea);
	}

	/**
	 * ポイント
	 * @param dataSet
	 */
	private void getPointChartPlot(DefaultCategoryDataset dataSet) {

		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getPointName()) == null) {
				plotMap.put(data.getPointName(), "1");
			}
			else {
				int count = Integer.parseInt((String)plotMap.get(data.getPointName()));
				count++;
				plotMap.put(data.getPointName(), String.valueOf(count));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}
	
	/**
	 * サイズ
	 * @param dataSet
	 */
	private void getSizeChartPlot(DefaultCategoryDataset dataSet) {
		
		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getSize()) == null) {
				plotMap.put(data.getSize(), "1");
			}
			else {
				int count = Integer.parseInt((String)plotMap.get(data.getSize()));
				count++;
				plotMap.put(data.getSize(), String.valueOf(count));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}

	/**
	 * ポイント別時間
	 * @param dataSet
	 */
	private void getTimeOfPointChartPlot(DefaultCategoryDataset dataSet) {
		
		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getPointName()) == null) {
				plotMap.put(data.getPointName(), data.getTime());
			}
			else {
				double count = Double.parseDouble((String)plotMap.get(data.getPointName()));
				double countNow = Double.parseDouble(data.getTime());
				plotMap.put(data.getPointName(), String.valueOf(count + countNow));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}

	/**
	 * サイズ別テイクオフ数
	 * @param dataSet
	 */
	private void getTakeOffBySizeChartPlot(DefaultCategoryDataset dataSet) {
		
		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getSize()) == null) {
				plotMap.put(data.getSize(), data.getTakeOff());
			}
			else {
				int count = Integer.parseInt((String)plotMap.get(data.getSize()));
				int countNow = Integer.parseInt(data.getTakeOff());
				plotMap.put(data.getSize(), String.valueOf(count + countNow));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}
	
	/**
	 * ポイント別テイクオフ数
	 * @param dataSet
	 */
	private void getTakeOffByPointPlot(DefaultCategoryDataset dataSet) {
		
		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getPointName()) == null) {
				plotMap.put(data.getPointName(), data.getTakeOff());
			}
			else {
				int count = Integer.parseInt((String)plotMap.get(data.getPointName()));
				int countNow = Integer.parseInt(data.getTakeOff());
				plotMap.put(data.getPointName(), String.valueOf(count + countNow));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}
	
	/**
	 * 混雑度別テイクオフ数
	 * @param dataSet
	 */
	private void getTakeOffByCloudChartPlot(DefaultCategoryDataset dataSet) {
		
		Map<String, String> plotMap = new HashMap<String, String>();
		
		for (int i = 0; i < recordList.size(); i++) {
			
			SurfRecordEntity data = (SurfRecordEntity)recordList.get(i);
			
			if (plotMap.get(data.getCloud()) == null) {
				plotMap.put(data.getCloud(), data.getTakeOff());
			}
			else {
				int count = Integer.parseInt((String)plotMap.get(data.getCloud()));
				int countNow = Integer.parseInt(data.getTakeOff());
				plotMap.put(data.getCloud(), String.valueOf(count + countNow));
			}
		}
		
		for (Iterator<String> iterator = plotMap.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dataSet.addValue(Double.parseDouble((String)plotMap.get(string)), chart_plot, string);
		}
	}
	
	/**
	 * ログリスト取得
	 * @param logList
	 */
	public void setLogList(List<SurfRecordEntity> logList) {
		this.recordList = logList;
	}

	/**
	 * @param chart_name the chart_name to set
	 */
	public void setChart_name(String chart_name) {
		this.chart_name = chart_name;
	}

	/**
	 * @param chart_x_label the chart_x_label to set
	 */
	public void setChart_x_label(String chart_x_label) {
		this.chart_x_label = chart_x_label;
	}

	/**
	 * @param chart_y_label the chart_y_label to set
	 */
	public void setChart_y_label(String chart_y_label) {
		this.chart_y_label = chart_y_label;
	}

	/**
	 * @param chart_plot the chart_plot to set
	 */
	public void setChart_plot(String chart_plot) {
		this.chart_plot = chart_plot;
	}

	/**
	 * @param chart_type the chart_type to set
	 */
	public void setChart_type(int chart_type) {
		this.chart_type = chart_type;
	}
}
