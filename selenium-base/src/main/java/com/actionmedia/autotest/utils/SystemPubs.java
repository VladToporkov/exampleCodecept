package com.actionmedia.autotest.utils;

import com.actionmedia.autotest.spring.SeleniumSettings;

import java.util.ArrayList;
import java.util.List;

public enum SystemPubs {

    bss(6, "БСС КУ", "БСС"),
    bss_ku(6, "БСС КУ", "БСС"),
    bss_bu(7, "БСС БУ", "БСС"),
    bss_usn(8, "БСС УСН", "БСС"),
    bss_vip(9, "БСС ВИП", "БСС"),
    bss_otchet(18, "БСС Отчет", "БСС"),

    kss(10, "КСС КУ", "КСС"),
    kss_bu(12, "КСС БУ", "КСС"),
    kss_vip(16, "КСС ВИП", "КСС"),

    uss(11, "ЮСС КУ", "ЮСС"),
    uss_vip(17, "ЮСС КД", "ЮСС"),
    uss_bu(17, "ЮСС БУ", "ЮСС"),

    fss(14, "ФСС КУ", "ФСС"),

    gf(21, "ГФ", "Госфинансы"),
    gf_vip(25, "ГФ Вип", "Госфинансы"),

    ehs_mini(50, "МЦФЭР ОТ (б)", "Охрана труда"),
    ehs(67, "МЦФЭР ОТ (о)", "Охрана труда"),
    ehs_vip(68, "МЦФЭР ОТ (п)", "Охрана труда"),
    ehs_bu(79, "МЦФЭР ОТ БУ", "Охрана труда"),

    edu(51, "МЦФЭР ОБР (о)", "Образование"),
    edu_vip(52, "МЦФЭР ОБР (п)", "Образование"),
    edu_mini(53, "МЦФЭР ОБР (б)", "Образование"),

    elpu(54, "МЦФЭР ЭЛПУ (о)", "ЭЛПУ"),
    elpu_vip(55, "МЦФЭР ЭЛПУ (п)", "ЭЛПУ"),

    klpu(56, "МЦФЭР КЛПУ (о)", "КЛПУ"),
    klpu_vip(57, "МЦФЭР КЛПУ (п)", "КЛПУ"),

    cult(59, "МЦФЭР Культура (о)", "Культура"),
    cult_vip(60, "МЦФЭР Культура (п)", "Культура"),

    go_mini(61, "МЦФЭР ГЗ (б)", "Госзаказ"),
    go(62, "МЦФЭР ГЗ (о)", "Госзаказ"),
    go_vip(63, "МЦФЭР ГЗ (п)", "Госзаказ"),

    umd_mini(71, "МЦФЭР УМД (б)", "УМД"),
    umd(72, "МЦФЭР УМД (о)", "УМД"),
    umd_vip(73, "МЦФЭР УМД (п)", "УМД"),

    expertus_k(74, "EX: Кадри (о)", "EX: Кадри"),
    expertus_k_vip(75, "EX: Кадри (п)", "EX: Кадри"),

    expertus_gl(80, "EX: Головбух (о)", "EX: Головбух"),
    expertus_gl_vip(81, "EX: Головбух (п)", "EX: Головбух"),

    actualis_edu_mini(76, "ACT: Образование (б)", "ACT: Образование"),
    actualis_edu(77, "ACT: Образование (о)", "ACT: Образование"),
    actualis_edu_vip(78, "ACT: Образование (п)", "ACT: Образование"),

    actualis_gz_zak(87, "ACT: Госзакупки (б)", "ACT: Госзакупки"),
    actualis_gz(88, "ACT: Госзакупки (о)", "ACT: Госзакупки"),
    actualis_gz_vip(89, "ACT: Госзакупки (п)", "ACT: Госзакупки"),

    actualis_k_mini(84, "ACT: Кадровое дело (б)", "ACT: Кадровое дело"),
    actualis_k(85, "ACT: Кадровое дело (о)", "ACT: Кадровое дело"),
    actualis_k_vip(86, "ACT: Кадровое дело (п)", "ACT: Кадровое дело"),

    localhost(-1, "localhost", "localhost");

    private int pubId;
    private String description;
    private String systemName;

    SystemPubs(int pubId, String description, String systemName) {
        this.pubId = pubId;
        this.description = description;
        this.systemName = systemName;
    }

    public int getPubId() {
        return pubId;
    }

    public String getDescription() {
        return description;
    }

    public String getSystemName() {
        return systemName;
    }

    public static int getPubId(SeleniumSettings settings, String currentUrl) {
        if (settings.isRunBss()) {
            if (currentUrl.contains("vip")) {
                return bss_vip.getPubId();
            } else if (currentUrl.contains("budget") || currentUrl.contains("bu")) {
                return bss_bu.getPubId();
            } else if (currentUrl.contains("usn") || currentUrl.contains("u.")) {
                return bss_usn.getPubId();
            } else {
                return bss.getPubId();
            }
        } else if (settings.isRunKss()) {
            if (currentUrl.contains("vip")) {
                return kss_vip.getPubId();
            } else if (currentUrl.contains("budget") || currentUrl.contains("bu")) {
                return kss_bu.getPubId();
            } else {
                return kss.getPubId();
            }
        } else if (settings.isRunUss()) {
            if (currentUrl.contains("vip")) {
                return uss_vip.getPubId();
            } else {
                return uss.getPubId();
            }
        } else if (settings.isRunFss()) {
            return fss.getPubId();
        } else {
            return -1;
        }
    }

    public static SystemPubs getSystemPubsById(int id) {
        for (SystemPubs systemPubs : values()) {
            if (systemPubs.getPubId() == id) {
                return systemPubs;
            }
        }
        throw new IllegalArgumentException("Неверный pubID - " + id);
    }

    public static List<SystemPubs> getSystemPubsBySystemName(String systemName) {
        List<SystemPubs> systemPubsList = new ArrayList<SystemPubs>();
        for (SystemPubs systemPubs : values()) {
            if (systemPubs.getSystemName().equals(systemName)) {
                systemPubsList.add(systemPubs);
            }
        }
        return systemPubsList;
    }
}
