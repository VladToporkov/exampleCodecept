package com.actionmedia.webservice;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 10.01.14
 * Time: 14:22
 */
public class ServiceResponse {

    List<NodeElement> nodeElementList = new ArrayList<NodeElement>();

    public ServiceResponse() {
    }

    public ServiceResponse(List<NodeElement> nodeElementList) {
        this.nodeElementList = nodeElementList;
    }

    public List<NodeElement> getNodeElementList() {
        return nodeElementList;
    }

    public void setNodeElementList(List<NodeElement> nodeElementList) {
        this.nodeElementList = nodeElementList;
    }

    public NodeElement getNodeElementByName(String nodeName) {
        for (NodeElement nodeElement1 : nodeElementList) {
            if (nodeElement1.getName().equals(nodeName)) {
                return nodeElement1;
            }
            for (NodeElement nodeElement2 : nodeElement1.getChildren()) {
                if (nodeElement2.getName().equals(nodeName)) {
                    return nodeElement2;
                }
                for (NodeElement nodeElement3 : nodeElement2.getChildren()) {
                    if (nodeElement3.getName().equals(nodeName)) {
                        return nodeElement3;
                    }
                    for (NodeElement nodeElement4 : nodeElement3.getChildren()) {
                        if (nodeElement3.getName().equals(nodeName)) {
                            return nodeElement3;
                        }
                        for (NodeElement nodeElement5 : nodeElement4.getChildren()) {
                            if (nodeElement5.getName().equals(nodeName)) {
                                return nodeElement5;
                            }
                            for (NodeElement nodeElement6 : nodeElement5.getChildren()) {
                                if (nodeElement6.getName().equals(nodeName)) {
                                    return nodeElement6;
                                }
                                for (NodeElement nodeElement7 : nodeElement6.getChildren()) {
                                    if (nodeElement7.getName().equals(nodeName)) {
                                        return nodeElement7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<NodeElement> getNodeElementListByName(String nodeName) {
        List<NodeElement> findNodeElementList = new ArrayList<NodeElement>();
        for (NodeElement nodeElement1 : nodeElementList) {
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


    private NodeElement getNodeElementByName(String nodeName, NodeElement nodeElement) {
        for (NodeElement nodeElement1 : nodeElement.getChildren()) {
            if (nodeElement1.getName().equals(nodeName)) {
                return nodeElement1;
            }
        }
        return null;
    }
}
