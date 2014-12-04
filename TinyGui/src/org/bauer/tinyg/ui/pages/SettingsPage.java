package org.bauer.tinyg.ui.pages;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.components.AxisSettingsComposite;
import org.bauer.tinyg.ui.components.MotorSettingsComposite;
import org.bauer.tinyg.ui.components.TabFolder;
import org.bauer.tinyg.ui.components.TabStrip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SettingsPage extends Composite {

	private Composite tabArea;
	private StackLayout tabStack;
	private TabFolder tabs;


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SettingsPage(Composite parent, int style) {
		super(parent, style);

		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 15;
		layout.marginBottom = 15;
		setLayout(layout);
		
		tabs = new TabFolder(this, SWT.NULL);
		tabs.setTabs("Motor", "Axis", "Machine");
		tabs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		buildMotorTab();
		buildAxisTab();
		buildMachineTab();
		
		tabs.select(0);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	private void buildMotorTab() {
		Composite motorTab = new  Composite(tabs.getTabParent(), SWT.NULL);
		GridLayout layoutTab = new GridLayout(2, true);
		layoutTab.marginWidth = 0;
		layoutTab.marginHeight = 0;
		motorTab.setLayout(layoutTab);
		
		Composite motorAreaLeft = new  Composite(motorTab, SWT.NULL);
		motorAreaLeft.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		GridLayout layoutLeft = new GridLayout(1, true);
		layoutLeft.marginWidth = 0;
		layoutLeft.marginHeight = 0;
		layoutLeft.horizontalSpacing = 15;
		motorAreaLeft.setLayout(layoutLeft);
				
		
		// Labels
		Label lMotor1 = Resources.createLabel(motorAreaLeft, "Motor 1");
		lMotor1.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		lMotor1.setFont(Resources.title());
				
		MotorSettingsComposite m1 = new MotorSettingsComposite(motorAreaLeft, SWT.NULL);
		m1.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		Resources.createLabel(motorAreaLeft, " ");
		Resources.createLabel(motorAreaLeft, " ");
		

		Label lMotor3 = Resources.createLabel(motorAreaLeft, "Motor 3");
		lMotor3.setFont(Resources.title());
		lMotor3.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		MotorSettingsComposite m3 = new MotorSettingsComposite(motorAreaLeft, SWT.NULL);
		m3.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		
		Composite motorAreaRight= new  Composite(motorTab, SWT.NULL);
		motorAreaRight.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		GridLayout layoutRight = new GridLayout(1, true);
		layoutRight.marginWidth = 0;
		layoutRight.marginHeight = 0;
		layoutRight.horizontalSpacing = 15;
		motorAreaRight.setLayout(layoutRight);
		
		Label lMotor2 = Resources.createLabel(motorAreaRight, "Motor 2");
		lMotor2.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		lMotor2.setFont(Resources.title());
		
		
		MotorSettingsComposite m2 = new MotorSettingsComposite(motorAreaRight, SWT.NULL);
		m2.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		
		Resources.createLabel(motorAreaRight, " ");
		Resources.createLabel(motorAreaRight, " ");
		
		
		Label lMotor4 = Resources.createLabel(motorAreaRight, "Motor 4");
		lMotor4.setFont(Resources.title());
		lMotor4.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		
		MotorSettingsComposite m4 = new MotorSettingsComposite(motorAreaRight, SWT.NULL);
		m4.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
	}
	
	private void buildAxisTab() {
		Composite motorTab = new  Composite(tabs.getTabParent(), SWT.NULL);
		GridLayout layoutTab = new GridLayout(2, true);
		layoutTab.marginWidth = 0;
		layoutTab.marginHeight = 0;
		motorTab.setLayout(layoutTab);
		
		Composite areaLeft = new  Composite(motorTab, SWT.NULL);
		areaLeft.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		GridLayout layoutLeft = new GridLayout(1, true);
		layoutLeft.marginWidth = 0;
		layoutLeft.marginHeight = 0;
		layoutLeft.horizontalSpacing = 15;
		areaLeft.setLayout(layoutLeft);
				
		
		Label lX = Resources.mLabel(areaLeft, "X Axis");
		lX.setAlignment(SWT.CENTER);
		lX.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		lX.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				
		AxisSettingsComposite xAxis = new AxisSettingsComposite(areaLeft, SWT.NULL);
//		xAxis.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		xAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		

		Label ly = Resources.mLabel(areaLeft, "Y Axis");
		ly.setAlignment(SWT.CENTER);
		ly.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		ly.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				
		AxisSettingsComposite yAxis = new AxisSettingsComposite(areaLeft, SWT.NULL);
		yAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		Label lZ = Resources.mLabel(areaLeft, "Z Axis");
		lZ.setAlignment(SWT.CENTER);
		lZ.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		lZ.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				
		AxisSettingsComposite zAxis = new AxisSettingsComposite(areaLeft, SWT.NULL);
		zAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		
		Composite areaRight = new  Composite(motorTab, SWT.NULL);
		areaRight.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		GridLayout layoutRight= new GridLayout(1, true);
		layoutRight.marginWidth = 0;
		layoutRight.marginHeight = 0;
		layoutRight.horizontalSpacing = 15;
		areaRight.setLayout(layoutRight);
				
		
		Label lA = Resources.createLabel(areaRight, "A Axis");
		lA.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
				
		AxisSettingsComposite aAxis = new AxisSettingsComposite(areaRight, SWT.NULL);
		aAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		Label lb = Resources.createLabel(areaRight, "B Axis");
		lb.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
				
		AxisSettingsComposite bAxis = new AxisSettingsComposite(areaRight, SWT.NULL);
		bAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
		
		Label lC = Resources.createLabel(areaRight, "C Axis");
		lC.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
				
		AxisSettingsComposite cAxis = new AxisSettingsComposite(areaRight, SWT.NULL);
		cAxis.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		
	}
	private void buildMachineTab() {
		Composite tab = new  Composite(tabs.getTabParent(), SWT.NULL);
		GridLayout layoutTab = new GridLayout(2, true);
		layoutTab.marginWidth = 0;
		layoutTab.marginHeight = 0;
		tab.setLayout(layoutTab);
		
		
	}
}
