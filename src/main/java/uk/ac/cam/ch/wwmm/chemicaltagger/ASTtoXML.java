package uk.ac.cam.ch.wwmm.chemicaltagger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;
import org.antlr.runtime.tree.Tree;
import org.apache.log4j.Logger;

public class ASTtoXML {

    private final Logger LOG = Logger.getLogger(ASTtoXML.class);

    public ASTtoXML() {
    }

    public void convert(Tree astTree, String xmlFilename) {
        Element root = new Element("Document");
        Document doc = new Document(getNodes(astTree, root));
        writeToFile(doc, xmlFilename);


    }

    public Element getNodes(Tree astTree, Element node) {

        int nodeCount = astTree.getChildCount();
        Element newNode = null;
        for (int i = 0; i < nodeCount; i++) {
            String text = astTree.getChild(i).getText();
            int type = astTree.getChild(i).getType();
            if (type == 9) {
                newNode.appendChild(text);
            } else {
                try {
                    newNode = new Element(text);
                    node.appendChild(newNode);
                    getNodes(astTree.getChild(i), newNode);
                } catch (Exception e) {
                    LOG.debug("Can't Parse " + e.getMessage());
                }
            }

        }
        return node;
    }

    private void writeToFile(Document doc, String xmlFilename) {

        try {
            Serializer serializer = new Serializer(new FileOutputStream(xmlFilename));
            serializer.write(doc);
            serializer.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ASTtoXML.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
