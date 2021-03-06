package joaogouveia89.github.io.testedeperformance.app;

public class Constants {
    public class HardwareInfoFiles{
        public static final String MEMORY_INFO_FILE = "/proc/meminfo";
        public static final String CORES_INFO_FILE = "/sys/devices/system/cpu/";
        public static final String MAX_FREQ_INFO_FILE = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    }

    public class Service{
        public static final String BASE_URL = "https://a057d71a.ngrok.io/api/v1/";

        public static final String CHECK_IMEI = "hasbeentested/{imei}/";
    }

    public class Threads{
        public static final int MAX_ELEMENTS = 20000;
    }
}
