package com.filess;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class Convertor {
    public static void convertJsonToXmlAndSave(String outputFileName) throws Exception {
        // Manually input JSON as a string
        String jsonInput = """
        {
          "user": {
            "id": "123",
            "name": "John Doe",
            "email": "john.doe@example.com",
            "address": {
              "street": "123 Main St",
              "city": "Anytown",
              "state": "CA",
              "zip": "12345"
            },
            "transactions": [
              {
                "date": "2025-02-01",
                "description": "Deposit",
                "amount": 1000.00
              },
              {
                "date": "2025-02-15",
                "description": "Withdrawal",
                "amount": -200.00
              }
            ]
          }
        }
        """;

        // Parse JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonInput);

        // Create XML Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        // Convert JSON to XML
        Element root = convertJsonToXml(jsonNode, document, "user");
        document.appendChild(root);

        // Save XML to file
        saveXmlToFile(document, outputFileName);
    }

    private static Element convertJsonToXml(JsonNode node, Document document, String nodeName) {
        Element element = document.createElement(nodeName);

        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                element.appendChild(convertJsonToXml(field.getValue(), document, field.getKey()));
            }
        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                element.appendChild(convertJsonToXml(arrayItem, document, nodeName));
            }
        } else {
            element.setTextContent(node.asText());
        }
        return element;
    }

    private static void saveXmlToFile(Document document, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Pretty print
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));

        transformer.transform(source, result);
    }
}
