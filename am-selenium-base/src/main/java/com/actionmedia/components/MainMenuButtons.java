package com.actionmedia.components;

import org.openqa.selenium.By;

/**
 * User: n.tyukavkin
 * Date: 11.02.14
 * Time: 12:30
 */
public enum MainMenuButtons {

    RECOMEND {
        @Override
        public By getButtonLocator() {
            return By.xpath(".//*[contains(@class,'recomend') or contains(@class,'recommend')]");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'recomend') or contains(@href,'recommend')]");
        }

        @Override
        public String getName() {
            return "Рекомендации";
        }
    },
    ANSWERS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='answers']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'answers')]");
        }


        @Override
        public String getName() {
            return "Ответы";
        }
    },
    LAW_BASE {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='law']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'law')]");
        }

        @Override
        public String getName() {
            return "Правовая база";
        }
    },
    LAW_PRACTICE {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='lawpractice']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'lawpractice')]");
        }

        @Override
        public String getName() {
            return "Судебная практика";
        }
    },
    FORMS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='forms']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'forms')]");
        }

        @Override
        public String getName() {
            return "Формы";
        }
    },
    DICTIONARY {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='handbook']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'handbook')]");
        }

        @Override
        public String getName() {
            return "Справочник";
        }
    },
    DICTIONARIES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='handbook']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'handbook')]");
        }

        @Override
        public String getName() {
            return "Справочники";
        }
    },
    MAGAZINES_AND_BOOKS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='press']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'press')]");
        }

        @Override
        public String getName() {
            return "Журналы и книги";
        }
    },
    MAGAZINES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='press']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'press')]");
        }

        @Override
        public String getName() {
            return "Журналы";
        }
    },
    VIDEO {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='video']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'video')]");
        }

        @Override
        public String getName() {
            return "Видео";
        }
    },
    SERVICES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='services']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'services')]");
        }

        @Override
        public String getName() {
            return "Сервисы";
        }
    },
    OTCHET {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='report']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return null;
        }

        @Override
        public String getName() {
            return "Отчеты";
        }
    },
    WIZARDS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='wizards']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'wizards')]");
        }

        @Override
        public String getName() {
            return "Мастера";
        }
    },
    EDU {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='education']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return null;
        }

        @Override
        public String getName() {
            return "Обучение";
        }
    },
    DOGOVOR {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='dogovor']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return null;
        }


        @Override
        public String getName() {
            return "Договоры";
        }
    },
    FSS_SOLUTIONS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/solutions/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'solutions')]");
        }

        @Override
        public String getName() {
            return "Решения";
        }
    },
    FSS_FORMS {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='forms']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'forms')]");
        }

        @Override
        public String getName() {
            return "Положения и регламенты";
        }
    },
    TEMPLATES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='forms']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'forms')]");
        }

        @Override
        public String getName() {
            return "Шаблоны";
        }
    },
    FSS_LAW_BASE {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/law/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'law')]");
        }

        @Override
        public String getName() {
            return "ПРАВОВАЯ БАЗА";
        }
    },
    FSS_DICTIONARY {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/handbook/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'handbook')]");
        }

        @Override
        public String getName() {
            return "Справочник";
        }
    },
    LIBRARY {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/press/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'press')]");
        }

        @Override
        public String getName() {
            return "Библиотека";
        }
    },
    FSS_VIDEO {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/videos/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'videos')]");
        }

        @Override
        public String getName() {
            return "Видео";
        }
    },
    FSS_SERVICES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[class*='services']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'services')]");
        }

        @Override
        public String getName() {
            return "Сервисы";
        }
    },
    KSS_SERVICES {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/service/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return By.xpath(".//*[contains(@href,'service')]");
        }

        @Override
        public String getName() {
            return "Обучение";
        }
    },
    RABOTARU {
        @Override
        public By getButtonLocator() {
            return By.cssSelector("[href*='/#/rabotaru/']");
        }

        @Override
        public By getLinkInFilterLocator() {
            return null;
        }

        @Override
        public String getName() {
            return "Подбор персонала";
        }
    },
    ABOUT {
        @Override
        public By getButtonLocator() { return By.cssSelector("[href*='/about/']"); }

        @Override
        public By getLinkInFilterLocator() {
            return null;
        }

        @Override
        public String getName() { return "О системе"; }
    };

    public abstract By getButtonLocator();

    public abstract By getLinkInFilterLocator();

    public abstract String getName();

    public static MainMenuButtons getSectionByName(String name) {
        for (MainMenuButtons menuButton : MainMenuButtons.values()) {
            if (menuButton.getName().equals(name)) {
                return menuButton;
            }
        }
        throw new IllegalArgumentException();
    }
}
