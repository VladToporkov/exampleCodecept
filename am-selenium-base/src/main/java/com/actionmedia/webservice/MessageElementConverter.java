package com.actionmedia.webservice;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 10.01.14
 * Time: 11:04
 */
public class MessageElementConverter {

    MessageElement messageElement;
    ServiceResponse response;

    public MessageElementConverter(MessageElement messageElement) {
        this.messageElement = messageElement;
        this.response = convert();
    }

    public MessageElement getMessageElement() {
        return messageElement;
    }

    public ServiceResponse getResponse() {
        return response;
    }

    private ServiceResponse convert() {
        List<NodeElement> nodeElementList = new ArrayList<NodeElement>();
        nodeElementList.addAll(getNodeElements(messageElement));
        return new ServiceResponse(nodeElementList);
    }

    private List<NodeElement> getNodeElements(Node node) {
        List<NodeElement> nodeElementList = new ArrayList<NodeElement>();
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item1 = node.getChildNodes().item(i);

            NodeElement nodeElement1 = getNodeElement(item1);
            List<NodeElement> childNodeList1 = new ArrayList<NodeElement>();
            for (int j = 0; j < item1.getChildNodes().getLength(); j++) {
                Node item2 = item1.getChildNodes().item(j);

                NodeElement nodeElement2 = getNodeElement(item2);
                List<NodeElement> childNodeList2 = new ArrayList<NodeElement>();
                for (int k = 0; k < item2.getChildNodes().getLength(); k++) {
                    Node item3 = item2.getChildNodes().item(k);

                    NodeElement nodeElement3 = getNodeElement(item3);
                    List<NodeElement> childNodeList3 = new ArrayList<NodeElement>();
                    for (int l = 0; l < item3.getChildNodes().getLength(); l++) {
                        Node item4 = item3.getChildNodes().item(l);

                        NodeElement nodeElement4 = getNodeElement(item4);
                        List<NodeElement> childNodeList4 = new ArrayList<NodeElement>();
                        for (int m = 0; m < item4.getChildNodes().getLength(); m++) {
                            Node item5 = item4.getChildNodes().item(m);

                            NodeElement nodeElement5 = getNodeElement(item5);
                            List<NodeElement> childNodeList5 = new ArrayList<NodeElement>();
                            for (int n = 0; n < item5.getChildNodes().getLength(); n++) {
                                Node item6 = item5.getChildNodes().item(n);

                                NodeElement nodeElement6 = getNodeElement(item6);
                                List<NodeElement> childNodeList6 = new ArrayList<NodeElement>();
                                for (int o = 0; o < item6.getChildNodes().getLength(); o++) {
                                    Node item7 = item6.getChildNodes().item(o);

                                    NodeElement nodeElement7 = getNodeElement(item7);
                                    List<NodeElement> childNodeList7 = new ArrayList<NodeElement>();
                                    for (int p = 0; p < item7.getChildNodes().getLength(); p++) {
                                        Node item8 = item7.getChildNodes().item(p);

                                        NodeElement nodeElement8 = getNodeElement(item8);
                                        List<NodeElement> childNodeList8 = new ArrayList<NodeElement>();
                                        for (int q = 0; q < item8.getChildNodes().getLength(); q++) {
                                            Node item9 = item8.getChildNodes().item(q);

                                            NodeElement nodeElement9 = getNodeElement(item9);
                                            List<NodeElement> childNodeList9 = new ArrayList<NodeElement>();
                                            for (int r = 0; r < item9.getChildNodes().getLength(); r++) {
                                                Node item10 = item9.getChildNodes().item(r);

                                                NodeElement nodeElement10 = getNodeElement(item10);
                                                List<NodeElement> childNodeList10 = new ArrayList<NodeElement>();
                                                for (int s = 0; s < item10.getChildNodes().getLength(); s++) {
                                                    Node item11 = item10.getChildNodes().item(s);

                                                    NodeElement nodeElement11 = getNodeElement(item11);
                                                    List<NodeElement> childNodeList11 = new ArrayList<NodeElement>();
                                                    for (int t = 0; t < item11.getChildNodes().getLength(); t++) {
                                                        Node item12 = item11.getChildNodes().item(t);

                                                        NodeElement nodeElement12 = getNodeElement(item12);
                                                        List<NodeElement> childNodeList12 = new ArrayList<NodeElement>();
                                                        for (int u = 0; u < item12.getChildNodes().getLength(); u++) {
                                                            Node item13 = item12.getChildNodes().item(u);

                                                            NodeElement nodeElement13 = getNodeElement(item13);
                                                            List<NodeElement> childNodeList13 = new ArrayList<NodeElement>();
                                                            if (item13.getNodeName() == null && item13.getNodeValue() != null) {
                                                                nodeElement12.setValue(item13.getNodeValue());
                                                            } else {
                                                                childNodeList12.add(nodeElement13);
                                                                nodeElement13.setChildren(childNodeList13);
                                                            }
                                                            nodeElement13.setParent(nodeElement12);
                                                        }

                                                        if (item12.getNodeName() == null && item12.getNodeValue() != null) {
                                                            nodeElement11.setValue(item12.getNodeValue());
                                                        } else {
                                                            childNodeList11.add(nodeElement12);
                                                            nodeElement12.setChildren(childNodeList12);
                                                        }
                                                        nodeElement12.setParent(nodeElement11);
                                                    }

                                                    if (item11.getNodeName() == null && item11.getNodeValue() != null) {
                                                        nodeElement10.setValue(item11.getNodeValue());
                                                    } else {
                                                        childNodeList10.add(nodeElement11);
                                                        nodeElement11.setChildren(childNodeList11);
                                                    }
                                                    nodeElement11.setParent(nodeElement10);
                                                }
                                                if (item10.getNodeName() == null && item10.getNodeValue() != null) {
                                                    nodeElement9.setValue(item10.getNodeValue());
                                                } else {
                                                    childNodeList9.add(nodeElement10);
                                                    nodeElement10.setChildren(childNodeList10);
                                                }
                                                nodeElement10.setParent(nodeElement9);
                                            }

                                            if (item9.getNodeName() == null && item9.getNodeValue() != null) {
                                                nodeElement8.setValue(item9.getNodeValue());
                                            } else {
                                                childNodeList8.add(nodeElement9);
                                                nodeElement9.setChildren(childNodeList9);
                                            }
                                            nodeElement9.setParent(nodeElement8);
                                        }

                                        if (item8.getNodeName() == null && item8.getNodeValue() != null) {
                                            nodeElement7.setValue(item8.getNodeValue());
                                        } else {
                                            childNodeList7.add(nodeElement8);
                                            nodeElement8.setChildren(childNodeList8);
                                        }
                                        nodeElement8.setParent(nodeElement7);
                                    }
                                    if (item7.getNodeName() == null && item7.getNodeValue() != null) {
                                        nodeElement6.setValue(item7.getNodeValue());
                                    } else {
                                        childNodeList6.add(nodeElement7);
                                        nodeElement7.setChildren(childNodeList7);
                                    }
                                    nodeElement7.setParent(nodeElement6);
                                }
                                if (item6.getNodeName() == null && item6.getNodeValue() != null) {
                                    nodeElement5.setValue(item6.getNodeValue());
                                } else {
                                    childNodeList5.add(nodeElement6);
                                    nodeElement6.setChildren(childNodeList6);
                                }
                                nodeElement6.setParent(nodeElement5);
                            }
                            if (item5.getNodeName() == null && item5.getNodeValue() != null) {
                                nodeElement4.setValue(item5.getNodeValue());
                            } else {
                                childNodeList4.add(nodeElement5);
                                nodeElement5.setChildren(childNodeList5);
                            }
                            nodeElement5.setParent(nodeElement4);
                        }
                        if (item4.getNodeName() == null && item4.getNodeValue() != null) {
                            nodeElement3.setValue(item4.getNodeValue());
                        } else {
                            childNodeList3.add(nodeElement4);
                            nodeElement4.setChildren(childNodeList4);
                        }
                        nodeElement4.setParent(nodeElement3);
                    }
                    if (item3.getNodeName() == null && item3.getNodeValue() != null) {
                        nodeElement2.setValue(item3.getNodeValue());
                    } else {
                        childNodeList2.add(nodeElement3);
                        nodeElement3.setChildren(childNodeList3);
                    }
                    nodeElement3.setParent(nodeElement2);
                }
                if (item2.getNodeName() == null && item2.getNodeValue() != null) {
                    nodeElement1.setValue(item2.getNodeValue());
                } else {
                    childNodeList1.add(nodeElement2);
                    nodeElement2.setChildren(childNodeList2);
                }
                nodeElement2.setParent(nodeElement1);
            }
            nodeElement1.setChildren(childNodeList1);
            nodeElementList.add(nodeElement1);
        }

