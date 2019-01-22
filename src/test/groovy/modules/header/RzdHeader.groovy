package modules.header

import org.openqa.selenium.By
import rzd.RzdModule

class RzdHeader extends RzdModule {

    static content = {

        def context = "//div[@id='headMenu']"

        МобильнаяВерсия { $(By.xpath("${context}//a[contains(@href, 'http://m.rzd.ru')]")) }
        ВерсияДляСВ { $(By.xpath("${context}//a[@title='Версия для слабовидящих']")) }
        КартаСайта { $(By.xpath("${context}//a[@title='Карта сайта']")) }
        ГлавнаяСтраница { $(By.xpath("${context}//a[@title='Главная страница']")) }
        ОтправитьПисьмо { $(By.xpath("${context}//a[@title='Отправить письмо']")) }

        О_Компании { $("a[href*='://']", text: 'О компании' )}
        Пресс_Центр { $(By.xpath("//a[contains(text(), 'Пресс-центр')]")) }
        Инвесторам { $(By.xpath("//a[contains(text(), 'Инвесторам')]")) }
        Тендеры { $(By.xpath("//a[contains(text(), 'Тендеры')]")) }
        Контакты { $(By.xpath("//a[contains(text(), 'Контакты')]")) }
        Пассажирам { $(By.xpath("${context}//a[text()='Пассажирам']")) }
        ГрузовыеПеревозки { $(By.xpath("${context}//a[text()='Грузовые перевозки']")) }
        РаботаВРЖД { $(By.xpath("${context}//a[text()='Работа в РЖД']")) }
        Моложежный { $(By.xpath("${context}//a[text()='Молодежный']")) }
    }

}
