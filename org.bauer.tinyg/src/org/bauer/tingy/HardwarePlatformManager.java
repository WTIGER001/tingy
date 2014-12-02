/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bauer.tingy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 *
 * @author ril3y
 */
public class HardwarePlatformManager {

    private ArrayList<HardwarePlatform> availablePlatforms = new ArrayList<>();
    static final Logger logger = Logger.getLogger(HardwarePlatformManager.class);

    public HardwarePlatformManager() {
        this.LoadPlatforConfigs();

    }
//we are not using this until all platforms have the $hp element.  

    public boolean setPlatformByName(String name) {
        for (int i = 0; i < availablePlatforms.size(); i++) {
            if (availablePlatforms.get(i).getPlatformName().equals(name)) {
                TinygDriver.getInstance().machine.hardwarePlatform = availablePlatforms.get(i);
                logger.info("Applied " + name + " hardware Profile to System");
                return true;
            }
        }
        return false;
    }

    public boolean setHardwarePlatformByVersionNumber(int verNumber) {
        for (int i = 0; i < availablePlatforms.size(); i++) {
            if (availablePlatforms.get(i).getHardwarePlatformVersion() == verNumber) {
                TinygDriver.getInstance().machine.hardwarePlatform = availablePlatforms.get(i);
                logger.info("Applied " + verNumber + " hardware platform id number to System");
                return true;

            }
        }
        return false;
    }

    private int LoadPlatforConfigs() {
    	loadPlatform(getClass().getResourceAsStream("TinyG.json"));
    	loadPlatform(getClass().getResourceAsStream("TinyGv7.json"));
    	loadPlatform(getClass().getResourceAsStream("ArduinoDue.json"));
    	
        logger.info("Loaded " + availablePlatforms.size() + " platform files");
        return availablePlatforms.size();
    }
    
    private void loadPlatform(InputStream in) {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            HardwarePlatform hp = gson.fromJson(br, HardwarePlatform.class);
            availablePlatforms.add(hp);
        } catch (JsonIOException ex) {
            logger.error("Error loading hardware platforms: " + ex.getMessage());
        } catch (JsonSyntaxException ex){
            logger.error(ex.getMessage());
        }
    }

    public static HardwarePlatformManager getInstance() {
        return HardwarePlatformManagerHolder.INSTANCE;
    }

    private static class HardwarePlatformManagerHolder {

        private static final HardwarePlatformManager INSTANCE = new HardwarePlatformManager();
    }

    private void updatePlatformFiles() {
        //todo code in support for updating platform files from remote server
    }
}
