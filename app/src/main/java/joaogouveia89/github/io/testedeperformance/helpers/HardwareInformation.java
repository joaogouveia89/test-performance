package joaogouveia89.github.io.testedeperformance.helpers;

import android.os.Build;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static joaogouveia89.github.io.testedeperformance.app.Constants.HardwareInfoFiles.CORES_INFO_FILE;
import static joaogouveia89.github.io.testedeperformance.app.Constants.HardwareInfoFiles.MAX_FREQ_INFO_FILE;
import static joaogouveia89.github.io.testedeperformance.app.Constants.HardwareInfoFiles.MEMORY_INFO_FILE;

public class HardwareInformation {

    /**
     * font: https://stackoverflow.com/questions/7374246/how-to-get-total-ram-size-of-a-device/7374260#7374260
     * return in KB
     */
    public static double getMemoryCapacity(){
        RandomAccessFile reader = null;
        String load = null;
        double totRam = 0;
        try {
            reader = new RandomAccessFile(MEMORY_INFO_FILE, "r");
            load = reader.readLine();
            // Get the Number value from the string
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(load);
            String value = "";
            while (m.find()) {
                value = m.group(1);
            }
            reader.close();

            totRam = Double.parseDouble(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return totRam;
    }

    public static int getNumberOfCores(){
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if(Pattern.matches("cpu[0-9]+", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }

        try {
            //Get directory containing CPU info
            File dir = new File(CORES_INFO_FILE);
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch(Exception e) {
            //Default to return 1 core
            return 1;
        }
    }

    /**
     *
     * @return
     */
    public static double getMaxCpuFrequency(){
        RandomAccessFile reader = null;
        String load = null;
        double totRam = 0;
        try {
            reader = new RandomAccessFile(MAX_FREQ_INFO_FILE, "r");
            load = reader.readLine();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Double.parseDouble(load);
    }

    public static String getBrand(){
        return Build.BRAND;
    }

}
