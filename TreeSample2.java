import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

@SuppressWarnings( "serial" )
public class TreeSample2 extends JFrame {

  JTree tree;

  public TreeSample2(MutableTreeNode treeNode) {
    tree = new JTree(treeNode);
    add(tree);

    Action treeDown = new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        int index = tree.getSelectionRows()[0];
        if ( index != tree.getRowCount() - 1 )
          tree.setSelectionRow(++index);
      }
    };

    Action treeUp = new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        int index = tree.getSelectionRows()[0];
        if ( index != 0 )
          tree.setSelectionRow(--index);
      }
    };
    ActionMap amc = tree.getActionMap();
    amc.put("treeUp",treeUp);
    amc.put("treeDown", treeDown);
    InputMap imc = tree.getInputMap();
    imc.put(KeyStroke.getKeyStroke('j'), "treeDown");
    imc.put(KeyStroke.getKeyStroke('k'), "treeUp");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("新世界");
    setBounds(100, 100, 250, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("世界の国々");
    for ( String child : new String[]{ "日本", "アメリカ", "ドイツ", "おそロシア" } )
      root.add(new DefaultMutableTreeNode(child));

    for ( String leaf : new String[]{ "アメリカ村", "ドイツ村" } )
      root.getNextNode().add(new DefaultMutableTreeNode(leaf));

    new TreeSample(root);
  }
}

