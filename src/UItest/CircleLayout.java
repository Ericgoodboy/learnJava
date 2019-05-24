package UItest;

import java.awt.*;

public class CircleLayout implements LayoutManager{
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        //主要用的代码
        double centerX = parent.getBounds().getCenterX();
        double centerY = parent.getBounds().getCenterY();

        Insets insets = parent.getInsets();
        double horizon = centerX - insets.left;
        double vertical = centerY - insets.top;
        double radius = horizon<vertical ? horizon:vertical;
        int count = parent.getComponentCount();
        for (int i=0;i<count;i++){
            Component component = parent.getComponent(i);
            if(component.isVisible()){
                Dimension size = component.getPreferredSize();
                double angle = 2*Math.PI*i/count;
                double x = centerX+radius*Math.sin(angle);
                double y = centerY+radius*Math.cos(angle);
                component.setBounds((int)(x-size.width/2),(int)(y-size.height/2),size.width,size.height);
            }

        }
    }
}
