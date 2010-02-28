import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

@SuppressWarnings( "serial" )
public class TreeSample3 extends JFrame {

  JTree tree;

  public TreeSample3(MutableTreeNode treeNode) {
    tree = new JTree(treeNode);
    add(tree);
    //↓キーと↑キーの挙動を取得する
    KeyStroke downKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
    KeyStroke upKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
    InputMap imc = tree.getInputMap();
    imc.put(KeyStroke.getKeyStroke('j'),  imc.get(downKey));
    imc.put(KeyStroke.getKeyStroke('k'), imc.get(upKey));
    
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