        return nodeElementList;
    }

    private List<NodeElement> getNodeList() {
        List<NodeElement> nodeElementList = new ArrayList<NodeElement>();

        get(messageElement, nodeElementList);
        return nodeElementList;
    }

    private List<NodeElement> get(Node node, List<NodeElement> nodeElementList) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node childNode = node.getChildNodes().item(i);

            nodeElementList.add(getNodeElement(childNode));
            if (childNode.getChildNodes().getLength() > 0) {
                return get(childNode, nodeElementList);
            }
        }
        return nodeElementList;
    }

    private NodeElement getNodeElement(Node node) {
        NodeElement nodeElement = new NodeElement();

        if (node.getNodeName() != null) {
            nodeElement.setName(node.getNodeName());
        }

        if (node.getNodeValue() != null) {
            nodeElement.setName(node.getNodeValue());
        }

        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node attribute = node.getAttributes().item(i);
            nodeElement.setAttribute(attribute.getNodeName(), attribute.getNodeValue());
        }
        return nodeElement;
    }

    private List<NodeElement> gegt(Node node) {
        List<NodeElement> nodeElementList = new ArrayList<NodeElement>();
        NodeElement parentNodeElement = getNodeElement(node);
        List<NodeElement> childNodeElementList = new ArrayList<NodeElement>();
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node childNode = node.getChildNodes().item(i);
            NodeElement childNodeElement = getNodeElement(childNode);
            childNodeElement.setParent(parentNodeElement);
            childNodeElementList.add(childNodeElement);
        }
        parentNodeElement.setChildren(childNodeElementList);
        nodeElementList.add(parentNodeElement);
        return nodeElementList;
    }
}
