package com.actionmedia.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: n.tyukavkin
 * Date: 11.12.13
 * Time: 16:19
 */
public class KBK {

    List<PaymentName> paymentNameList = new ArrayList<PaymentName>();
    List<Type> typeList = new ArrayList<Type>();

    public KBK(WebElement table) {

        WebElement head = table.findElement(By.tagName("thead"));
        List<WebElement> typeTdList = head.findElements(By.tagName("td"));
        for (int i = 1; i < typeTdList.size(); i++) {
            String typeName = typeTdList.get(i).getText();
            typeList.add(new Type(typeName));
        }

        WebElement body = table.findElement(By.tagName("tbody"));
        List<WebElement> trList = body.findElements(By.tagName("tr"));
        Map<String, Integer[]> map = new HashMap<String, Integer[]>();
        boolean isFirstIndex = false;
        boolean isLastIndex = false;
        int firstIndex = 0;
        int lastIndex = 0;
        String sectionName = "";
        for (int i = 0; i < trList.size(); i++) {
            WebElement tr = trList.get(i);

            WebElement nextTr;
            if (i + 1 < trList.size()) {
                nextTr = trList.get(i + 1);
            } else {
                nextTr = null;
            }

            if (tr.getAttribute("align") != null && "center".equals(tr.getAttribute("align")) && !isFirstIndex) {
                sectionName = tr.getText();
                firstIndex = i + 1;
                isFirstIndex = true;
                continue;
            }

            if (nextTr != null && nextTr.getAttribute("align") != null && "center".equals(nextTr.getAttribute("align")) && !isLastIndex || nextTr == null) {
                lastIndex = i;
                isLastIndex = true;
            }

            if (isFirstIndex && isLastIndex) {
                isFirstIndex = false;
                isLastIndex = false;
                map.put(sectionName, new Integer[]{firstIndex, lastIndex});
            }
        }

        for (Map.Entry<String, Integer[]> entry : map.entrySet()) {
            String section = entry.getKey();
            Integer[] index = entry.getValue();
            for (int i = index[0]; i <= index[1]; i++) {
                List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
                String paymentName = tdList.get(0).getText();
                List<String> kbkList = new ArrayList<String>();
                if (section.contains("Государственная пошлина **")) {
                    for (int j = 0; j < 3; j++) {
                        kbkList.add(tdList.get(1).getText());
                    }
                    paymentNameList.add(new PaymentName(section, paymentName, kbkList));
                } else if (tdList.size() == 2) {
                    List<String> kbkListPtags = new ArrayList<String>();
                    List<String> typeList = new ArrayList<String>();
                    List<WebElement> pTags = tdList.get(1).findElements(By.tagName("p"));
                    for (int p = 0; p < pTags.size(); p++) {
                        WebElement pElement = pTags.get(p);
                        if (pElement.getText().contains("(")) {
                            String kbk = pElement.getText().split("\\(")[0].trim();
                            String type = pElement.getText().split("\\(")[1].split("\\)")[0].trim();
                            kbkListPtags.add(kbk);
                            typeList.add("КБК для перечисления платежа " + type);
                        } else if (!pElement.getText().contains("или")) {
                            String kbk = pElement.getText().trim();
                            String type = "КБК для перечисления платежа";
                            kbkListPtags.add(kbk);
                            typeList.add(type);
                        }
                        paymentNameList.add(new PaymentName(section, paymentName, typeList, kbkListPtags));
                    }
                } else {
                    for (int j = 1; j < tdList.size(); j++) {
                        kbkList.add(tdList.get(j).getText());
                    }
                    paymentNameList.add(new PaymentName(section, paymentName, kbkList));
                }
            }
        }
    }

    public List<PaymentName> getPaymentNameList() {
        return paymentNameList;
    }

    public void setPaymentNameList(List<PaymentName> paymentNameList) {
        this.paymentNameList = paymentNameList;
    }

