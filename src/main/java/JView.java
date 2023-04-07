import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class JView extends javax.swing.JFrame {
    JButton jButton = new JButton("Choose file:");
    JFileChooser chooser = new JFileChooser();
    JTree jTree = new JTree();
    JScrollPane jScrollPane = new JScrollPane();


    public JView(){
        super("Import file");
        this.setBounds(100,100, 300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        jButton.addActionListener(new ButtonActionListener());
        javax.swing.tree.DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Reactors");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode));
        jScrollPane.setViewportView(jTree);
        container.add(jScrollPane);
        container.add(jButton, BorderLayout.SOUTH);
    }

    class ButtonActionListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("", "xml", "json", "yaml");
            chooser.setFileFilter(filter);
            chooser.setCurrentDirectory(new File("./src/main/resources"));
            chooser.showDialog(null, "Choose file:");
            File file = chooser.getSelectedFile();
            jTree.setModel(new DefaultTreeModel(treeModel(file)));
        }
    }

    public DefaultMutableTreeNode treeModel(File file){
        DataController dataController = new DataController();
        ReactorType reactorType;
        try {
            reactorType = dataController.importData(String.valueOf(file));
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Reactors");
        DefaultMutableTreeNode reactors = (DefaultMutableTreeNode) reactorType.getFirstNode(reactorType);
        for (Reactor r :reactorType.getReactorList()) {
            reactors.add(reactorType.getNode(r));
        }
        root.add(reactors);
        return reactors;
    }
}
