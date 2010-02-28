import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

@SuppressWarnings( "serial" )
public class TreeSample extends JFrame implements KeyListener {

  JTree tree;

  public TreeSample(MutableTreeNode treeNode) {
    tree = new JTree(treeNode);
    add(tree);
    tree.addKeyListener(this);
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

  /**
   * jまたはkが押されたらtreeの選択を移動する
   * @param e
   */
  @Override
  public void keyTyped(KeyEvent e) {
    if( tree.isSelectionEmpty() ) return;

    char getKey = e.getKeyChar();
    int index = tree.getSelectionRows()[0];
    switch ( getKey ) {
      case 'j': {
        if ( index != tree.getRowCount() - 1 )
          tree.setSelectionRow(++index);
        break;
      }
      case 'k': {
        if ( index != 0 )
          tree.setSelectionRow(--index);
        break;
      }
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}

