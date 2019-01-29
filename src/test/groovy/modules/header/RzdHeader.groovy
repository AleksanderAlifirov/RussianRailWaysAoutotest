package modules.header

import org.openqa.selenium.By
import rzd.RzdModule

class RzdHeader extends RzdModule {

    static content = {

        def context = "//div[@id='headMenu']"

        АнглийскаяВерсия { $(By.xpath('//a[@href="http://eng.rzd.ru"]')) }
        МобильнаяВерсия { $(By.xpath("${context}//a[contains(@href, 'http://m.rzd.ru')]")) }
        ВерсияДляСВ { $(By.xpath("${context}//a[@title='Версия для слабовидящих']")) }
        КартаСайта { $(By.xpath("${context}//a[3]")) }
        ГлавнаяСтраница { $(By.xpath("${context}//a[@title='Главная страница']")) }
        ОтправитьПисьмо { $(By.xpath("${context}//a[@title='Отправить письмо']")) }
        RSS { $(By.xpath("${context}//a[6]")) }
        Все_сайты {$(By.xpath("${context}//a[contains(text(), 'Все сайты')]")) }
        Регистрация { $(By.xpath("//a[contains(text(), 'Регистрация')]")) }
        Вход { $(By.xpath("//a[contains(text(), 'Вход')]")) }
        О_Компании { $("a[href*='://']", text: 'О компании' )}
        Пресс_Центр { $(By.xpath("//a[contains(text(), 'Пресс-центр')]")) }
        Инвесторам { $(By.xpath("//a[contains(text(), 'Инвесторам')]")) }
        Тендеры { $(By.xpath("//a[contains(text(), 'Тендеры')]")) }
        Контакты { $(By.xpath("//a[contains(text(), 'Контакты')]")) }
        Пассажирам { $(By.xpath("${context}//a[text()='Пассажирам']")) }
        ГрузовыеПеревозки { $(By.xpath("${context}//a[text()='Грузовые перевозки']")) }
        РаботаВРЖД { $(By.xpath("${context}//a[text()='Работа в РЖД']")) }
        Молодежный { $(By.xpath("${context}//a[text()='Молодежный']")) }
    }

}
