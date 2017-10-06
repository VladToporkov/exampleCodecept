package com.actionmedia.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 10.01.14
 * Time: 14:23
 */
public class NodeElement {

    String name;
    String value;
    NodeElement parent;
    List<NodeElement> children = new ArrayList<NodeElement>();
    Map<String, String> attributes = new HashMap<String, String>();

    NodeElement(String name, String value, NodeElement parent, List<NodeElement> children) {
        this.name = name;
        this.value = value;
        this.parent = parent;
        this.children = children;
    }

    NodeElement(String name, String value, NodeElement parent) {
        this.name = name;
        this.value = value;
        this.parent = parent;
    }

    NodeElement(String name, String value, List<NodeElement> children) {
        this.name = name;
        this.value = value;
        this.children = children;
    }

    NodeElement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    NodeElement(String name) {
        this.name = name;
        this.value = "";
    }

    NodeElement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeElement getParent() {
        return parent;
    }

    public void setParent(NodeElement parent) {
        this.parent = parent;
    }

    public List<NodeElement> getChildren() {
        return children;
    }

    public void setChildren(List<NodeElement> children) {
        this.children = children;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void setAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public List<NodeElement> getChildrenListByName(String nodeName) {
        List<NodeElement> findNodeElementList = new ArrayList<NodeElement>();
        for (NodeElement nodeElement1 : getChildren()) {
            if (nodeElement1.getName().equals(nodeName)) {
                findNodeElementList.add(nodeElement1);
            }
            for (NodeElement nodeElement2 : nodeElement1.getChildren()) {
                if (nodeElement2.getName().equals(nodeName)) {
                    findNodeElementList.add(nodeElement2);
                }
                for (NodeElement nodeElement3 : nodeElement2.getChildren()) {
                    if (nodeElement3.getName().equals(nodeName)) {
                        findNodeElementList.add(nodeElement3);
                    }
                    for (NodeElement nodeElement4 : nodeElement3.getChildren()) {
                        if (nodeElement4.getName().equals(nodeName)) {
                            findNodeElementList.add(nodeElement4);
                        }
                        for (NodeElement nodeElement5 : nodeElement4.getChildren()) {
                            if (nodeElement5.getName().equals(nodeName)) {
                                findNodeElementList.add(nodeElement5);
                            }
                            for (NodeElement nodeElement6 : nodeElement5.getChildren()) {
                                if (nodeElement6.getName().equals(nodeName)) {
                                    findNodeElementList.add(nodeElement6);
                                }
                                for (NodeElement nodeElement7 : nodeElement6.getChildren()) {
                                    if (nodeElement7.getName().equals(nodeName)) {
                                        findNodeElementList.add(nodeElement7);
                                    }
                                    for (NodeElement nodeElement8 : nodeElement7.getChildren()) {
                                        if (nodeElement8.getName().equals(nodeName)) {
                                            findNodeElementList.add(nodeElement8);
                                        }
                                        for (NodeElement nodeElement9 : nodeElement8.getChildren()) {
                                            if (nodeElement9.getName().equals(nodeName)) {
                                                findNodeElementList.add(nodeElement9);
                                            }
                                            for (NodeElement nodeElement10 : nodeElement9.getChildren()) {
                                                if (nodeElement10.getName().equals(nodeName)) {
                                                    findNodeElementList.add(nodeElement10);
                                                }
                                                for (NodeElement nodeElement11 : nodeElement10.getChildren()) {
                                                    if (nodeElement11.getName().equals(nodeName)) {
                                                        findNodeElementList.add(nodeElement11);
                                                    }
                                                    for (NodeElement nodeElement12 : nodeElement11.getChildren()) {
                                                        if (nodeElement12.getName().equals(nodeName)) {
                                                            findNodeElementList.add(nodeElement12);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return findNodeElementList;
    }
}
