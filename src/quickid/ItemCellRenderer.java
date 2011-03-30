package quickid;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ItemCellRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(128, 128, 128);

    public ItemCellRenderer() {
        setOpaque(true);
        setIconTextGap(5);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
        ItemEntry entry = (ItemEntry) value;
        setText(entry.getItemName());
        setIcon(entry.getImageIcon());
        
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(new Color(254,254,254));
            setForeground(Color.black);
        }
        
        return this;
    }
}