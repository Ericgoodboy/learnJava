package UItest;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
//实现选择lable 的图片
public class ComboBoxRender extends JLabel implements ListCellRenderer {
    private Map<String,ImageIcon> content;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String key = (String)value;
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText(key);
        setIcon(content.get(key));
        setFont(list.getFont());
        return null;
    }
    ComboBoxRender(Map<String,ImageIcon> content){
        this.content = content;
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }
}
