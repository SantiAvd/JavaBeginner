
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class OutOfListindException extends Exception {
    private static Logger logger = Logger.getLogger("В списке нет таких пунктов");

    public OutOfListindException(int choise) {
        StringWriter trace = new StringWriter();
        this.printStackTrace(new PrintWriter(trace));
        Logger var10000 = logger;
        String var10001 = trace.toString();
        var10000.severe(var10001 + "В списке выбора действий нет пункта - " + choise + " максимум - 4");
    }
}
