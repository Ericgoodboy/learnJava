package ThreadTest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class AddThreadPanel extends JFrame {
    Map<Integer, ArrayList<ControlThread>> map;
    AddThreadPanel(Map<Integer, ArrayList<ControlThread>> map){
        this.map = map;

    }
}
