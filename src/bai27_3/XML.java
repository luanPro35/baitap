package bai27_3;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class XML {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textPathField;
    private JButton readButton, writeButton, deleteButton, updateButton, creatButton;

    public XML() {
        frame = new JFrame("Introduction");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textPathField = new JTextField(20);
        readButton = new JButton("Read");
        writeButton = new JButton("Write");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        creatButton = new JButton("Create");
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("File Path: "));
        topPanel.add(textPathField);
        topPanel.add(readButton);
        topPanel.add(writeButton);
        topPanel.add(deleteButton);
        topPanel.add(updateButton);
        topPanel.add(creatButton);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        textArea.setEditable(false);
        frame.add(panel);
        frame.setVisible(true);
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readButton(textPathField.getText());
            }
        });
        writeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeButton(textPathField.getText());
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButton(textPathField.getText());
            }
        });
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        creatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
    }

    private void writeButton(String text) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);
            rootElement.appendChild(doc.createTextNode(text));
            rootElement.appendChild(doc.createElement("file"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(textPathField.getText()));
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(frame, "Successfully written to the file");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }

    private void readButton(String path) {
        try{
            File file = new File(path);
            if(!file.exists()){
                JOptionPane.showMessageDialog(frame, "File does not exist");
                return;
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("path");
            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    textPathField.setText(element.getAttribute("path"));
                }
            }
            textArea.setText("XML File Read Successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error reading XML file");
        }
    }

    private void deleteButton(String path) {
        File file = new File(path);
        if(file.exists()){
            if(file.delete()){
                JOptionPane.showMessageDialog(frame, "Successfully deleted the file");
            }
            else{
                JOptionPane.showMessageDialog(frame, "Failed to delete the file");
            }
        } else{
            JOptionPane.showMessageDialog(frame, "File does not exist");
        }
    }

    private void createButton(String path) {

    }

    public static void main(String[] args) {
        new XML();
    }
}