    public String getPaymentTypeByKBK(String kbk) {
        for (PaymentName paymentName : paymentNameList) {
            for (int i = 0; i < paymentName.getPaymentTypeList().size(); i++) {
                PaymentType paymentType = paymentName.getPaymentTypeList().get(i);
                if (paymentType.getKbk().equals(kbk)) {
                    return paymentType.getType().getName();
                }
                if (paymentType.getKbk().contains(kbk)) {
                    return paymentType.getType().getName();
                }
            }
        }
        return null;
    }

    public PaymentName getPaymentNameByKBK(String kbk) {
        for (PaymentName paymentName : paymentNameList) {
            for (PaymentType paymentType : paymentName.getPaymentTypeList()) {
                if (paymentType.getKbk().equals(kbk)) {
                    return paymentName;
                }
                if (paymentType.getKbk().contains(kbk)) {
                    return paymentName;
                }
            }
        }
        return null;
    }

    public String getSectionNameByKBK(String kbk) {
        return getPaymentNameByKBK(kbk).getSectionName();
    }

    public Value getValueByKbk(String kbk) {
        return new Value(kbk);
    }

    public class PaymentName {

        String sectionName;
        String name;
        List<PaymentType> paymentTypeList = new ArrayList<PaymentType>();

        PaymentName(String sectionName, String name, List<String> kbkList) {
            this.sectionName = sectionName;
            this.name = name;
            for (int i = 0; i < kbkList.size(); i++) {
                this.paymentTypeList.add(new PaymentType(typeList.get(i), kbkList.get(i)));
            }
        }

        PaymentName(String sectionName, String name, List<String> typeList, List<String> kbkList) {
            this.sectionName = sectionName;
            this.name = name;
            for (int i = 0; i < kbkList.size(); i++) {
                this.paymentTypeList.add(new PaymentType(new Type(typeList.get(i)), kbkList.get(i)));
            }
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<PaymentType> getPaymentTypeList() {
            return paymentTypeList;
        }

        public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
            this.paymentTypeList = paymentTypeList;
        }
    }

    public class PaymentType {

        Type type;
        String kbk;

        PaymentType(Type type, String kbk) {
            this.type = type;
            this.kbk = kbk;
        }

        PaymentType(String kbk) {
            this.kbk = kbk;
        }

        public String getKbk() {
            return kbk;
        }

        public void setKbk(String kbk) {
            this.kbk = kbk;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    public class Type {
        String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Value {
        String kbk;
        String paymentName;
        String section;
        String formattedKbk;
        String type;

        Value(String kbk) {
            this.formattedKbk = getFormattedKbk(kbk);
            this.kbk = formattedKbk;
            this.paymentName = getPaymentNameByKBK(formattedKbk).getName();
            this.section = getSectionNameByKBK(formattedKbk);
            this.type = getPaymentTypeByKBK(formattedKbk);
        }

        public String getKbk() {
            return kbk;
        }

        public void setKbk(String kbk) {
            this.kbk = kbk;
        }

        public String getPaymentName() {
            return paymentName;
        }

        public void setPaymentName(String paymentName) {
            this.paymentName = paymentName;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String getFormattedKbk(String kbk) {
            kbk = kbk.replaceAll(" ", "");
            char[] arr = kbk.toCharArray();

            String formattedKbk = String.format("%s %s %s %s %s %s %s",
                    getValueString(arr[0]) + getValueString(arr[1]) + getValueString(arr[2]),
                    getValueString(arr[3]),
                    getValueString(arr[4]) + getValueString(arr[5]),
                    getValueString(arr[6]) + getValueString(arr[7]) + getValueString(arr[8]) + getValueString(arr[9]) + getValueString(arr[10]),
                    getValueString(arr[11]) + getValueString(arr[12]),
                    getValueString(arr[13]) + getValueString(arr[14]) + getValueString(arr[15]) + getValueString(arr[16]),
                    getValueString(arr[17]) + getValueString(arr[18]) + getValueString(arr[19]));

            return formattedKbk;
        }

        private String getValueString(char chararcter) {
            return String.valueOf(chararcter);
        }
    }
}
