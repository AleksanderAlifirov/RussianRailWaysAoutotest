package specs.startPageSpecs.headerPartTest

import pages.RzdStartPage
import rzd.RzdSpec
import spock.lang.Stepwise

@Stepwise
class HeaderElementsSpec extends RzdSpec {

    def "Проверить корректное отображение элементов заголовка."() {
        given:
        открытьСтартовуюСтраницу()
        when:
        def view = at RzdStartPage
        then:
        view.Меню_Заголовка.МобильнаяВерсия.displayed
        println "   Ссылка 'Мобильная версия' присутствует в заголовке."
        view.Меню_Заголовка.ВерсияДляСВ.displayed
        println "   Ссылка 'Версия для слабовидящих' присутствует в заголовке."
        view.Меню_Заголовка.КартаСайта.displayed
        println "   Ссылка 'Карта сайта' присутствует в заголовке."
        view.Меню_Заголовка.ГлавнаяСтраница.displayed
        println "   Ссылка 'Главная страница' присутствует в заголовке."
        view.Меню_Заголовка.ОтправитьПисьмо.displayed
        println "   Ссылка 'Отправить письмо' присутствует в заголовке."
        view.Меню_Заголовка.О_Компании.displayed
        println "   Ссылка 'О компании' присутствует в заголовке."
        view.Меню_Заголовка.Контакты.displayed
        println "   Ссылка 'Контакты' присутствует в заголовке."
        view.Меню_Заголовка.Тендеры.displayed
        println "   Ссылка 'Тендеры' присутствует в заголовке."
        view.Меню_Заголовка.Пресс_Центр.displayed
        println "   Ссылка 'Пресс-центр' присутствует в заголовке."
        view.Меню_Заголовка.Инвесторам.displayed
        println "   Ссылка 'Инвесторам' присутствует в заголовке."
    }
}
